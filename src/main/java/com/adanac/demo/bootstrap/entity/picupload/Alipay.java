package com.adanac.demo.bootstrap.entity.picupload;

import java.io.Serializable;

/**
 * 图片上传dto
 *
 */
public class Alipay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034263922472340649L;

	/*
	 * ID
	 */
	private Integer id;

	/*
	 * 支付宝账号
	 */
	private String account;
	/*
	 * 身份证正面
	 */
	private String cardPhotoUp;
	/*
	 * 身份证反面
	 */
	private String cardPhotoDn;

	/*
	 * 联系人姓名
	 */
	private String contact;
	/*
	 * 手机号
	 */
	private String mobile;
	/*
	 * 邮箱
	 */
	private String email;

	/**
	 * 排序
	 */
	private String rowNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCardPhotoUp() {
		return cardPhotoUp;
	}

	public void setCardPhotoUp(String cardPhotoUp) {
		this.cardPhotoUp = cardPhotoUp;
	}

	public String getCardPhotoDn() {
		return cardPhotoDn;
	}

	public void setCardPhotoDn(String cardPhotoDn) {
		this.cardPhotoDn = cardPhotoDn;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	@Override
	public String toString() {
		return "Alipay [id=" + id + ", account=" + account + ", cardPhotoUp=" + cardPhotoUp + ", cardPhotoDn="
				+ cardPhotoDn + ", contact=" + contact + ", mobile=" + mobile + ", email=" + email + ", rowNum="
				+ rowNum + "]";
	}

}
