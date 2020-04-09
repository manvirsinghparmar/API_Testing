package RestAssuredAPItesting.RestAssuredAPItesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC1_Demo1_GET {
	
	
	@Test
	void getweatherDetails() {
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		
		RequestSpecification httpRequest=RestAssured.given();
		
		
		
		Response response= httpRequest.request(Method.GET,"/employees");
		
		
		//String name=response.getBody().asString();
		
		int statuscode=response.getStatusCode();
		
		String statusline=response.getStatusLine();
		
		
		
		
		System.out.println("Status Code is "+statuscode);
		
		Assert.assertEquals(200, statuscode);
		
		System.out.println("Status Line is "+ statusline);
		
		Assert.assertEquals("HTTP/1.1 200 OK", statusline);
		
		System.out.println(response.asString());

		
		
		
		
		
		
		
		
	}

}
