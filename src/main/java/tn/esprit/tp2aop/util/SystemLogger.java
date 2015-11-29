package tn.esprit.tp2aop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.tp2aop.contracts.ILogger;

@Component
@Qualifier("systemLogger")
public class SystemLogger implements ILogger {

	@Override
	public void log(String message) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy à HH:mm:ss");
		System.out.printf("%s : %s\n", dateFormat.format(new Date()), message);
	}

}
