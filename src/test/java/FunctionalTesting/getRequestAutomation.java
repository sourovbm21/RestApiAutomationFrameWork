package FunctionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class getRequestAutomation {

	
	@Test 
	public void getrequestautomation() {
		RestAssured.baseURI="https://reqres.in/api/users";
		
	Response response =	RestAssured.given().param("page","2").when().get();
	System.out.println("in pretty formate"+response.asPrettyString());
	System.out.println(response.getBody().asString());
	System.out.println("Get Status Line ::  "+response.getStatusLine());
	System.out.println(response.getCookies());
//		RestAssured
//		.given().param("page","2")
//		.when()
//		.get()
//		.then().assertThat()
//		.log().all()
//		.statusCode(200);
//		
		
		 
		  
		   
		
	}
	
	
	
	
}
