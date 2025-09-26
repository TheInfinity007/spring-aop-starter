package com.github.theinfinity007.spring_aop.dao;

import com.github.theinfinity007.spring_aop.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount();

    void addAccount(Account account);

    void addAccount(Account account, boolean vipFlag);

     List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
