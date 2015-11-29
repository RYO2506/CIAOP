package tn.esprit.tp2aop.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tn.esprit.tp2aop.contracts.Authenticator;
import tn.esprit.tp2aop.services.AuthenticatorAgent;

public class Bootstrap {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Authenticator agent = context.getBean("authenticatorAgent",Authenticator.class);
		System.out.println(agent.authenticate("admin", "adminpassword"));
	}

}
