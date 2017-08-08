/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.exception;

/**
 * This should be a reusable exception for all INTERNAL_SERVER_ERROR.
 * 
 * @author Joe
 *
 */
public class InternalServerException extends AbstractException {

	/**
	 * @param msgCode
	 * @param msg
	 */
	public InternalServerException(String msgCode, String msg) {
		super(msgCode, msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375667880388728853L;

}
