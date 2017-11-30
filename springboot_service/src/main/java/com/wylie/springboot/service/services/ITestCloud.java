package com.wylie.springboot.service.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wylie.springboot.service.services.impl.ComputeClientHystrix;

@FeignClient(value ="eureka-client", fallback = ComputeClientHystrix.class)
public interface ITestCloud {

	@RequestMapping(method = RequestMethod.GET, value = "/testEureka")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
