package RestAssuredAPItesting.RestAssuredAPItesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC6_Demo_GET_Authorisation {
	
	
	
	
	@Test
	void authorisation() {
		
		
		
		RestAssured.baseURI="http://localhost:8080/secured/hello";
		
		
		PreemptiveBasicAuthScheme scheme= new PreemptiveBasicAuthScheme();
		
		
		scheme.setUserName("admin");
		scheme.setPassword("password");
		
		
		RestAssured.authentication=scheme;
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"");
		
		
		int statusCode=response.getStatusCode();
		
		System.out.println(response.asString());
		
		
		Assert.assertEquals(200, statusCode);
		
		
		
		
		
		
		
		
		
		
	}
	

}
