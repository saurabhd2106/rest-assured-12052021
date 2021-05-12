package bestBuyAppTests;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BestBuyApiTest {
	
	@Test
	public void verifyGetProductApi() {
		
	// Create a request (using RequestSpecification)	
	RequestSpecification request =	RestAssured.given();
	
	//Defining the base Url
	request.baseUri("http://ec2-18-116-53-44.us-east-2.compute.amazonaws.com:3030/products");
	
	//Performing a Get action
	Response respone = request.when().get();
	
	respone.prettyPrint();
	
	String responseAsString = respone.asString();
	
	System.out.println(responseAsString);
	
	ValidatableResponse valResponse =	respone.then();
	
	valResponse.statusCode(200);
	
	valResponse.statusLine("HTTP/1.1 200 OK");
	
		
	}

}
