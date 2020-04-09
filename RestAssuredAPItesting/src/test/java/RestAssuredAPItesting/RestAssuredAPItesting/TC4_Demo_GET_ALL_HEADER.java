package RestAssuredAPItesting.RestAssuredAPItesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC4_Demo_GET_ALL_HEADER {
	
	@Test
	void getMapDetails() {
		
		
		RestAssured.baseURI="https://www.google.com/";
		
		
		RequestSpecification httpRequest=RestAssured.given();
		
		
		
		Response response= httpRequest.request(Method.GET,"/maps/place/Walmart+Supercentre/@43.7054847,-79.7862728,17z/data=!3m1!4b1!4m5!3m4!1s0x4cce0894a13d3b27:0x2c979faae5ea8860!8m2!3d43.7054847!4d-79.7840841");
		
		
		//String name=response.getBody().asString();
		
		
		String responseBody=response.getBody().asString();
		
		
		//System.out.println(responseBody);
		
		
		Headers ContentType=response.getHeaders();
		
		for(Header header: ContentType) {
			
			System.out.println(header.getName()+""+ header.getValue());
			
			
		}
		
		//System.out.println(ContentType);
	}

}
