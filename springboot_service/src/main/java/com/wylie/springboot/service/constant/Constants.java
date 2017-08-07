package com.wylie.springboot.service.constant;

/**
 * constant class
 *
 * @author alan
 *
 */
public class Constants {

	/**
	 * Constant for success response message
	 */
	public static final String COMMON_REPONSE_SUCCESS = "success";
	/**
	 * Constant for warn response message
	 */
	public static final String COMMON_REPONSE_WARNING = "warn";
	/**
	 * Constant for error response message
	 */
	public static final String COMMON_REPONSE_ERROR = "error";

	/**
	 * OKCHEM
	 */
	public static final String OKCHEM = "OKCHEM";
	/**
	 * true
	 */
	public static final Boolean TRUE = true;
	/**
	 * false
	 */
	public static final Boolean FALSE = false;

	/**
	 * Define code type - Product
	 */
	public static final String CODE_PRODUCT = "CODE_PRODUCT";
	/**
	 * Define code type - Supplier
	 */
	public static final String CODE_SUPPLIER = "CODE_SUPPLIER";
	/**
	 * Define code type - Product Line
	 */
	public static final String CODE_PRODUCT_LINE = "CODE_PRODUCT_LINE";
	/**
	 * english
	 */
	public static final String EN = "en";
	/**
	 * chemistry category
	 */
	public static final String CATEGORY_CC = "CC";
	/**
	 * define seperator
	 */
	public static final String SEPERATOR = ";";
	public static final String CATEGORY_AC = "AC";

	public static final String PRODUCT_STATUS = "ProductStatus";

	/**
	 * Picture types for supplier
	 */
	public static final String SUPPLIER_BASIC_INFO = "supplier_basic_info";
	public static final String MANUFACTURE_DELIVERY = "manufacture_delivery";
	public static final String MANUFACTURE_EQUIPMENT = "manufacture_equipment";
	public static final String MANUFACTURE_PRODUCTION = "manufacture_production";
	public static final String MANUFACTURE_QC = "manufacture_qc";
	public static final String MANUFACTURE_WORK_SHOP = "manufacture_work_shop";

	/**
	 * Constant for unknown exception code
	 */

	public static final String EXCEPTION_UNKNOWN_CODE = "9999";
	/**
	 * Constant for validation exception code
	 */
	public static final String EXCEPTION_VALIDATION_CODE = "9998";

	/**
	 * Define locale key in session
	 */
	public static final String SESSION_KEY_LOCALE = "locale";
	/**
	 * Define locale key in session
	 */
	public static final String DEFAULT_LOCALE_EN = "en";
	/**
	 * Define password change thru date
	 */
	public static final String KEY_PASSWORD_CHANGE_MAX_TIME = "password.change.maxtime";
	/**
	 * define comma
	 */
	public static final String SEPERATOR_COMMA = ",";
	public static final String CANCEL_COMMNET = "Order %s has been canceled with reason: %s";

	public static final String DEFAULT_SUPPLIER_CODE = "OKCHEM";

	public static final String CHICAGO_REDIRECT_URI_SESSION = "Chicago_uri";

	public static final String CHICAGO_THIRD_LOGIN_TYPE = "third_login_type";

	/**
	 * Constant for validation news tag max num
	 */
	public static final int NEWS_TAG_MAX_NUM = 20;

	public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

	public static final String PRODUCT = "productDetail";

	public static final String PRODUCT_TEST = "productDetailTest";
}
