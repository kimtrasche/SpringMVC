package kr.co.sincweb.aop.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("log")
@Aspect
public class MessageAspect {

	@Before("execution(public * kr.co.sincweb.aop.target.*Impl.add*(..))")	// (pointcut 속성이 생략됨
	public void startLog() {
		System.out.println("타겟 실행전 호출되는 공통관심사항");
	}
	
	@After("execution(public * kr.co.sincweb.aop.target.*Impl.add*(..))")	// (pointcut 속성이 생략됨
	public void afterLog() {
		System.out.println("타겟 실행 후 호출되는 공통관심사항");
	}
	
	@AfterReturning(pointcut="execution(public * kr.co.sincweb.aop.target.*Impl.*Service(..))", returning="obj")
	public void afterReturningLog(Object obj) {
		System.out.println("returnVlaue >> "+obj);
		System.out.println("타겟 실행 후 리턴이후 호출되는 공통관심사항");
		
	}
}
