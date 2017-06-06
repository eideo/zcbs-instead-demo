package com.zcbspay.platform.demo.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.zcbspay.platform.demo.bean.AdditBean;
import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.constant.Constants;
import com.zcbspay.platform.demo.utils.AESUtil;
import com.zcbspay.platform.demo.utils.Base64Utils;
import com.zcbspay.platform.demo.utils.DateUtils;
import com.zcbspay.platform.demo.utils.GateKeeper;
import com.zcbspay.platform.demo.utils.HttpRequestParam;
import com.zcbspay.platform.demo.utils.HttpUtils;
import com.zcbspay.platform.demo.utils.Md5Utils;
import com.zcbspay.platform.demo.utils.RSAHelper;
import com.zcbspay.platform.demo.utils.RiskInfoUtils;
import com.zcbspay.platform.demo.utils.StringUtil;

import net.sf.json.JSONObject;

public class SignAndEncryptHelper {
	
	/**
	 * 加密
	 * @author: zhangshd
	 * @param object
	 * @param merid
	 * @return MessageBean
	 * @date: 2017年6月1日 上午11:17:25 
	 * @version v1.0
	 */
	public static MessageBean encryptData(Object object) {
		MessageBean requestBean=null;
		AdditBean additBean = new AdditBean();
		additBean.setAccessType(Constants.AdditInfo.accessType);
		additBean.setMerId(Constants.MemberInfo.merid);
		additBean.setEncryMethod(Constants.AdditInfo.encryMethod);
		HttpUtils httpUtils = new HttpUtils();
		try {
			Map<String, Object> riskInfo = new TreeMap<String, Object>();
			riskInfo.put("random", RiskInfoUtils.randomInt(32));
			riskInfo.put("timestamp", DateUtils.geCurrentDateTimeStr());
			riskInfo.put("deviceID", RiskInfoUtils.getMacAddress());
			additBean.setRiskInfo(JSONObject.fromObject(riskInfo).toString());
			requestBean=localEncrypt(additBean, JSONObject.fromObject(object).toString());
			return requestBean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			httpUtils.closeConnection();
		}
	}
	
	/**
	 * 用平台的公钥加密加签
	 * @author: zhangshd
	 * @param additBean
	 * @param data
	 * @return MessageBean
	 * @date: 2017年6月1日 上午11:16:55 
	 * @version v1.0
	 */
	private static MessageBean localEncrypt(AdditBean additBean, String data) {
		MessageBean messageBean = new MessageBean();
		try {
			String key = AESUtil.getAESKey();
			RSAHelper rsa =new RSAHelper(Constants.RsaKey.localPubKey,null);
			additBean.setEncryKey(rsa.encrypt(key));
			String signData = Md5Utils.md5(key + JSONObject.fromObject(additBean).toString() + data, "UTF-8").toUpperCase();
			Map<String, Object> signMap = new TreeMap<String, Object>();
			signMap.put("signature", signData);
			signMap.put("signMethod", "01");
			messageBean.setSign(JSONObject.fromObject(signMap).toString());
			additBean.setRiskInfo(Base64Utils.encode(AESUtil.encrypt(additBean.getRiskInfo(), key)));
			messageBean.setData(Base64Utils.encode(AESUtil.encrypt(data, key)));
			messageBean.setAddit(JSONObject.fromObject(additBean).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageBean;
	}
	
	/**
	 * 合作机构用自己的私钥解密验签
	 * @author: zhangshd
	 * @param messageBean
	 * @return MessageBean
	 * @date: 2017年6月1日 上午11:16:33 
	 * @version v1.0
	 */
	public static MessageBean memberDecrypt(MessageBean messageBean) {
		RSAHelper rsa = new RSAHelper(Constants.RsaKey.memberPubKey, Constants.RsaKey.memberPriKey);
		
		GateKeeper keeper = new GateKeeper(messageBean.getData(), messageBean.getSign(), messageBean.getAddit(), rsa);
		if (keeper.getErrorMsg() == null || keeper.getErrorMsg().isNormal())

		// 异常情况
		if (StringUtil.isNotEmpty(keeper.getErrorMsg().getErrorCode())) {
			throw new IllegalArgumentException(keeper.getErrorMsg().getErrorMessage());
		}
		MessageBean returnMessageBean = new MessageBean();
		returnMessageBean.setAddit(keeper.getAddit().toString());
		returnMessageBean.setData(keeper.getData().toString());
		returnMessageBean.setSign(messageBean.getSign());
		return returnMessageBean;
	}
	public static String localEncryptData(String data) {
		RSAHelper rsa = null;
		HttpRequestParam httpRequestParam = new HttpRequestParam("data", Constants.MemberInfo.merid);
		List<HttpRequestParam> list = new ArrayList<>();
		list.add(httpRequestParam);
		rsa = new RSAHelper(Constants.RsaKey.localPubKey, null);
		return rsa.encrypt(data);
	}

}
