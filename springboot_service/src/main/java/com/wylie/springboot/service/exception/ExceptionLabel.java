/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.i18n.LocaleContextHolder;


/**
 * exception Label for exception process
 * 
 * @author Neil Wang 2016/5/4/
 */
@ConfigurationProperties(locations = "classpath:exceptionLabel.yml", prefix = "exception")
public class ExceptionLabel {
	private Map<String, String> code = new LinkedHashMap<String, String>();

	private String default_locale = "en";

	/**
	 * Get label by code
	 * 
	 * @param code
	 * @return
	 */
	public String getMessage(String code) {
		return getMessage(code, StringUtils.isBlank(LocaleContextHolder.getLocale().getLanguage()) ? default_locale : LocaleContextHolder.getLocale().getLanguage());
	}

	/**
	 * General method to get message. If there is no message for give locale, fall back to English.
	 * 
	 * @author Joe
	 * @param code
	 * @param locale
	 * @param args
	 * @return
	 */
	public String getMessage(final String code, final String locale, Object... args) {
		String message = "";
		if (!StringUtils.isBlank(locale)) {
			message = this.code.get(code + "." + locale.toLowerCase());
		}
		if (StringUtils.isBlank(message)) {
			message = this.code.get(code + "." + default_locale.toLowerCase());
		}
		return String.format(message, args);
	}

	public String getMessage(final String code, final String locale) {
		String message = "";
		if (!StringUtils.isBlank(locale)) {
			message = this.code.get(code + "." + locale.toLowerCase());
		}
		if (StringUtils.isBlank(message)) {
			message = this.code.get(code + "." + default_locale.toLowerCase());
		}

		return message;
	}

	/**
	 * @return the code
	 */
	public Map<String, String> getCode() {
		return code;
	}

	/**
	 * @param code
	 *           the code to set
	 */
	public void setCode(Map<String, String> code) {
		this.code = code;
	}

}
