package com.github.theinfinity007.spring_aop.dao;

import com.github.theinfinity007.spring_aop.Account;

public interface AccountDAO {
    void addAccount();

    void addAccount(Account account);

    void addAccount(Account account, boolean vipFlag);

    void doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
