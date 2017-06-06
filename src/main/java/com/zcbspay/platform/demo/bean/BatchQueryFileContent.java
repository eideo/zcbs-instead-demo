package com.zcbspay.platform.demo.bean;
/**
 * 批量查询响应文件类
 * @author: zhangshd
 * @date:   2017年6月5日 上午9:09:02   
 * @version :v1.0
 */
public class BatchQueryFileContent extends BatchCollectAndPayFileContent{
	private static final long serialVersionUID = 6217480616899147129L;
	private String respCode;//	响应码
	private String respMsg;//	应答信息

	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
}
