package com.wylie.springboot.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.wylie.common.service.ITestService;

@Configuration
public class HessianServer {

	@Autowired
	private ITestService testService;

	@Bean(name = "/HelloWorldService")
	public HessianServiceExporter accountService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(testService);
		exporter.setServiceInterface(ITestService.class);
		return exporter;
	}
}
