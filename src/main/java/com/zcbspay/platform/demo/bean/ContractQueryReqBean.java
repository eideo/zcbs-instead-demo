package com.zcbspay.platform.demo.bean;

/**
 * 合同查询请求bean
 * 
 * @author: zhangshd
 * @date: 2017年3月13日 下午1:17:46
 * @version :v1.0
 */
public class ContractQueryReqBean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3215136100881828539L;
	private String merId;// 商户代码
	private String contractnum;//合同编号
	public String getContractnum() {
		return contractnum;
	}

	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}
	private String contractContent;// 文件内容

	public String getContractContent() {
		return contractContent;
	}

	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

}
