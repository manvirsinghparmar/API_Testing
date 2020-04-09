package RestAssuredAPItesting.RestAssuredAPItesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC5_Demo_GET_JSON_Response_Validation {
	
	

	@Test
	void getweatherDetails() {
		
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		
		RequestSpecification httpRequest=RestAssured.given();
		
		
		
		Response response= httpRequest.request(Method.GET,"/users");
		
		
		JsonPath jsonPath= response.jsonPath();
		
		
	String lat= jsonPath.getString("address[0].geo.lat");		
		
	
	
	Assert.assertEquals("-37.3159", lat);
	
	System.out.println("Lat is :"+ lat);
		
		
		
		
		
	}


}
