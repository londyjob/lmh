package com.ultrapower.exception;


public class GirlException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6135193380250315269L;
	private Integer code;

	
	public GirlException(ResultEnum enums) {
		super(enums.getMsg());
		this.code = enums.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
