package com.zcbspay.platform.demo.main;

import java.util.ArrayList;
import java.util.List;

import com.zcbspay.platform.demo.bean.BatchCollectAndPayFileContent;
import com.zcbspay.platform.demo.bean.BatchPayReqBean;
import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.constant.Constants;
import com.zcbspay.platform.demo.helper.ApiAskHelper;
import com.zcbspay.platform.demo.helper.SignAndEncryptHelper;
import com.zcbspay.platform.demo.utils.FlaterUtils;
import com.zcbspay.platform.demo.utils.RiskInfoUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 批量代付demo
 * @author: zhangshd
 * @date:   2017年6月2日 上午10:20:35   
 * @version :v1.0
 */
public class BatchPayTest {
	/**
	 * 入口
	 * @author: zhangshd
	 * @param args void
	 * @date: 2017年6月1日 下午2:24:05 
	 * @version v1.0
	 */
	public static void main(String[] args) {
		BatchPayReqBean ReqBean = getEmulationData();
		//加密加签
		MessageBean message =SignAndEncryptHelper.encryptData(ReqBean);
		//交易查询
		MessageBean responseBean=ApiAskHelper.api(message,false);
		//数据解密过程
		MessageBean decryptBean=SignAndEncryptHelper.memberDecrypt(responseBean);
		System.out.println("返回的结果:"+JSONObject.fromObject(decryptBean).toString());
		System.out.println("返回的(签名)结果:"+decryptBean.getSign().toString());
		System.out.println("返回的(业务数据)结果:"+decryptBean.getData());
		System.out.println("返回的(附加数据)结果:"+decryptBean.getAddit());
	}

	private static BatchPayReqBean getEmulationData() {
		//准备参数
		BatchPayReqBean ReqBean=new BatchPayReqBean();
		ReqBean.setVersion("1.0");
		ReqBean.setEncoding("1");
		ReqBean.setTxnType("02");
		ReqBean.setTxnSubType("00");
		ReqBean.setBizType("000003");
		ReqBean.setBackUrl("shpt@163.com");
		ReqBean.setMerId(Constants.MemberInfo.merid);
		ReqBean.setBatchNo(RiskInfoUtils.randomStr(10));
		ReqBean.setTxnTime("20170306060606");
		ReqBean.setTotalQty("10");
		ReqBean.setTotalAmt("666");
		
		BatchCollectAndPayFileContent b1=new BatchCollectAndPayFileContent();
		b1.setDebtorBank("102100000101");
		b1.setDebtorAccount("6222020200097260092");
		b1.setDebtorName("吴绍亮");
		b1.setDebtorConsign("a33333333335");
		b1.setCreditorBank("102100000101");
		b1.setCreditorAccount("6222020200097260093");
		b1.setCreditorName("吴绍亮");
		b1.setSummary("摘要");
		b1.setOrderId(String.valueOf(RiskInfoUtils.randomInt(30)));
		b1.setCurrencyCode("156");
		b1.setAmt("100");
		
		
		BatchCollectAndPayFileContent b2=new BatchCollectAndPayFileContent();
		b2.setDebtorBank("102100000101");
		b2.setDebtorAccount("6222020200097260092");
		b2.setDebtorName("吴绍亮");
		b2.setDebtorConsign("a33333333335");
		b2.setCreditorBank("102100000101");
		b2.setCreditorAccount("6222020200097260093");
		b2.setCreditorName("吴绍亮");
		b2.setSummary("摘要");
		b2.setOrderId(String.valueOf(RiskInfoUtils.randomInt(30)));
		b2.setCurrencyCode("156");
		b2.setAmt("100");
		
		List<BatchCollectAndPayFileContent> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		ReqBean.setFileContent(FlaterUtils.deflater(JSONArray.fromObject(list).toString()));
		return ReqBean;
	}
}
