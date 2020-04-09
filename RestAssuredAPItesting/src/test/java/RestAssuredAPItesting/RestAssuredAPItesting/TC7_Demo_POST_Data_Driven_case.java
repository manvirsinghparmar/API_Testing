package RestAssuredAPItesting.RestAssuredAPItesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC7_Demo_POST_Data_Driven_case {

	@Test(dataProvider = "employeeDetails" )
	void dataDrivenCase(String eName,String eSalary,String eAge) {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", eName);
		jsonObject.put("salary", eSalary);
		jsonObject.put("age", eAge);

		System.out.println("JSON object is: " + jsonObject);

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(jsonObject.toJSONString());

		System.out.println(jsonObject.toJSONString());

		Response response = httpRequest.request(Method.POST, "/create");

		int sCode = response.getStatusCode();

		String responseLine=response.getStatusLine();
		
		System.out.println(responseLine);
		Assert.assertEquals(sCode, 200);
		//Assert.assertEquals(responseLine, );
		
		Assert.assertEquals(response.getBody().asString().contains(eName), true);

	}
	
	
	
	@DataProvider(name="employeeDetails")
	String[][] dataProvider() throws IOException {
		
		
		String filePath="C:\\Users\\Owner\\eclipse-workspace\\RestAssuredAPItesting\\src\\test\\java\\RestAssuredAPItesting\\RestAssuredAPItesting\\EmployeeDetails.xlsx";
		
		int row=XLutils.getRowCount(filePath, "Sheet1");
		int column=XLutils.getCellCount(filePath, "Sheet1", 1);
		
		System.out.println("Row is: " + row);
		System.out.println("Column is :");
		
		String[][] empdata = new String[row][column];
		
		
		for(int i=1;i<=row;i++) {
			
			
			for(int j=0;j< column;j++) {
				
				
				empdata [i-1][j] =XLutils.getCellData(filePath, "Sheet1", i, j); 
				
			}
			
			
		}
		
		
		
		
		
		return empdata;
		
		
	}

}
