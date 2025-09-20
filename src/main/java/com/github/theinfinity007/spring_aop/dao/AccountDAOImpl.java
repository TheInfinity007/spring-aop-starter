package com.github.theinfinity007.spring_aop.dao;

import com.github.theinfinity007.spring_aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
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
}
