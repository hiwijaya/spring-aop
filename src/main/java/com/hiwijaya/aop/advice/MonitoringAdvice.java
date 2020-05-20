package com.hiwijaya.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Happy Indra Wijaya
 */
public class MonitoringAdvice implements MethodInterceptor {    // AROUND ADVICE

    @Override
    public Object invoke(MethodInvocation targetMethod) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Counting time..");
        Object result = targetMethod.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken in ms : "+(endTime-startTime));
        return result;
    }

}
