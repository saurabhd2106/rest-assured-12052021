package bestBuyAppTests;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class BestBuyApiTest2 {
	
	@Before
	public void setup() {
		baseURI = "http://ec2-18-116-53-44.us-east-2.compute.amazonaws.com";
		port = 3030;
	}
	
	@Test
	public void verifyGetRequest() {
		
		 given()
		.when()
		.get("/products")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
	}

	@Test
	public void verifyGetRequestWithQueryParams() {
		
		 given()
		 .queryParam("$limit", 5)
		 .log().all()
		.when()
		.get("/products")
		.then()
		.log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void verifyGetRequestWithMultipleQueryParams() {
		
		 given()
		 .queryParams("$limit", 5, "$skip", 2)
		 .log().all()
		.when()
		.get("/products")
		.then()
		.log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void verifyGetRequestWithMultipleQueryParamsAsMap() {
		
		Map<String, Object> params = new HashMap();
		
		params.put("$limit", 5);
		params.put("$skip", 2);
		
		 given()
		 .queryParams(params)
		 .log().all()
		.when()
		.get("/products")
		.then()
		.log().all()
		.statusCode(200)
		.body("limit", equalTo(6))
		.statusLine("HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void verifyGetRequestWithPathParams() {
		
		 given()
	     .pathParam("id", 48530)
		 .log().all()
		.when()
		.get("/products/{id}")
		.then()
		.log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
	}
}
