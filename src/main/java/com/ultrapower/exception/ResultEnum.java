package com.ultrapower.exception;

public enum ResultEnum {

	UNKOWN_ERROR(-1,"未知错误"),
	PRIMARY_SCHOOL(200,"你还在上小学"),
	MIDDLE_SCHOOL(201,"你还在上初中吧")
	;
	private Integer code;
	private String msg;
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
	
}
