package com.wylie.springboot.rest.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wylie.common.dto.CommonData;
import com.wylie.common.dto.IdData;
import com.wylie.springboot.service.constant.Constants;


/**
 * Base Controller is for each controller to extend in Sourcing, provides base success and error response
 *
 * MessageLabel provides methods for getting i18n label
 *
 * @author Neil Wang 2016/5/5
 */

public abstract class BaseController {
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	/**
	 * injects MessageLabel object for i18n labels
	 */


	/**
	 * common method to get success response
	 *
	 * @return common response object with success
	 */
	protected CommonData<IdData> getSuccessResponse(final Long id) {
		return new CommonData<IdData>(new IdData(id));
	}



	public CommonData<Object> getSuccessOutPojo(final Object obj) {

		final CommonData<Object> responsePojo = new CommonData<Object>();
		responsePojo.setData(obj);
		return responsePojo;
	}

	/**
	 * Get locale from Session
	 *
	 * @param request
	 *           HttpServletRequest
	 * @return
	 */
	public String getLocale(final HttpServletRequest request) {
		final Locale locale = LocaleContextHolder.getLocale();
		if (locale == null) {
			return Constants.DEFAULT_LOCALE_EN;
		} else {
			return locale.getLanguage();
		}
	}

	/**
	 * get success out pojo
	 *
	 * @param obj
	 * @return
	 */
	public CommonData<Object> getSuccessOut() {

		final CommonData<Object> responsePojo = new CommonData<Object>();
		return responsePojo;
	}
}
