package com.ultrapower.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.ultrapower.controller.GirlController.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//类方法名称
		logger.info("类方法名称={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		logger.info("参数={}",joinPoint.getArgs());
		logger.info("11111111111111");
	}
	@After("log()")
	public void doAfter() {
		logger.info("222222222222222");
	}
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object) {
		logger.info("response={}",object.toString());
	}
}
