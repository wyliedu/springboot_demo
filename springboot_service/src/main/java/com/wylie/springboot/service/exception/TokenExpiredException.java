/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * This should be a reusable exception for all UNAUTHORIZED.
 *
 * @author Gordon
 *
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class TokenExpiredException extends AbstractException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7868383642623054926L;

	/**
	 * Constructor
	 *
	 * @param msgCode
	 *           String
	 * @param msg
	 *           String
	 */
	public TokenExpiredException(final String msgCode, final String msg) {
		super(msgCode, msg);
	}
}
