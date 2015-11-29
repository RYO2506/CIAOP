package tn.esprit.tp2aop.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.tp2aop.contracts.ILogger;

@Component
@Qualifier("fileLogger")
public class FileLogger implements ILogger {

	@Override
	public void log(String message) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy à HH:mm:ss");
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(new File("loggg.txt"), true), true);
			writer.printf("%s : %s\n", dateFormat.format(new Date()), message);
		} catch (FileNotFoundException e) {
		}
	}

}
