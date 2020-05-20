package com.hiwijaya.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author Happy Indra Wijaya
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        BankAccount account1 = context.getBean("bankAccountProxy", BankAccount.class);
        account1.withdraw(new BigDecimal(100000), "000001");

    }

}
