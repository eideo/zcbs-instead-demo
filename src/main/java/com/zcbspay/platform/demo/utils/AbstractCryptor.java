/* 
 * AbstractCryptor.java  
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
 * 加密解密
 * @author: zhangshd
 * @date:   2017年6月1日 下午2:20:33   
 * @version :v1.0
 */
public interface AbstractCryptor {
	public String encrypt(String data);

	public String decrypt(String data);
}
