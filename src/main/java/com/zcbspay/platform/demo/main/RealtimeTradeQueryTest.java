package com.zcbspay.platform.demo.main;

import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.bean.RealTimeQueryReqBean;
import com.zcbspay.platform.demo.helper.ApiAskHelper;
import com.zcbspay.platform.demo.helper.SignAndEncryptHelper;

import net.sf.json.JSONObject;

/**
 * 交易查询demo
 * @author: zhangshd
 * @date:   2017年6月2日 上午10:20:35   
 * @version :v1.0
 */
public class RealtimeTradeQueryTest {
	/**
	 * 入口
	 * @author: zhangshd
	 * @param args void
	 * @date: 2017年6月1日 下午2:24:05 
	 * @version v1.0
	 */
	public static void main(String[] args) {
		RealTimeQueryReqBean realTimeQueryReqBean = getEmulationData();
		//加密加签
		MessageBean message =SignAndEncryptHelper.encryptData(realTimeQueryReqBean);
		//接口请求
		MessageBean responseBean=ApiAskHelper.api(message,true);
		//数据解密过程
		MessageBean decryptBean=SignAndEncryptHelper.memberDecrypt(responseBean);
		System.out.println("返回的结果:"+JSONObject.fromObject(decryptBean).toString());
		System.out.println("返回的(签名)结果:"+decryptBean.getSign().toString());
		System.out.println("返回的(业务数据)结果:"+decryptBean.getData());
		System.out.println("返回的(附加数据)结果:"+decryptBean.getAddit());
	}

	private static RealTimeQueryReqBean getEmulationData() {
		//准备参数
		RealTimeQueryReqBean realTimeQueryReqBean=new RealTimeQueryReqBean();
		realTimeQueryReqBean.setVersion("1.0");
		realTimeQueryReqBean.setEncoding("1");
		realTimeQueryReqBean.setTxnType("03");
		realTimeQueryReqBean.setTxnSubType("00");
		realTimeQueryReqBean.setBizType("000002");
		realTimeQueryReqBean.setOrderType("01");
		realTimeQueryReqBean.setTn("170527158800000075");
		return realTimeQueryReqBean;
	}
}
