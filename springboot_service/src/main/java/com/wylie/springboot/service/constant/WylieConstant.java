package com.wylie.springboot.service.constant;

/**
 *  constant
 * 
 * @author Mark 2017/06/28
 */
public class WylieConstant {
	
	
	/**
	 * Constant for user login name in the http header
	 */
	public static final String HTTP_HEADER_USER_LOGIN_NAME = "userLogin";
	/**
	 * Constant for error code
	 */
	public static final String EXCEPTION_REPLY_CODE_NAME = "errorCode";
	/**
	 * Constant for error message
	 */
	public static final String EXCEPTION_REPLY_MSG_NAME = "errorMessage";

	/**
	 * Constant for unknown exception code
	 */

	public static final String EXCEPTION_UNKNOWN_CODE = "9999";
	/**
	 * Constant for validation exception code
	 */
	public static final String EXCEPTION_VALIDATION_CODE = "9998";
	/**
	 * define seperator, used for backend like market, etc
	 */
	public static final String SEPERATOR = ";";
	
	/**
	 * private constructor
	 */
	private WylieConstant() {
		super();
	}
}
