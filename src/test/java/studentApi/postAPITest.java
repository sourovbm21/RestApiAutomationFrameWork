package studentApi;

import baseTest.BaseTest;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import utilities.javaUtils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APIconfig.APIPath;
import APIconfig.headerconfig;
import apiVarification.apiVerification;
import apibuilders.postAPIBuilder;



public class postAPITest extends BaseTest {

	
	
	@Test 
	public void validPostAPITest () {
		
		 
		test.log(LogStatus.INFO, "my test is starting ");
		headerconfig header =new headerconfig();
		postAPIBuilder builder =new postAPIBuilder();
	
		
		Response response=
		RestAssured
		.given()
		.headers(header.defaultHeaders())
		.body(builder.postRequesBody(javaUtils.randomNumber(),javaUtils.randomString(),javaUtils.randomString()))
		.when().post(APIPath.apiPath.CREATE_POST);
		apiVerification.responseCodeVlaidation(response, 201);
		apiVerification.responseKeyValidationfromJsonObject(response,"title");
		apiVerification.responseTimeValidation(response);
		
		test.log(LogStatus.INFO, "my test is ended");
		
	}
	
	
}
