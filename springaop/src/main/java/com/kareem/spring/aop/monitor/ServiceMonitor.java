
package com.kareem.spring.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

	@Before("execution(* *..*Service.*(..))")
	public void logServiceAccess1(JoinPoint joinPoint) {
		System.out.println(" @Before Completed: " + joinPoint);
	}
	
	@AfterReturning("execution(* *..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("@AfterReturning Completed: " + joinPoint);
	}
	
	
	@After("execution(* *..*Service.*(..))")
	public void logServiceAccess2(JoinPoint joinPoint) {
		System.out.println("@After Completed: " + joinPoint);
	}
	
	

}
