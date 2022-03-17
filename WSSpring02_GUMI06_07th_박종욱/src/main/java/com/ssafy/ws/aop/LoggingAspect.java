package com.ssafy.ws.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class LoggingAspect {
	public void start(JoinPoint point) {
		Signature signature = point.getSignature();
		String name = signature.getName();
		Object[] args = point.getArgs();
		System.out.println(">> log start: " + name + ", " + Arrays.toString(args));
	}

}
