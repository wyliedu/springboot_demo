package com.wylie.springboot.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;


/**
 * Application environment
 * 
 * @author Kevin GUO Jul 14, 2016
 */
@Configuration
@Repository("applicationEnv")
public class ApplicaionEnvironment {

	/**
	 * Injects of application environment
	 */
	@Autowired
	private Environment application;

	/**
	 * Get the application property by key
	 * 
	 * @param key
	 * @return application property of the input key
	 * @author Kevin GUO
	 */
	public String get(String key) {
		return application.getProperty(key);
	}

	/**
	 * Get api domain, (used for apigateway)
	 * 
	 * @param domain
	 *           domain name
	 * @return domain information
	 * @author Kevin GUO
	 */
	public String getDomain(String domain) {
		return application.getProperty("domain." + domain);
	}

}
