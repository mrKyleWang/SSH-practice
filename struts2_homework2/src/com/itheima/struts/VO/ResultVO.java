package com.itheima.struts.VO;

public class ResultVO {
	
	private Integer code;
	private String msg;
	private Object data;
	
	
	public ResultVO(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public  static ResultVO ok(String msg,Object data) {
		return new ResultVO(1,msg,data);
	}
	
	public static ResultVO error(String msg,Object data) {
		return new ResultVO(0,msg,data);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
