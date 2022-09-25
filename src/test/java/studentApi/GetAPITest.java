package studentApi;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APIconfig.APIPath;
import apiVarification.apiVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;







public class GetAPITest extends BaseTest {

	
	
	
	@Test 
	public void getAPITest() {
		
		
		test.log(LogStatus.INFO,"my test is starting ");
		
		Response response=
		RestAssured.given().log().all()
		.when().get(APIPath.apiPath.GET_LIST_OF_POST);
	
	
		apiVerification.responseKeyValidationfromArray(response,"title");
		apiVerification.responseCodeVlaidation(response, 400);
		apiVerification.responseTimeValidation(response);
		
		test.log(LogStatus.INFO,"my test is finished");

//		System.out.println("the response is :"+response.asPrettyString());
//		System.out.println("the response body  :"+response.getBody().asString());
//		System.out.println("the response cookes  :"+response.getCookies());;
//		System.out.println("the response id and time  :"+response.getSessionId()+" "+response.getTime());;
//		response.getStatusCode();
//		
//		JSONArray array =new JSONArray(response.getBody().asString());
//		for (int i=0;i<array.length();i++)
//		{
//			array.get(i);
//			JSONObject obj=new JSONObject(i);
//		}
		
	}
	
	
}
