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
public class SecurityAspect {

    @Pointcut("execution(boolean com.hiwijaya.aop.BankAccount.*(..))")
    public void securityPointcut(){}


    @Around("securityPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint point) throws Throwable {

        String inputPin = point.getArgs()[0].toString();

        if(inputPin.equals("000000")){
            System.out.println("Pin matched.");
            return point.proceed();
        }

        System.out.println("You don't have permission.");

        return false;

    }

}
