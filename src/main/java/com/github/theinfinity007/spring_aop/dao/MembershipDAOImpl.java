package com.github.theinfinity007.spring_aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName() + ": Doing my DB Work: Adding a MEMBERSHIP Account");
    }

    @Override
    public boolean addMembership() {
        System.out.println(getClass().getSimpleName() + ": Doing my DB Work: Called addMembership method");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass().getSimpleName() + ": I'm going to sleep now");
    }
}
