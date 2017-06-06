package com.zcbspay.platform.demo.bean;

/**
 * 批量查询请求bean
 * 
 * @author: zhangshd
 * @date: 2017年3月13日 下午1:17:46
 * @version :v1.0
 */
public class BatchQueryReqBean extends BaseBean {

	private static final long serialVersionUID = 5332858638346984082L;
	private String merId;// 商户代码
	private String batchNo;// 批次号
	private String txnTime;// 订单发送时间
	private String busiType;//订单类型01:代收 ,02:代付
	private String txnDate;	//原批次交易日期;
	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

}
