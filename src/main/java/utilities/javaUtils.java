package utilities;

import java.util.Base64;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import pojo.Credentials;

public class javaUtils {

	
	
	public static  Credentials base64encode(final String username,final String password) {
		
		String cred=username+":"+password;
		
		cred=Base64.getEncoder().encodeToString(cred.getBytes());
		System.out.println(cred);
	
		Credentials logincred =new Credentials();
		logincred.setCredentials(cred);
		
		return logincred;
	}
	
	
	public static String randomNumber() {
		
		Random random =new Random();
		int randomNumber=random.nextInt(1000);
		String id=Integer.toString(randomNumber);
		
		return id ;
	}
	
	public static String randomString() {
		
		String randomString =RandomStringUtils.randomAlphabetic(8);
		return randomString;
	}
	
	
}
