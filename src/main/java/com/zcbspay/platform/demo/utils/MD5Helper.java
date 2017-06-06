package com.zcbspay.platform.demo.utils;

import com.zcbspay.platform.demo.utils.AbstractVerifier;
import com.zcbspay.platform.demo.utils.Md5Utils;

/**
 * 
 * @author: zhangshd
 * @date:   2017年6月1日 下午2:22:32   
 * @version :v1.0
 */
public class MD5Helper implements AbstractVerifier {

	/**
	 *
	 * @param data
	 */
	@Override
	public boolean verify(String data, String sign) {
		String localMd5 = Md5Utils.md5(data, "UTF-8").toUpperCase();
		if (!localMd5.equals(sign.toUpperCase())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 *
	 * @param data
	 */
	@Override
	public String sign(String data) {
		String localMd5 = Md5Utils.md5(data, "UTF-8").toUpperCase();
		return localMd5;
	}

}
