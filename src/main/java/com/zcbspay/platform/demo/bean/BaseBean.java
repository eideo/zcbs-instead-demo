package com.zcbspay.platform.demo.bean;

import java.io.Serializable;
/**
 * 响应基类
 * @author: zhangshd
 * @date:   2017年6月5日 上午9:07:05   
 * @version :v1.0
 */
public class BaseBean implements Serializable{

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7554538268683124107L;
    
    protected String version; // 版本
    
	protected String encoding; // 编码方式
    
	private String txnType; // 交易类型
    
	private String txnSubType; // 交易子类
    
	private String bizType="000003"; // 产品类型

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnSubType() {
		return txnSubType;
	}

	public void setTxnSubType(String txnSubType) {
		this.txnSubType = txnSubType;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
}
