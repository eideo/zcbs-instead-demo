/* 
 * AbstractUnpacker.java  
 * 
 * version TODO
 *
 * 2016年4月20日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zcbspay.platform.demo.utils;

/**
 * 加签验签器
 * @author: zhangshd
 * @date:   2017年6月1日 下午2:21:00   
 * @version :v1.0
 */
public interface AbstractVerifier {
	public boolean verify(String data, String sign);

	public String sign(String data);
}
