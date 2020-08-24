package com.fh.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.fh.common.ServerResponse;
import com.fh.domain.User;
import com.fh.dto.FaceSearchResDto;
import com.fh.dto.ProcessInfo;
import com.fh.domain.UserFaceInfo;
import com.fh.service.FaceEngineService;
import com.fh.service.UserFaceInfoService;
import com.fh.dto.FaceUserInfo;
import com.arcsoft.face.FaceInfo;
import com.fh.service.login.LoginService;
import com.fh.util.JwtUtil;
import com.fh.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("face")
public class FaceController {
    @Autowired
    private LoginService loginService;
    public final static Logger logger = LoggerFactory.getLogger(FaceController.class);
    @Autowired
    FaceEngineService faceEngineService;

    @Autowired
    UserFaceInfoService userFaceInfoService;

    @RequestMapping(value = "/demo")
    @ResponseBody
    public String demo() {
        return "demo";
    }

    /*
    人脸添加
     */
    @RequestMapping(value = "/faceAdd", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse faceAdd(@RequestParam("file") String file, @RequestParam("groupId") Integer groupId, @RequestParam("name") String name) {
        if("".equals(name)){
            //return Results.newFailedResult("姓名为空");
            return ServerResponse.errorMethod("姓名为空");
        }
        UserFaceInfo userFaceInfoDb = faceEngineService.findFaceInfoByName(name);
        if(userFaceInfoDb != null){
            //return Results.newFailedResult("该姓名已人脸注册");
            return ServerResponse.errorMethod("该姓名已人脸注册");
        }
        try {
            if (file == null) {
                //return Results.newFailedResult("file is null");
                return ServerResponse.errorMethod("file is null");
            }
            if (groupId == null) {
                //return Results.newFailedResult("groupId is null");
                return ServerResponse.errorMethod("groupId is null");
            }
            if (name == null) {
                //return Results.newFailedResult("name is null");
                return ServerResponse.errorMethod("name is null");
            }

            byte[] decode = Base64.decode(base64Process(file));
            ImageInfo imageInfo = ImageFactory.getRGBData(decode);

            //人脸特征获取
            byte[] bytes = faceEngineService.extractFaceFeature(imageInfo);
            if (bytes == null) {
                //return Results.newFailedResult(ErrorCodeEnum.NO_FACE_DETECTED);
                return ServerResponse.errorMethod("无人脸识别特征");
            }

            UserFaceInfo userFaceInfo = new UserFaceInfo();
            userFaceInfo.setName(name);
            userFaceInfo.setGroupId(groupId);
            userFaceInfo.setFaceFeature(bytes);
            userFaceInfo.setFaceId(RandomUtil.randomString(10));

            //人脸特征插入到数据库
            userFaceInfoService.insertSelective(userFaceInfo);

            logger.info("faceAdd:" + name);
            //return Results.newSuccessResult("");
            return ServerResponse.successMethod("人脸特征插入成功");
        } catch (Exception e) {
            logger.error("", e);
        }
        //return Results.newFailedResult(ErrorCodeEnum.UNKNOWN);
        return ServerResponse.errorMethod("人脸特征插入error");
    }

    /*
    人脸识别
     */
    @RequestMapping(value = "/faceSearch", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse faceSearch(String file, Integer groupId) throws Exception {

        if (groupId == null) {
            return ServerResponse.errorMethod("groupId is null");
        }
        byte[] decode = Base64.decode(base64Process(file));
        BufferedImage bufImage = ImageIO.read(new ByteArrayInputStream(decode));
        ImageInfo imageInfo = ImageFactory.bufferedImage2ImageInfo(bufImage);


        //人脸特征获取
        byte[] bytes = faceEngineService.extractFaceFeature(imageInfo);
        if (bytes == null) {
            return ServerResponse.errorMethod("无人脸识别特征");
        }
        //人脸比对，获取比对结果
        List<FaceUserInfo> userFaceInfoList = faceEngineService.compareFaceFeature(bytes, groupId);
        if (CollectionUtil.isNotEmpty(userFaceInfoList)) {
            FaceUserInfo faceUserInfo = userFaceInfoList.get(0);
            FaceSearchResDto faceSearchResDto = new FaceSearchResDto();
            BeanUtil.copyProperties(faceUserInfo, faceSearchResDto);
            List<ProcessInfo> processInfoList = faceEngineService.process(imageInfo);
            if (CollectionUtil.isNotEmpty(processInfoList)) {
                //人脸检测
                List<FaceInfo> faceInfoList = faceEngineService.detectFaces(imageInfo);
                int left = faceInfoList.get(0).getRect().getLeft();
                int top = faceInfoList.get(0).getRect().getTop();
                int width = faceInfoList.get(0).getRect().getRight() - left;
                int height = faceInfoList.get(0).getRect().getBottom() - top;

                Graphics2D graphics2D = bufImage.createGraphics();
                graphics2D.setColor(Color.RED);//红色
                BasicStroke stroke = new BasicStroke(5f);
                graphics2D.setStroke(stroke);
                graphics2D.drawRect(left, top, width, height);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufImage, "jpg", outputStream);
                byte[] bytes1 = outputStream.toByteArray();
                faceSearchResDto.setImage("data:image/jpeg;base64," + Base64Utils.encodeToString(bytes1));
                //faceSearchResDto.setAge(processInfoList.get(0).getAge());
                faceSearchResDto.setGender(processInfoList.get(0).getGender().equals(1) ? "女士" : "先生");
            }
            ServerResponse serverResponse = loginService.queryByUserName(faceSearchResDto.getName());

            if(serverResponse.getData() == null){
                return ServerResponse.errorMethod("人脸信息不存在");
            }


            User user = new User();

            Map map1 = (Map) serverResponse.getData();
            String id = map1.get("id").toString();
            user.setId(Integer.valueOf(id));
            user.setUsername(map1.get("username").toString());
            //这里写生成token消息，以及加入redis 操作
            //TokenUtil.
            String token = null;
            try {
                String jsonString = JSONObject.toJSONString(user);
                String encode = URLEncoder.encode(jsonString, "utf-8");
                token = JwtUtil.sign(encode);
                RedisUtil.set(token,token,30*60*1000);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("token",token);
                map.put("faceSearchResDto",faceSearchResDto);
                return ServerResponse.successMethod(map);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return ServerResponse.errorMethod("人脸不匹配");
    }


   /* @RequestMapping(value = "/detectFaces", method = RequestMethod.POST)
    @ResponseBody
    public List<FaceInfo> detectFaces(String image) throws IOException {
        byte[] decode = Base64.decode(image);
        InputStream inputStream = new ByteArrayInputStream(decode);
        ImageInfo imageInfo = ImageFactory.getRGBData(inputStream);

        if (inputStream != null) {
            inputStream.close();
        }
        List<FaceInfo> faceInfoList = faceEngineService.detectFaces(imageInfo);

        return faceInfoList;
    }*/


    private String base64Process(String base64Str) {
        if (!StringUtils.isEmpty(base64Str)) {
            String photoBase64 = base64Str.substring(0, 30).toLowerCase();
            int indexOf = photoBase64.indexOf("base64,");
            if (indexOf > 0) {
                base64Str = base64Str.substring(indexOf + 7);
            }

            return base64Str;
        } else {
            return "";
        }
    }
}
