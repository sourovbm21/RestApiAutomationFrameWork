package baseTest;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import utilities.ExtentReportsListener;
import utilities.fileandEnv;




@Listeners(ExtentReportsListener.class)
public class BaseTest extends ExtentReportsListener{

	
	
	
	
	@BeforeClass
	public void baseTest() {
		  
		
		System.out.println(fileandEnv.envAddFile().get("portnumber"));
		System.out.println(fileandEnv.envAddFile().get("serverurl"));
		RestAssured.baseURI=fileandEnv.envAddFile().get("serverurl");
	
	}
	
	
	
}
