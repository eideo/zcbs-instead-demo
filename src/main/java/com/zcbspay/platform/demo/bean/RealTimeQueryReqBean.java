package com.zcbspay.platform.demo.bean;


import com.zcbspay.platform.demo.bean.BaseBean;

/**
 * 实时代付应答bean
 * @author: zhangshd
 * @date:   2017年3月13日 下午1:17:46   
 * @version :v1.0
 */
public class RealTimeQueryReqBean extends BaseBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8985141679266491477L;
	private String 	tn	;//	受理订单号
	private String orderType;//订单类型 01实时代收,02实时代付
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

}
