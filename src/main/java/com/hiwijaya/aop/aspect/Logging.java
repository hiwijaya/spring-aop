package com.hiwijaya.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Happy Indra Wijaya
 */
@Aspect
@Component
public class Logging {

    // pointcut designator (PCD)
    @Pointcut("execution(* com.hiwijaya.aop.BankAccount.*(..))")
    public void loggingPointcut(){}


    @Before("loggingPointcut()")
    public void beforeAdvice(JoinPoint point) {
        System.out.println("[ASPECTJ: LOG-BEFORE] " + point.getSignature().getName());
    }


}
