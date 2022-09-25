package studentApi;

import org.testng.annotations.Test;

import APIconfig.APIPath;
import APIconfig.headerconfig;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.postAPIPojo;

public class serTest extends BaseTest{
  
	
	
	
	
	
	
	@Test 
	public void serTest1() {
		
		
		headerconfig head=new headerconfig();
		postAPIPojo pojo=new postAPIPojo(12,"sourov server","uk");
		System.out.println(pojo.toString());
		Response response=
		RestAssured
		.given()
		  .headers(head.defaultHeaders())
		  .body(pojo)
		.when()
		  .post(APIPath.apiPath.CREATE_POST);
		
		System.out.println(pojo.getId());
		System.out.println(pojo.getAuthor());
		System.out.println(pojo.getTitle());
		  
		
		
	}
	
	
	
	
	
}
