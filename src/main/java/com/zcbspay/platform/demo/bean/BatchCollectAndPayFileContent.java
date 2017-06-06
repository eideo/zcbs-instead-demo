package com.zcbspay.platform.demo.bean;

import java.io.Serializable;
/**
 * 批量代收代付文件类
 * @author: zhangshd
 * @date:   2017年6月5日 上午9:07:23   
 * @version :v1.0
 */
public class BatchCollectAndPayFileContent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4582998385382657983L;
	
	private String orderId;// 商户订单号
	
	private String currencyCode;// 交易币种
	
	private String amt;// 单笔金额
	
	private String debtorBank;// 付款人银行号
	
	private String debtorAccount;// 付款人账号
	
	private String debtorName;// 付款人名称
	
	private String debtorConsign;// 付款合同号
	
	private String creditorBank;// 收款人银行号
	
	private String creditorAccount;// 收款人账号
	
	private String creditorName;// 收款人名称
	//@Length(max = 5,message="[业务种类编码]长度不符合规范")
	//@NotEmpty(message="[业务种类编码]不能为空")
	
	private String proprietary;// 业务种类编码
	private String summary;// 摘要

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getDebtorBank() {
		return debtorBank;
	}

	public void setDebtorBank(String debtorBank) {
		this.debtorBank = debtorBank;
	}

	public String getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(String debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public String getDebtorName() {
		return debtorName;
	}

	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}

	public String getDebtorConsign() {
		return debtorConsign;
	}

	public void setDebtorConsign(String debtorConsign) {
		this.debtorConsign = debtorConsign;
	}

	public String getCreditorBank() {
		return creditorBank;
	}

	public void setCreditorBank(String creditorBank) {
		this.creditorBank = creditorBank;
	}

	public String getCreditorAccount() {
		return creditorAccount;
	}

	public void setCreditorAccount(String creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	public String getProprietary() {
		return proprietary;
	}

	public void setProprietary(String proprietary) {
		this.proprietary = proprietary;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
