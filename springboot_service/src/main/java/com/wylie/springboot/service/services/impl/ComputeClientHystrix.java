package com.wylie.springboot.service.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.wylie.springboot.service.services.ITestCloud;

@Component
public class ComputeClientHystrix implements ITestCloud{

	@Override
	public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return -9999;
	}

}
