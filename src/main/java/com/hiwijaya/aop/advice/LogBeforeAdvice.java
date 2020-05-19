package com.hiwijaya.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * @author Happy Indra Wijaya
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {    // BEFORE ADVICE

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        String className = target.getClass().getName();
        String methodName = method.getName();

        System.out.println("[log-before-advice] Executing method "+methodName+" " +
                "of class "+className+" with following parameters");
        for(Object parameter: args){
            System.out.println(parameter.getClass().getName() + " = "+parameter.toString());
        }

    }

}
