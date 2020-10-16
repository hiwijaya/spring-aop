package com.hiwijaya.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Happy Indra Wijaya
 */
@Aspect
@Component
public class DummyAspect implements Ordered {   // or use @Order(0)

    @Override
    public int getOrder() {
        return 0;
    }

    @Pointcut("execution(* com.hiwijaya.aop.BankAccount.*(..))")
    public void loggingPointcut(){}

    @Before("loggingPointcut()")
    public void beforeAdvice(JoinPoint point) {
        System.out.println("[DUMMY: LOG BEFORE]");
    }

    @AfterReturning(pointcut = "loggingPointcut()", returning="returnValue")
    public void afterAdvice(JoinPoint point, Object returnValue){
        System.out.println("[DUMMY: LOG AFTER]");
    }

}
