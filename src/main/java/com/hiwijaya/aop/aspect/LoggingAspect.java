package com.hiwijaya.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Happy Indra Wijaya
 */
@Aspect
@Component
public class LoggingAspect {

    // pointcut designator (PCD)
    @Pointcut("execution(* com.hiwijaya.aop.BankAccount.*(..))")
    public void loggingPointcut(){}


    @Before("loggingPointcut()")
    public void beforeAdvice(JoinPoint point) {

        System.out.println("-------------------------------------------------------------");

        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        System.out.println("[ASPECTJ: LOG BEFORE] Executing method " + methodName + "() " +
                "of class " + className + " with following parameters");

        Object[] args = point.getArgs();
        for(Object parameter: args){
            System.out.println("[ASPECTJ: LOG BEFORE] " + parameter.getClass().getName() + " = "+parameter.toString());
        }

    }

    @AfterReturning(pointcut = "loggingPointcut()", returning="returnValue")
    public void afterAdvice(JoinPoint point, Object returnValue){

        returnValue = returnValue != null ? returnValue.toString() : null;

        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        System.out.println("[ASPECTJ: LOG AFTER] Returning from method " + methodName +
                "() of class " + className + " with " + returnValue );

        System.out.println("-------------------------------------------------------------");

    }

}
