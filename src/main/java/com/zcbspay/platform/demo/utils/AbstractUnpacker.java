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
 * 解包器
 * @author: zhangshd
 * @date:   2017年6月1日 下午2:20:45   
 * @version :v1.0
 */
public interface AbstractUnpacker {
	public String unpack(String data);

	public String pack(String data);
}
