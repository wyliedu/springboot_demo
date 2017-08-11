/*******************************************************************************
 * Licensed to the OKChem
 *
 * http://www.okchem.com
 *
 *******************************************************************************/
package com.wylie.springboot.service.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * input model
 * 
 * @author: moss
 * @date: 2016/10/13
 */
public class InChangePassword {

	@NotEmpty(message="不能为空")
	@Size(min = 6, max = 12)
	private String currentPassword;

	@NotEmpty
	@Size(min = 6, max = 12)
	private String newPassword;

	@NotEmpty
	@Size(min = 6, max = 12)
	private String newPasswordVerify;

	/**
	 * @return the currentPassword
	 */
	public String getCurrentPassword() {
		return currentPassword;
	}

	/**
	 * @param currentPassword
	 *           the currentPassword to set
	 */
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *           the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the newPasswordVerify
	 */
	public String getNewPasswordVerify() {
		return newPasswordVerify;
	}

	/**
	 * @param newPasswordVerify
	 *           the newPasswordVerify to set
	 */
	public void setNewPasswordVerify(String newPasswordVerify) {
		this.newPasswordVerify = newPasswordVerify;
	}

}
