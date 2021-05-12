package bestBuyAppTests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.restassured.http.ContentType;

public class BestBuyPostRequests {

	private String currentWorkingDirectory;

	@Before
	public void setup() {
		baseURI = "http://ec2-18-116-53-44.us-east-2.compute.amazonaws.com";
		port = 3030;

		currentWorkingDirectory = System.getProperty("user.dir");
	}

	@Test
	public void verifyPostRequest() {

		String requestPayload = "{\r\n" + "  \"name\": \"Samsung Mobile\",\r\n" + "  \"type\": \"Mobile\",\r\n"
				+ "  \"price\": 1000,\r\n" + "  \"shipping\": 12,\r\n" + "  \"upc\": \"Mobile\",\r\n"
				+ "  \"description\": \"Best Mobile Phone\",\r\n" + "  \"manufacturer\": \"Samsung\",\r\n"
				+ "  \"model\": \"string\",\r\n" + "  \"url\": \"string\",\r\n" + "  \"image\": \"string\"\r\n" + "}";

		given().contentType(ContentType.JSON).body(requestPayload).when().post("/products").then().log().all()
				.statusCode(201);

	}

	@Test
	public void verifyPostRequestAsAFile() {

		File requestPayload = new File(currentWorkingDirectory + "/testData/project-request.json");

		given().contentType(ContentType.JSON).body(requestPayload).when().post("/products").then().log().all()
				.statusCode(201);

	}

	@Test
	public void verifyPostRequestAsAnObject() {

		File requestPayload = new File(currentWorkingDirectory + "/testData/project-request.json");

		given().contentType(ContentType.JSON).body(requestPayload).when().post("/products").then().log().all()
				.statusCode(201);

	}

	@Test
	public void dummyRequestPayloadAsExample() {

		Map<String, Object> employeeDetail = new HashMap();

		List<Long> allPhoneNumbers = new ArrayList();
		List<Map<String, Object>> allAddress = new ArrayList();
		
		Map<String, Object> homeAddress = new HashMap();
		
		homeAddress.put("houseNumber", 317);
		homeAddress.put("pinCode", 121317);
		
		Map<String, Object> officeAddress = new HashMap();
		
		homeAddress.put("houseNumber", 4234);
		homeAddress.put("pinCode", 122001);
		
		allAddress.add(homeAddress);
		allAddress.add(officeAddress);
			
		allPhoneNumbers.add(5438759834l);
		allPhoneNumbers.add(36487236487l);
		allPhoneNumbers.add(324632432l);

		employeeDetail.put("firstName", "Saurabh");
		employeeDetail.put("lastName", "Dhingra");
		employeeDetail.put("emailId", "saurabh.d2106@gmail.com");
		
		employeeDetail.put("phoneNumber", allPhoneNumbers);
		
		employeeDetail.put("address", allAddress);
		
		
	}

}
