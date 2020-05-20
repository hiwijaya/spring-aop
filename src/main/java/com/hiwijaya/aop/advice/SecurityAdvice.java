package com.hiwijaya.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Happy Indra Wijaya
 */
public class SecurityAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation targetMethod) throws Throwable {

        String inputPin = targetMethod.getArguments()[1].toString();
        if(inputPin.equals("000000")){
            System.out.println("Pin matched.");
            return targetMethod.proceed();
        }

        System.out.println("You don't have permission.");

        return false;
    }

}
