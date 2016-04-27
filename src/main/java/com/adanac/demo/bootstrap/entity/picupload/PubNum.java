package com.adanac.demo.bootstrap.entity.picupload;

public class PubNum {
	private Long id;
	/**
	 * 商户ID
	 */
	private Long companyId;
	/**
	 * 公众号号码
	 */
	private String pubnumNum;
	/**
	 * 公众号名称
	 */
	private String pubnumName;
	/**
	 * 公众账号原始ID
	 */
	private String pubnumOldId;
	/**
	 * 公众号APPID
	 */
	private String pubnumAppid;
	/**
	 * 公众号APPSECRET
	 */
	private String pubnumAppsecret;
	/**
	 * 域名
	 */
	private String domainName;
	/**
	 * 公众号ENCRYPTKIK
	 */
	private String pubnumEncryptkik;
	/**
	 * 公众号URL
	 */
	private String pubnumUrl;
	/**
	 * 公众号TOKEN
	 */
	private String pubnumToken;
	/**
	 * 微信图片
	 */
	private String pubnumImage;

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

	public String getPubnumNum() {
		return pubnumNum;
	}

	public void setPubnumNum(String pubnumNum) {
		this.pubnumNum = pubnumNum == null ? null : pubnumNum.trim();
	}

	public String getPubnumName() {
		return pubnumName;
	}

	public void setPubnumName(String pubnumName) {
		this.pubnumName = pubnumName == null ? null : pubnumName.trim();
	}

	public String getPubnumOldId() {
		return pubnumOldId;
	}

	public void setPubnumOldId(String pubnumOldId) {
		this.pubnumOldId = pubnumOldId == null ? null : pubnumOldId.trim();
	}

	public String getPubnumAppid() {
		return pubnumAppid;
	}

	public void setPubnumAppid(String pubnumAppid) {
		this.pubnumAppid = pubnumAppid == null ? null : pubnumAppid.trim();
	}

	public String getPubnumAppsecret() {
		return pubnumAppsecret;
	}

	public void setPubnumAppsecret(String pubnumAppsecret) {
		this.pubnumAppsecret = pubnumAppsecret == null ? null : pubnumAppsecret.trim();
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName == null ? null : domainName.trim();
	}

	public String getPubnumEncryptkik() {
		return pubnumEncryptkik;
	}

	public void setPubnumEncryptkik(String pubnumEncryptkik) {
		this.pubnumEncryptkik = pubnumEncryptkik == null ? null : pubnumEncryptkik.trim();
	}

	public String getPubnumUrl() {
		return pubnumUrl;
	}

	public void setPubnumUrl(String pubnumUrl) {
		this.pubnumUrl = pubnumUrl == null ? null : pubnumUrl.trim();
	}

	public String getPubnumToken() {
		return pubnumToken;
	}

	public void setPubnumToken(String pubnumToken) {
		this.pubnumToken = pubnumToken == null ? null : pubnumToken.trim();
	}

	public String getPubnumImage() {
		return pubnumImage;
	}

	public void setPubnumImage(String pubnumImage) {
		this.pubnumImage = pubnumImage == null ? null : pubnumImage.trim();
	}
}
