package com.zcbspay.platform.demo.main;

import java.util.ArrayList;
import java.util.List;

import com.zcbspay.platform.demo.bean.BatchImportFileContent;
import com.zcbspay.platform.demo.bean.BatchImportReqBean;
import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.constant.Constants;
import com.zcbspay.platform.demo.helper.ApiAskHelper;
import com.zcbspay.platform.demo.helper.SignAndEncryptHelper;
import com.zcbspay.platform.demo.utils.FlaterUtils;
import com.zcbspay.platform.demo.utils.RiskInfoUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 批量合同导入demo
 * @author: zhangshd
 * @date:   2017年6月2日 上午10:20:35   
 * @version :v1.0
 */
public class BatchContractImportTest {
	/**
	 * 入口
	 * @author: zhangshd
	 * @param args void
	 * @date: 2017年6月1日 下午2:24:05 
	 * @version v1.0
	 */
	public static void main(String[] args) {
		BatchImportReqBean ReqBean = getEmulationData();
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

	private static BatchImportReqBean getEmulationData() {
		//准备参数
		BatchImportReqBean ReqBean=new BatchImportReqBean();
		ReqBean.setVersion("1.0");
		ReqBean.setEncoding("1");
		ReqBean.setTxnType("05");
		ReqBean.setTxnSubType("00");
		ReqBean.setBizType("000003");
		ReqBean.setMerId(Constants.MemberInfo.merid);
		ReqBean.setBatchNo(RiskInfoUtils.randomStr(10));
		ReqBean.setTxnTime("20170306060606");
		
		BatchImportFileContent b1=new BatchImportFileContent();
		b1.setContractnum(RiskInfoUtils.randomStr(10));
		b1.setContracttype("CT00");
		b1.setDebtorname("吴绍亮");
		b1.setDebtoraccountno("6222020200097260092");
		b1.setDebtorbranchcode("102100000101");
		b1.setCreditorname("吴绍亮");
		b1.setCreditoraccountno("6222020200097260093");
		b1.setCreditorbranchcode("102100000101");
		b1.setSigndate("20170526");
		b1.setExpirydate("20180526");
		b1.setFileaddress("文件名");
		
		BatchImportFileContent b2=new BatchImportFileContent();
		b2.setContractnum(RiskInfoUtils.randomStr(10));
		b2.setContracttype("CT00");
		b2.setDebtorname("吴绍亮");
		b2.setDebtoraccountno("6222020200097260092");
		b2.setDebtorbranchcode("102100000101");
		b2.setCreditorname("吴绍亮");
		b2.setCreditoraccountno("6222020200097260093");
		b2.setCreditorbranchcode("102100000101");
		b2.setSigndate("20170526");
		b2.setExpirydate("20180526");
		b2.setFileaddress("文件名");
		
		
		List<BatchImportFileContent> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		ReqBean.setFileContent(FlaterUtils.deflater(JSONArray.fromObject(list).toString()));//数据进行压缩
		return ReqBean;
	}
}
