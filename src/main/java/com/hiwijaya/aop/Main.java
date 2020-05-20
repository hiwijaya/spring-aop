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

        try {

            BankAccount account1 = context.getBean("bankAccountProxy", BankAccount.class);
            BankAccount account2 = context.getBean("account2", BankAccount.class);

            account1.deposit(new BigDecimal(1000000));
            account1.statement();
            account1.withdraw("000000", new BigDecimal(500000));
            account1.statement();
            account1.transfer("000000", account2, new BigDecimal(400000));
            account1.statement();
            account1.withdraw("000000", new BigDecimal(200000));    // raise InsufficientBalanceException
            account1.statement();

        } catch (InsufficientBalanceException e) {
            System.out.println("Catching the exception");
            System.err.println(e.getMessage());
        }

    }

}
