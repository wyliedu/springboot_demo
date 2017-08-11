package com.wylie.springboot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 */
public class BasePageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BasePageController.class);
	
	/**
	 * Define news service
	 */
	@Autowired
	protected Environment env;

	/**
	 * Get current request host.(eg:www.okchem.com; es.okchem.com)
	 *
	 * @return rootURL
	 */
	@ModelAttribute("baseUrl")
	public String getBaseUrl(final HttpServletRequest request) {
		final String protocol = getSchema(request);
		String baseUrl = protocol + "://" + request.getServerName();
		final int port = request.getServerPort();
		if (port > 80) {
			baseUrl = baseUrl + ":" + port;
		}
		return baseUrl;
	}

	/**
	 * @param request
	 * @return Main site URL such as "www.okchem.com"
	 */
	@ModelAttribute("mainSiteUrl")
	public String getMainSiteUrl(final HttpServletRequest request) {
		final String protocol = getSchema(request);
		String baseUrl = protocol + "://www." + getSuperDomain(request);
		final int port = request.getServerPort();
		if (port > 80) {
			baseUrl = baseUrl + ":" + port;
		}
		return baseUrl;
	}

	protected String getSchema(final HttpServletRequest request) {
		return request.getHeader("X-Scheme") != null ? request.getHeader("X-Scheme") : request.getScheme();
	}

	protected String getSuperDomain(final HttpServletRequest request) {
		return StringUtils.substringAfter(request.getServerName(), ".");
	}

	/**
	 * Get social url
	 *
	 * @param request
	 *           HttpServletRequest
	 * @return socialURL
	 */
	public String getSocialURL(final HttpServletRequest request) {
		return request.getRequestURL().toString().replace("http:", "https:");
	}

	/**
	 * Get current language
	 *
	 * @return g-lan
	 */
	@ModelAttribute("g_lan")
	public String currentLanguage() {
		return LocaleContextHolder.getLocale().getLanguage();
	}

	/**
	 * Get Property value
	 *
	 * @param key
	 *           String
	 * @return
	 */
	protected String getPropertyValue(final String key) {
		return StringUtils.isNotBlank(env.getProperty(key)) ? env.getProperty(key) : "";
	}
}
