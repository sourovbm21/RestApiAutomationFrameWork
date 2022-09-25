package apiVarification;

import org.json.JSONArray;
import org.json.JSONObject;

import org.testng.Assert;


import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utilities.ExtentReportsListener;

public class apiVerification extends ExtentReportsListener{

	
	
	
	
	public static void responseCodeVlaidation(Response response, int statusCode) {
		
		
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS, "successfully validate status code"+response.statusCode());
			
		}catch (AssertionError e) {
			
			test.log(LogStatus.FAIL, "expectedStatusCode is ::"+statusCode+"but i am getting "+response.statusCode());
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL,e.fillInStackTrace());
		}
	}
	
	public static void responseKeyValidationfromArray(Response response ,String key) {
		
		try {
		JSONArray array=new JSONArray (response.getBody().asString());
		for (int i=0;i<array.length();i++) {
			
			
			JSONObject obj=array.getJSONObject(i);
			test.log(LogStatus.PASS,"validete value is: "+(obj.get(key)));
			}
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL,e.fillInStackTrace());
		}
	}
	
	
	public static void responseKeyValidationfromJsonObject(Response response ,String key) {
		
		try {
			JSONObject json=new JSONObject (response.getBody().asString());
			if (json.has(key) && json.get(key)!=null) {
				test.log(LogStatus.PASS, "succesfully vlaidate value of "+key+"it is "+json.get(key));
			}else {
				test.log(LogStatus.FAIL, "key is not available");
			}
			
		}catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
		
	}
	
	public static void responseTimeValidation(Response response ) {
		
		try {
			long time=response.time();
			test.log(LogStatus.INFO,"api response time is : "+time);
			
		}catch (Exception e) {
			test.log(LogStatus.FAIL,e.fillInStackTrace());
		}
		
	}
	
	
	
}
