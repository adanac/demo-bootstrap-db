package com.adanac.demo.bootstrap.entity.pubapply;

import com.adanac.demo.bootstrap.entity.common.BaseDto;

/**
 * 服务申请dto
 */
public class ServiceApplyDto extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1226446224845658400L;
	private Long id;
	/**
	 * 商户ID
	 */
	private Long companyId;
	/**
	 * 商户名称
	 */
	private String companyName;
	/**
	 * 服务类型[0,微信公众号服务|1,优惠券服务|2,会员中心|3,交易中心]
	 */
	private Integer serviceType;
	/**
	 * 状态[0,待审批|1,通过|2,驳回]
	 */
	private Integer status;
	/**
	 * 申请日期
	 */
	private String applyDate;
	/**
	 * 最后备注
	 */
	private String remark;
	/**
	 * 最后审批人ID
	 */
	private Long approvalId;
	/**
	 * 最后审批人名称
	 */
	private String approvalName;
	/**
	 * 最后审批日期
	 */
	private String approvalDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName == null ? null : approvalName.trim();
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

}