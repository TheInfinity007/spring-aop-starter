package com.github.theinfinity007.spring_aop.dao;

import com.github.theinfinity007.spring_aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName() + ": Doing my DB Work: Adding an Account");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass().getSimpleName() + ": Doing my DB Work: Adding an Account with params");
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass().getSimpleName() + ": Doing my DB Work: Adding an Account with multiple params");
    }

    @Override
    public void doWork() {
        System.out.println(getClass().getSimpleName() + ": DoWork()");
    }

    public String getName() {
        System.out.println(getClass().getSimpleName() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass().getSimpleName() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass().getSimpleName() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
