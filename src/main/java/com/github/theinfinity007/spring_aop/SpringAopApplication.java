package com.github.theinfinity007.spring_aop;

import com.github.theinfinity007.spring_aop.dao.AccountDAO;
import com.github.theinfinity007.spring_aop.dao.MembershipDAO;
import com.github.theinfinity007.spring_aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
			demoTheAroundAdvice(trafficFortuneService);
		};
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\nMain Program: TrafficFortuneService");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nToday forturne is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions

//			boolean tripWire = true;
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception ex){
			System.out.println("\n\n Main Program: ... caught exception: " + ex);
		}

		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("---------");
		System.out.println(accounts);

	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions

			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception ex){
			System.out.println("\n\n Main Program: ... caught exception: " + ex);
		}


		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---------");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
//		accountDAO.addAccount();

		// call the membership business method
		//		membershipDAO.addAccount();
//		accountDAO.doWork();

		// call the account dao getter/setter methods
//		accountDAO.setName("foobar");
//		accountDAO.setServiceCode("silver");
//		accountDAO.getName();
//		accountDAO.getServiceCode();


//		membershipDAO.addMembership();

		Account myAccount = new Account();
		myAccount.setLevel("Platinum");
		myAccount.setName("John");
//		accountDAO.addAccount(new Account());
		accountDAO.addAccount(myAccount, true);
//		membershipDAO.goToSleep();


	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {


		boolean tripWire = false;
		List<Account> accounts = accountDAO.findAccounts(tripWire);

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("---------");
		System.out.println(accounts);
	}

}


