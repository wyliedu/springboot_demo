package com.wylie.springboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wylie.common.dto.CommonData;
import com.wylie.springboot.service.services.ITestCloud;

@RestController
public class TestCloudController extends BaseController{

	@Autowired
	ITestCloud iTestCloud;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<CommonData<Object>> add() {
        Integer result = this.iTestCloud.add(1, 2);
        return ResponseEntity.ok(getSuccessOutPojo(result));
    }

}
