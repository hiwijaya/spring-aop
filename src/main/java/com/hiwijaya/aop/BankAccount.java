package com.hiwijaya.aop;

import java.math.BigDecimal;

/**
 * @author Happy Indra Wijaya
 */
public class BankAccount {

    private String owner;
    private String accountNumber;
    private BigDecimal balance;

    private String pin = "000000";     // default pin is 000000. Change it immediately!


    public BankAccount(String owner, String accountNumber){
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
    }

    public void changePin(String pin){
        this.pin = pin;
    }

    public void statement(){
        System.out.println("Balance in account number" + accountNumber + " is " + balance.toPlainString());
    }

    public BigDecimal deposit(BigDecimal amount){
        return balance.add(amount);
    }

    public boolean withdraw(BigDecimal amount){

        // validate pin

        System.out.println("WITHDRAWING..");
        if(isSufficientBalance(amount)){
            balance.subtract(amount);
            return true;
        }
        return false;    // insufficient balance
    }

    public boolean transfer(BankAccount recipient, BigDecimal amount){

        // validate pin

        if(isSufficientBalance(amount)){
            this.balance.subtract(amount);
            recipient.balance.add(amount);
            return true;
        }
        return false;
    }


    private boolean isSufficientBalance(BigDecimal spend){
        return balance.compareTo(spend) >= 0;
    }


}
