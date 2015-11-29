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
		logger.log("L'authentification est sur le point de se réaliser");
		logger.log("La méthode : " + joinpoint.getSignature().getName() + " a été appelée");
		logger.log("Les paramétres suivants ont été passés pour vérification");
		for (Object o : joinpoint.getArgs()) {
			logger.log("Un paramètre passé contient la valeur : "+o.toString());
		}
	}

	@After("execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void afterAuthentication(JoinPoint joinPoint) {
		logger.log("L'authentification a été executée");
	}
	
	@AfterReturning( returning="result", value="execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void afterAuthenticationReturn(JoinPoint joinPoint, Object result) {
		logger.log((boolean)result ? "L'authentification a réussi" : "Authentification échouée");
	}
	
	@AfterThrowing( throwing="error", value="execution (* tn.esprit.tp2aop.services.AuthenticatorAgent.authenticate(..))")
	public void afterAuthenticationThrow(JoinPoint joinPoint, Throwable error) {
		logger.log("L'authentification s'est intérrompue avec la cause "+ error.getMessage());
	}

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

}
