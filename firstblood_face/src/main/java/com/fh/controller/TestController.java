package com.fh.controller;

import com.fh.domain.UserFaceInfo;
import com.fh.mapper.MybatisUserFaceInfoMapper;
import com.fh.service.face.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("test")
public class TestController {

     @Autowired
    private FaceService faceService;
    @RequestMapping("test")
     public String test(){
         return faceService.demo();
     }
}
