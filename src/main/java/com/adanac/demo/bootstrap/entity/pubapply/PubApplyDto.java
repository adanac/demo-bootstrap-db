package com.adanac.demo.bootstrap.entity.pubapply;

import java.io.Serializable;

public class PubApplyDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805486452771043752L;
	/**
	 * 序号
	 */
	private String number;
	/**
	 * 服务项目
	 */
	private String applyName;

	/**
	 * 申请日期
	 */
	private String applyDate;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 驳回原因
	 */
	private String rejectReason;

	/**
	 * 操作
	 */
	private String operation;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "PubApplyDto [number=" + number + ", applyName=" + applyName + ", applyDate=" + applyDate + ", status="
				+ status + ", rejectReason=" + rejectReason + ", operation=" + operation + "]";
	}

}
