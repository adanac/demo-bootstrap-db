package com.adanac.demo.bootstrap.entity.common;

import java.io.Serializable;

public class BaseDto implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 5796609940192805701L;
	private String statu = "0";
	private Object returnId = "";
	private String errorCode = "";
	private String errorMsg = "";
	public static final String WARN = "warn";
	public static final String SUCCESS = "1";
	public static final String ERROR = "0";

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Object getReturnId() {
		return returnId;
	}

	public void setReturnId(Object returnId) {
		this.returnId = returnId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
