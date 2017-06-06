package com.zcbspay.platform.demo.main;

import com.zcbspay.platform.demo.bean.EncryptData;
import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.bean.RealTimePayReqBean;
import com.zcbspay.platform.demo.constant.Constants;
import com.zcbspay.platform.demo.helper.ApiAskHelper;
import com.zcbspay.platform.demo.helper.SignAndEncryptHelper;
import com.zcbspay.platform.demo.utils.RiskInfoUtils;

import net.sf.json.JSONObject;

/**
 * 实时代付demo
 * @author: zhangshd
 * @date:   2017年6月2日 上午10:20:35   
 * @version :v1.0
 */
public class RealtimePayTest {
	/**
	 * 入口
	 * @author: zhangshd
	 * @param args void
	 * @date: 2017年6月1日 下午2:24:05 
	 * @version v1.0
	 */
	public static void main(String[] args) {
		RealTimePayReqBean ReqBean = getEmulationData();
		//加密加签
		MessageBean message =SignAndEncryptHelper.encryptData(ReqBean);
		//交易查询
		MessageBean responseBean=ApiAskHelper.api(message,true);
		//数据解密过程
		MessageBean decryptBean=SignAndEncryptHelper.memberDecrypt(responseBean);
		System.out.println("返回的结果:"+JSONObject.fromObject(decryptBean).toString());
		System.out.println("返回的(签名)结果:"+decryptBean.getSign().toString());
		System.out.println("返回的(业务数据)结果:"+decryptBean.getData());
		System.out.println("返回的(附加数据)结果:"+decryptBean.getAddit());
	}

	private static RealTimePayReqBean getEmulationData() {
		//准备参数
		RealTimePayReqBean ReqBean=new RealTimePayReqBean();
		ReqBean.setVersion("1.0");
		ReqBean.setEncoding("1");
		ReqBean.setTxnType("02");
		ReqBean.setTxnSubType("00");
		ReqBean.setBizType("000002");
		ReqBean.setBackUrl("shpt@163.com");
		ReqBean.setMerId(Constants.MemberInfo.merid);
		ReqBean.setMerName("交易测试委托机构全称");
		ReqBean.setMerAbbr("交易测试委托机构简称");
		ReqBean.setOrderId(RiskInfoUtils.randomStr(10));
		ReqBean.setTxnTime("20170306060606");
		ReqBean.setPayTimeout("20170307060606");
		ReqBean.setTxnAmt("888");
		ReqBean.setCurrencyCode("156");
		ReqBean.setOrderDesc("订单描述");
		
		EncryptData encryptData=new EncryptData();
		encryptData.setDebtorBank("102100000101");
		encryptData.setDebtorAccount("6222020200097260092");
		encryptData.setDebtorName("吴绍亮");
		encryptData.setDebtorConsign("a33333333336");
		encryptData.setCreditorBank("102100000101");
		encryptData.setCreditorAccount("6222020200097260093");
		encryptData.setCreditorName("吴绍亮");
		encryptData.setSummary("摘要");
		
		ReqBean.setEncryptData(
				SignAndEncryptHelper.localEncryptData(JSONObject.fromObject(encryptData).toString()));
		return ReqBean;
	}
}
