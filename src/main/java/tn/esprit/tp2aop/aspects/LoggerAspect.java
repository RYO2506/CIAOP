package tn.esprit.tp2aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.tp2aop.contracts.ILogger;

@Aspect
@Component
public class LoggerAspect {

	@Autowired
	@Qualifier("systemLogger")
	private ILogger logger;

	@Before("execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void beforeAuthentication(JoinPoint joinpoint) {
		logger.log("L'authentification est sur le point de se r�aliser");
		logger.log("La m�thode : " + joinpoint.getSignature().getName() + " a �t� appel�e");
		logger.log("Les param�tres suivants ont �t� pass�s pour v�rification");
		for (Object o : joinpoint.getArgs()) {
			logger.log("Un param�tre pass� contient la valeur : "+o.toString());
		}
	}

	@After("execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void afterAuthentication(JoinPoint joinPoint) {
		logger.log("L'authentification a �t� execut�e");
	}
	
	@AfterReturning( returning="result", value="execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void afterAuthenticationReturn(JoinPoint joinPoint, Object result) {
		logger.log((boolean)result ? "L'authentification a r�ussi" : "Authentification �chou�e");
	}
	
	@AfterThrowing( throwing="error", value="execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void afterAuthenticationThrow(JoinPoint joinPoint, Throwable error) {
		logger.log("L'authentification s'est int�rrompue avec la cause "+ error.getMessage());
	}

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

}
