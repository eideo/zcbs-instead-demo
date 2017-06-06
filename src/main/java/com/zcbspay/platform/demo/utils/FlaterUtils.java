package com.zcbspay.platform.demo.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FlaterUtils {
	/**
	 * 压缩
	 * @author: zhangshd
	 * @param inputString
	 * @return String
	 * @date: 2017年6月1日 下午2:29:08 
	 * @version v1.0
	 */
	public static String deflater(String inputString) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Deflater compressor = new Deflater(5);
		String data=null;
		try {
			byte input[]=inputString.getBytes("UTF-8");
			compressor.setInput(input);
			compressor.finish();
			final byte[] buf = new byte[2048];
			while (!compressor.finished()) {
				int count = compressor.deflate(buf);
				bos.write(buf, 0, count);
			}
			data = Base64Utils.encode(bos.toByteArray());
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			compressor.end();
		}
		return data;
	}
	/**
	 * 解压缩
	 * @author: zhangshd
	 * @param inputString
	 * @return
	 * @throws DataFormatException String
	 * @date: 2017年6月1日 下午2:29:22 
	 * @version v1.0
	 */
	public static String inflater(String inputString) throws DataFormatException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Inflater decompressor = new Inflater();
		String outputString=null;
		try {
			byte[] input=Base64Utils.decode(inputString);
			decompressor.setInput(input);
			final byte[] buf = new byte[2048];
			while (!decompressor.finished()) {
				int count = decompressor.inflate(buf);
				bos.write(buf, 0, count);
			}
			byte[] result=bos.toByteArray();
			return outputString = new String(result, 0, result.length, "UTF-8");
		}catch (Exception e) {
			// TODO: handle exception
		}  finally {
			decompressor.end();
		}
		return outputString;
	}
	
	public static void main(String[] args) throws Exception {
		// Encode a String into bytes
		String inputString = "我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好"
				+ "我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是"
				+ "一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一"
				+ "个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个"
				+ "大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好"
				+ "人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大"
				+ "好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我"
				+ "是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是一个大好人大好人我是";
		System.out.println(deflater(inputString));
		System.out.println(inflater("eF7tyaENgDAQAMDVK7F1DAAhqcE2TbrN9+eoYwD0uUsuj5rnG71Eb+t61j1jjA9prbXWWmuttdZaa6211lprrbXWWmuttdZaa6211lprf+0G/Vq/KQ=="));
		
		
	}

}
