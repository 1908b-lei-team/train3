package com.fh.service.capital;

import com.fh.common.ServerResponse;
import com.fh.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "capital",fallback = CapitalServiceHystrix.class)
public interface CapitalService {
    @RequestMapping("control/queryCheckInfo")
    ServerResponse queryCheckInfo(@RequestParam("id") Integer id);
    @RequestMapping("demo/test1")
    String test1(@RequestBody User user);
}
