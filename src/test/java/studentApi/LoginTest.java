package studentApi;

import org.testng.annotations.Test;

import pojo.Credentials;
import utilities.javaUtils;

public class LoginTest {

	
	
	
	
	
	@Test 
	public void loginTest () {
		
		Credentials logincred=new Credentials();
		Credentials loginCred=javaUtils.base64encode("admin", "password");
		System.out.println(loginCred);
		
	}
	
	
}
