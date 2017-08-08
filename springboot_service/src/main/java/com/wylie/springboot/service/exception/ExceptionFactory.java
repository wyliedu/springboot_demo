/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Used to create B2BBuyer Exceptions. This class is created when refactoring Exceptions.
 */
@Service
public class ExceptionFactory {
	@Autowired
	private ExceptionLabel exceptionLabel;

	/**
	 * @param msgCode
	 * @return BadRequestException
	 */
	public BadRequestException createBadRequestException(final String msgCode) {
		return new BadRequestException(msgCode, exceptionLabel.getMessage(msgCode));
	}

	/**
	 * Not time to fix all, have to create this deprecated method
	 *
	 * @param msgCode
	 * @return BadRequestException
	 * @deprecated Please use getBadRequestException(final String msgCode)
	 */
	@Deprecated
	public BadRequestException createBadRequestException(final String msgCode, final String locale) {
		return new BadRequestException(msgCode, exceptionLabel.getMessage(msgCode, locale));
	}


	/**
	 * @param msgCode
	 * @return NotFoundException
	 */
	public NotFoundException createNotFoundException(final String msgCode) {
		return new NotFoundException(msgCode, exceptionLabel.getMessage(msgCode));
	}

	/**
	 *
	 * @return NotFoundException
	 */
	public NotFoundException createGeneralNotFoundExceptioin() {
		return createNotFoundException("9000");
	}
}
