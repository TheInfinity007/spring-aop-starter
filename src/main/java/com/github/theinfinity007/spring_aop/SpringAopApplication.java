package com.github.theinfinity007.spring_aop;

import com.github.theinfinity007.spring_aop.dao.AccountDAO;
import com.github.theinfinity007.spring_aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
//		accountDAO.addAccount();

		// call the membership business method
		//		membershipDAO.addAccount();

//		membershipDAO.addMembership();

		accountDAO.addAccount(new Account());
	}
}


