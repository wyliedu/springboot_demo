package com.wylie.springboot.service.util;

import freemarker.template.Configuration;


/**
 * Freemarker Configuration
 * 
 * @author alan
 *
 */
public class FreemarkerConfiguration {
	/**
	 * Defines configuration
	 */
	private static Configuration config = null;

	/**
	 * @Title: getConfiguation
	 * @Description:
	 * @return
	 */
	public static synchronized Configuration getConfiguation() {
		if (config == null) {
			setConfiguation();
		}
		return config;
	}

	/**
	 * @Title: setConfiguation
	 * @Description:
	 */
	@SuppressWarnings("deprecation")
	private static void setConfiguation() {
		config = new Configuration();
		//String path = ResourceLoader.getPath("");
		config.setClassForTemplateLoading(FreemarkerConfiguration.class, "/templates");
	}
}
