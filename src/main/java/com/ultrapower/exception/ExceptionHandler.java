package com.ultrapower.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ultrapower.domain.Result;
import com.ultrapower.utils.ResultUtil;

@RestControllerAdvice
public class ExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public Result handle(Exception exception) {
		if(exception instanceof GirlException) {
			GirlException girlException = (GirlException)exception;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		}else {
			logger.error("【系统异常】{}",exception);
			return ResultUtil.error(-1, "未知错误");
		}
		
	}
}
