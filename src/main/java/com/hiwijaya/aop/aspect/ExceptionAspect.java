package com.hiwijaya.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Happy Indra Wijaya
 */
@Aspect
@Component
public class ExceptionAspect {


    @AfterThrowing(
            pointcut = "execution(boolean com.hiwijaya.aop.BankAccount.*(..))",
            throwing = "exception"
    )
    public void afterThrowingAdvice(JoinPoint point, Throwable exception){

        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();

        System.out.println("[ASPECTJ: LOG EXCEPTION] Throwing exception from method "+methodName+" of class "+className);
        System.out.println("[ASPECTJ: LOG EXCEPTION] Exception is " + exception);
    }

}
