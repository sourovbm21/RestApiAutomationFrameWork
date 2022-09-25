package FunctionalTesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class posrRequestAutomation {

	
	
	
	@Test
	public void postAPIAutomation() {
		RestAssured.baseURI="https://reqres.in/api/users";
	String json="{\\n\" + \n" + 
			"				\"    \\\"name\\\": \\\"morpheus\\\",\\n\" + \n" + 
			"				\"    \\\"job\\\": \\\"leader\\\"\\n\" + \n" + 
			"				\"}";
	
		RestAssured.given().body(json)
		     .when().post()
		     .then()
		     .log().all().statusCode(201);	
	}
	
	
}
