package com.hiwijaya.aop.advice;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

/**
 * @author Happy Indra Wijaya
 */
public class LogAfterAdvice implements AfterReturningAdvice {     // AFTER ADVICE

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        String className = target.getClass().getName();
        String methodName = method.getName();
        System.out.println("[LOG AFTER] Returning from method " + methodName +
                "() of class " + className + " with " + returnValue.toString());

        System.out.println("-------------------------------------------------------------");

    }

}
