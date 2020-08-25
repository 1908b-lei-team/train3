package com.fh.service.face;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "face",fallback = FaceServiceHystrix.class)
public interface FaceService {
    @RequestMapping("face/demo")
    String demo();

}
