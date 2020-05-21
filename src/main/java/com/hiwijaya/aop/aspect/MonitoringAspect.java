package com.hiwijaya.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Happy Indra Wijaya
 */
@Aspect
@Component
public class MonitoringAspect {

    @Pointcut("execution(* com.hiwijaya.aop.BankAccount.*(..))")
    public void monitoringPointcut(){}


    @Around("monitoringPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Counting time..");
        Object result = point.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken in ms : "+(endTime-startTime));
        return result;
    }

}
