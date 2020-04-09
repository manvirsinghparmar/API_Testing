package RestAssuredAPItesting.RestAssuredAPItesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC2_Demo1_POST {

	@Test
	void registerUser() {

		// Create the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Create Request Specification
		RequestSpecification httpRequest = RestAssured.given();

		// Create JSON object
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("FirstName", "walia");
		jsonObject.put("LastName", "baby");
		jsonObject.put("UserName", "wl");
		jsonObject.put("Password", "wl123");
		jsonObject.put("Email", "wlh@gmail.com");

		httpRequest.header("Content- Type", "application/json");

		httpRequest.body(jsonObject.toJSONString());

		Response postResponse = httpRequest.request(Method.POST, "/register");

		String name = postResponse.getBody().asString();
		
		System.out.println("Response is " + name);

		Assert.assertEquals(name.contains("Ridhan"), true);
		

	}

}
