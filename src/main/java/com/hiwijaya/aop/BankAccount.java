package com.hiwijaya.aop;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Happy Indra Wijaya
 */
@Component
public class BankAccount {

    private String owner;
    private String accountNumber;
    private BigDecimal balance;

    private String pin = "000000";     // default pin is 000000. Change it immediately!

    public BankAccount(){
        this.balance = BigDecimal.ZERO;
    }

    public BankAccount(String owner, String accountNumber){
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
    }

    public void changePin(String pin){
        this.pin = pin;
    }

    public void statement(){
        System.out.println("Balance in account number '" + accountNumber + "' is " + balance.toPlainString());
    }

    public BigDecimal deposit(BigDecimal amount){
        System.out.println("Deposit");
        balance = balance.add(amount);
        return balance;
    }

    public boolean withdraw(String pin, BigDecimal amount) throws InsufficientBalanceException {

        // validate pin

        System.out.println("Withdrawing");
        if(isSufficientBalance(amount)){
            balance = balance.subtract(amount);
            return true;
        }

        throw new InsufficientBalanceException("Infufficient balance");

    }

    public boolean transfer(String pin, BankAccount recipient, BigDecimal amount) throws InsufficientBalanceException {

        // validate pin

        System.out.println("Transferring");
        if(isSufficientBalance(amount)){
            this.balance = this.balance.subtract(amount);
            recipient.balance = recipient.balance.add(amount);
            return true;
        }

        throw new InsufficientBalanceException("Insufficient balance");

    }


    private boolean isSufficientBalance(BigDecimal spend){
        return balance.compareTo(spend) >= 0;
    }


}
