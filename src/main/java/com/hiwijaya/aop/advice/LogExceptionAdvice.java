package com.hiwijaya.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author Happy Indra Wijaya
 */
public class LogExceptionAdvice implements ThrowsAdvice {   // THROWS ADVICE

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        String className = target.getClass().getName();
        String methodName = method.getName();

        System.out.println("Throwing exception from method "+methodName+" of class "+className);
        System.out.println("Exception message is "+ex.getMessage());
    }

}
