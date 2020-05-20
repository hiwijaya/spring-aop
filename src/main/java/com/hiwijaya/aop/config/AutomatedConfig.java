package com.hiwijaya.aop.config;

import com.hiwijaya.aop.BankAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Happy Indra Wijaya
 */
@Configuration
@EnableAspectJAutoProxy     // <aop:aspectj-autoproxy/>
@ComponentScan("com.hiwijaya.aop.aspect")
public class AutomatedConfig {

    @Bean("account1")
    public BankAccount getAccount1(){
        BankAccount account1 = new BankAccount("Happy Indra Wijaya", "1234567890");
        return account1;
    }

    @Bean("account2")
    public BankAccount getAccount2(){
        BankAccount account2 = new BankAccount("Liam Abraham Wijaya", "0987654321");
        return account2;
    }

}
