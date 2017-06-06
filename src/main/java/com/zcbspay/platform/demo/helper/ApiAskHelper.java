package com.zcbspay.platform.demo.helper;

import java.util.ArrayList;
import java.util.List;

import com.zcbspay.platform.demo.bean.MessageBean;
import com.zcbspay.platform.demo.constant.Constants;
import com.zcbspay.platform.demo.utils.HttpRequestParam;
import com.zcbspay.platform.demo.utils.HttpUtils;

import net.sf.json.JSONObject;
/**
 * 接口请求
 * @author: zhangshd
 * @date:   2017年6月5日 上午9:12:21   
 * @version :v1.0
 */
public class ApiAskHelper {
	
	public static MessageBean api(MessageBean messageBean,boolean isSingle) {
		HttpUtils httpUtils = new HttpUtils();
		MessageBean responseBean=null;
		try {
			// 验签,解密
			HttpRequestParam httpRequestParamData= new HttpRequestParam("data",messageBean.getData());
			HttpRequestParam httpRequestParamSign= new HttpRequestParam("sign",messageBean.getSign());
			HttpRequestParam httpRequestParamAddit= new HttpRequestParam("addit",messageBean.getAddit());
			List<HttpRequestParam> list = new ArrayList<>();
			list.add(httpRequestParamData);
			list.add(httpRequestParamSign);
			list.add(httpRequestParamAddit);
			String url =Constants.ApiUrl.batchUrl;
			if (isSingle) {
				url=Constants.ApiUrl.realtimeUrl;
			}
			httpUtils.openConnection();
			//调用实时处理
			String responseContent = httpUtils.executeHttpPost(url,list,Constants.Encoding.UTF_8);
			responseBean=(MessageBean) JSONObject.toBean(JSONObject.fromObject(responseContent),MessageBean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpUtils.closeConnection();
		}
		return responseBean;
	}

}
