/* 
 * AESUnpacker.java  
 * 
 * version TODO
 *
 * 2016年4月22日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zcbspay.platform.demo.utils;

/**
 * AES解包（报文解包）
 * @author: zhangshd
 * @date:   2017年6月1日 下午2:21:13   
 * @version :v1.0
 */
public class AESHelper implements AbstractUnpacker {
	private String key;

	public AESHelper(String key) {
		this.key = key;
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	@Override
	public String unpack(String data) {
		try {
			return new String(AESUtil.decrypt(Base64Utils.decode(data), key), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * @param data
	 */
	@Override
	public String pack(String data) {
		try {
			return Base64Utils.encode((AESUtil.encrypt(data, key)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
