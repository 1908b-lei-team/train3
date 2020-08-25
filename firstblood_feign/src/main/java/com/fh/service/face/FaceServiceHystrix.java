package com.fh.service.face;

import org.springframework.stereotype.Component;

@Component
public class FaceServiceHystrix implements FaceService {
    @Override
    public String demo() {
        return "404";
    }
}
