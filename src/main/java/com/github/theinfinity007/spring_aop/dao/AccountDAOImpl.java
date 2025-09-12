package com.github.theinfinity007.spring_aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName() + ": Doing my DB Work: Adding an Account");
    }
}
