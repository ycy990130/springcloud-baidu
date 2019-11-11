package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "provider-feign",fallback =UserServiceError.class )
public interface UserServiceFeign {
    @RequestMapping("queryUser")
    Map<String, Object> queryUser(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows, @SpringQueryMap User user);
}
