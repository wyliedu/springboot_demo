/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.enums;


/**
 * Language Enum
 */
public enum LangEnum{
	EN("en"), ES("es"), PT("pt");

	private String value;

	private LangEnum(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	

	/**
	 * Check the enum contains input value
	 *
	 * @param value
	 * @return boolean
	 */
	public static boolean contains(final String value) {
		boolean isContain = false;
		for (final LangEnum enu : LangEnum.values()) {
			if (enu.getValue().equals(value)) {
				isContain = true;
				break;
			}
		}
		return isContain;
	}
}
