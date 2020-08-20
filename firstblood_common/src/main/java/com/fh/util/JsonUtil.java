package com.fh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUtil {

    //对象转换为json工具

    /**
     * @param response 请求响应对象
     * @param object   转换为json格式的对象
     */
    public static void outJson(HttpServletResponse response, Object object) {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        ObjectMapper mapper = new ObjectMapper();
        try {
            ServletOutputStream os = response.getOutputStream();

            //JSON工具的核心代码，把object转换为json字符串格式
            //map.put("code", "12345"); ==》  {"code":"12345"}
            String jsonStr = mapper.writeValueAsString(object);
            System.out.println(jsonStr);
            //把json数据返回前端
            os.print(jsonStr);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
