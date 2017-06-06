package com.zcbspay.platform.demo.main;

import com.zcbspay.platform.demo.bean.BatchQueryReqBean;
import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.constant.Constants;
import com.zcbspay.platform.demo.helper.ApiAskHelper;
import com.zcbspay.platform.demo.helper.SignAndEncryptHelper;
import com.zcbspay.platform.demo.utils.RiskInfoUtils;

import net.sf.json.JSONObject;

/**
 * 批量交易查询demo
 * @author: zhangshd
 * @date:   2017年6月2日 上午10:20:35   
 * @version :v1.0
 */
public class BatchTradeQueryTest {
	/**
	 * 入口
	 * @author: zhangshd
	 * @param args void
	 * @date: 2017年6月1日 下午2:24:05 
	 * @version v1.0
	 */
	public static void main(String[] args) {
		BatchQueryReqBean RepBean = getEmulationData();
		//加密加签
		MessageBean message =SignAndEncryptHelper.encryptData(RepBean);
		//接口请求
		MessageBean responseBean=ApiAskHelper.api(message,false);
		//数据解密过程
		MessageBean decryptBean=SignAndEncryptHelper.memberDecrypt(responseBean);
		System.out.println("返回的结果:"+JSONObject.fromObject(decryptBean).toString());
		System.out.println("返回的(签名)结果:"+decryptBean.getSign().toString());
		System.out.println("返回的(业务数据)结果:"+decryptBean.getData());
		System.out.println("返回的(附加数据)结果:"+decryptBean.getAddit());
	}

	private static BatchQueryReqBean getEmulationData() {
		//准备参数
		BatchQueryReqBean RepBean=new BatchQueryReqBean();
		RepBean.setVersion("1.0");
		RepBean.setEncoding("1");
		RepBean.setTxnType("03");
		RepBean.setTxnSubType("00");
		RepBean.setBizType("000003");
		RepBean.setMerId(Constants.MemberInfo.merid);
		RepBean.setBatchNo(RiskInfoUtils.randomStr(10));
		RepBean.setTxnDate("20170305");
		RepBean.setTxnTime("050505");
		RepBean.setBusiType("01");
		return RepBean;
	}
}
