/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wylie.common.dto.BastDTOData;
import com.wylie.springboot.service.constant.WylieConstant;



/**
 * Global Exception Advice全局异常处理类
 *
 * @author Neil Wang 2016/5/4
 */
@ControllerAdvice(basePackages = "com.wylie.springboot.rest")
@EnableConfigurationProperties({ ExceptionLabel.class })
public class GlobalExceptionAdvice {
	/**
	 * define logger object for the class
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	/**
	 * Injects of exception label
	 */
	@Autowired
	private ExceptionLabel exceptionLabel;




	/**
	 * Global exception handler for MethodArgumentNotValidException
	 *
	 * @param e
	 *           exception
	 * @return response with errorCode and errorMessage
	 * @author Neil WANG
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseBody
	public BastDTOData notValidException(final MethodArgumentNotValidException e) {
		LOGGER.error(e.getMessage(), e);
		final BastDTOData baseData = new BastDTOData();
		final String errorMsg = exceptionLabel.getMessage(WylieConstant.EXCEPTION_VALIDATION_CODE);
		baseData.setMsg(errorMsg + getErrorMsgContent(e));
		baseData.setMsgCode(WylieConstant.EXCEPTION_VALIDATION_CODE);
		baseData.setSuccess(false);
		return baseData;
	}


	/**
	 * An reusable exception handler to handler general B2BBuyerException.
	 *
	 * @author Joe
	 * @param e
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public BastDTOData badRequestHandler(final BadRequestException e) {
		return getErrorResponse(e.getMsgCode(), e.getMsg());
	}

	/**
	 * A reusable General Internal Server error handler
	 *
	 * @author Joe
	 * @param e
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerException.class)
	@ResponseBody
	public BastDTOData internalExceptionHandler(final InternalServerException e) {
		LOGGER.error(e.getMsg(), e);
		return getErrorResponse(e.getMsgCode(), e.getMsg());
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public BastDTOData notFoundExceptionHandler(final NotFoundException e) {
		return getErrorResponse(e.getMsgCode(), e.getMsg());
	}

	/**
	 *
	 * Global exception handler for HttpMessageNotReadableException
	 *
	 * @date 2016/9/7
	 * @author peter.li
	 * @param e
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseBody
	public BastDTOData invalidFormatException(final HttpMessageNotReadableException e) {
		LOGGER.error(e.getMessage(), e);
		final BastDTOData baseData = new BastDTOData();
		final String errorMsg = exceptionLabel.getMessage(WylieConstant.EXCEPTION_VALIDATION_CODE);
		baseData.setMsg(errorMsg);
		baseData.setMsgCode(WylieConstant.EXCEPTION_VALIDATION_CODE);
		baseData.setSuccess(false);
		return baseData;
	}

	/**
	 * Global exception handler for Exception
	 *
	 * @param e
	 *           exception
	 * @return response with errorCode and errorMessage
	 * @author Neil WANG
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public BastDTOData globalException(final Exception e) {
		LOGGER.error(e.getMessage(), e);
		final BastDTOData baseData = new BastDTOData();
		final String errorMsg = exceptionLabel.getMessage(WylieConstant.EXCEPTION_UNKNOWN_CODE);
		baseData.setMsg(errorMsg + e.getMessage());
		baseData.setMsgCode(WylieConstant.EXCEPTION_UNKNOWN_CODE);
		baseData.setSuccess(false);
		return baseData;
	}

	/**
	 * Global exception handler for Exception
	 *
	 * @param e
	 *           exception
	 * @return response with errorCode and errorMessage
	 * @author Neil WANG
	 */
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({ TokenExpiredException.class })
	@ResponseBody
	public BastDTOData tokenExpiredException(final TokenExpiredException e) {
		final BastDTOData baseData = new BastDTOData();
		baseData.setMsg(e.getMsg());
		baseData.setMsgCode(e.getMsgCode());
		baseData.setSuccess(false);
		return baseData;
	}

	private String getErrorMsgContent(final MethodArgumentNotValidException e) {
		String content = "";
		if (e != null && e.getBindingResult() != null && e.getBindingResult().getFieldError() != null) {
			final String field = e.getBindingResult().getFieldError().getField();
			final String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
			content = "[" + field + "]" + defaultMessage;
		}

		return content;
	}

	/**
	 * Reuse it as you already see it!!!
	 *
	 * @author Joe
	 * @return
	 */
	private BastDTOData getErrorResponse(final String errorCode, final String msg) {
		final BastDTOData baseData = new BastDTOData();
		baseData.setMsg(msg);
		baseData.setMsgCode(errorCode);
		baseData.setSuccess(false);
		return baseData;
	}
}
