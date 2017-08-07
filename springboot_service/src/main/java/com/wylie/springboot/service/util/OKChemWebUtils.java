/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.wylie.springboot.service.enums.LangEnum;



/**
 *
 */
public abstract class OKChemWebUtils {

	/**
	 * Define LOCALE_EN
	 */
	public static final Locale LOCALE_EN = StringUtils.parseLocaleString(LangEnum.EN.getValue());
	/**
	 * Define LOCALE_ES
	 */
	public static final Locale LOCALE_ES = StringUtils.parseLocaleString(LangEnum.ES.getValue());
	/**
	 * Define LOCALE_PT
	 */
	public static final Locale LOCALE_PT = StringUtils.parseLocaleString(LangEnum.PT.getValue());

	public static final String OKCHEM = "okchem";

	public static final String HEADER_REFERER = "referer";


	private OKChemWebUtils() {
	}

	/**
	 * Get server name based on locale
	 *
	 * @param locale
	 * @param request
	 * @return language
	 */
/*	public static String getServerName(final String language, final HttpServletRequest request) {
		final String serverName = request.getServerName();
		String value = "";
		final String superDomain = org.apache.commons.lang.StringUtils.substringAfter(serverName, ".");
		if (LangEnum.EN.getValue().equals(language)) {
			value = "www." + superDomain;
		} else {
			value = language + "." + superDomain;
		}
		return value;
	}*/

	/**
	 * Whether or not the header referer contains 'okchem'
	 *
	 * @param request
	 * @return
	 */
	public static boolean isRefererOkchem(final HttpServletRequest request) {
		final String referer = request.getHeader(HEADER_REFERER);
		Boolean isRefererOkchem = false;
		if (!StringUtils.isEmpty(referer) && referer.contains(OKCHEM)) {
			isRefererOkchem = true;
		}
		return isRefererOkchem;
	}
}
