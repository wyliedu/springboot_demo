/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.exception;

/**
 * This should be a reusable exception for all bad request.
 * 
 * @author Joe
 *
 */
public class BadRequestException extends AbstractException {

	/**
	 * @param msgCode
	 * @param msg
	 */
	public BadRequestException(String msgCode, String msg) {
		super(msgCode, msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375667880388728853L;

}
