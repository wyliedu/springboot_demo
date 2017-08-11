/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wylie.springboot.service.services.ApplicaionEnvironment;


/**
 * 
 * myself define RestTemplate
 * 
 * @author: mark.feng
 * @date: 2016/8/10
 */
@Component
public class RemoteRestTemplate {

	/*
	 * inject ApplicaionEnvironment object
	 */
	@Autowired
	private ApplicaionEnvironment applicationEnv;

	/**
	 * 
	 * create RestTemplate Instance
	 * 
	 * @author: mark.feng
	 * @date: 2016/8/10
	 */
	public RestTemplate restTemplate() {
		return new RestTemplate(clientHttpRequestFactory());
	}

	/**
	 * set time out time
	 * 
	 * @return
	 * @author: mark.feng
	 * @date: 2016/8/10
	 */
	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(Integer.parseInt(applicationEnv.get("read_time_out")));
		factory.setConnectTimeout(Integer.parseInt(applicationEnv.get("connect_time_out")));
		return factory;
	}
}
