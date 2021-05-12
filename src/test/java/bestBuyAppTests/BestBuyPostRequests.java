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
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.http.HttpResponseException;
import io.restassured.response.Response;
import pojo.Address;
import pojo.EmployeePojo;

public class BestBuyPostRequests {

	private String currentWorkingDirectory;

	@Before
	public void setup() {
		baseURI = "http://ec2-18-116-53-44.us-east-2.compute.amazonaws.com";
		port = 3030;

		currentWorkingDirectory = System.getProperty("user.dir");
	}

	@Test
	@Ignore
	public void verifyPostRequest() {

		String requestPayload = "{\r\n" + "  \"name\": \"Samsung Mobile\",\r\n" + "  \"type\": \"Mobile\",\r\n"
				+ "  \"price\": 1000,\r\n" + "  \"shipping\": 12,\r\n" + "  \"upc\": \"Mobile\",\r\n"
				+ "  \"description\": \"Best Mobile Phone\",\r\n" + "  \"manufacturer\": \"Samsung\",\r\n"
				+ "  \"model\": \"string\",\r\n" + "  \"url\": \"string\",\r\n" + "  \"image\": \"string\"\r\n" + "}";

		given().contentType(ContentType.JSON).body(requestPayload).when().post("/products").then().log().all()
				.statusCode(201);

	}

	@Test
	@Ignore
	public void verifyPostRequestAsAFile() {

		File requestPayload = new File(currentWorkingDirectory + "/testData/project-request.json");

		given().contentType(ContentType.JSON).body(requestPayload).when().post("/products").then().log().all()
				.statusCode(201);

	}

	@Test
	@Ignore
	public void verifyPostRequestAsAnObject() {

		Map<String, Object> requestPayload = new HashMap<String, Object>();

		requestPayload.put("name", "Samsung Mobile");
		requestPayload.put("type", "Mobile");
		requestPayload.put("upc", "04133824019");
		requestPayload.put("price", 500);
		requestPayload.put("shipping", 40);
		requestPayload.put("description", "Samsung best Mobile");
		requestPayload.put("manufacturer", "Samsung");
		requestPayload.put("model", "M21");

		given().contentType(ContentType.JSON).body(requestPayload).when().post("/products").then().log().all()
				.statusCode(201);

	}
	
	@Test
	@Ignore
	public void verifyPostRequestWithGetRequest() {

		Map<String, Object> requestPayload = new HashMap<String, Object>();

		requestPayload.put("name", "Samsung Mobile");
		requestPayload.put("type", "Mobile");
		requestPayload.put("upc", "04133824019");
		requestPayload.put("price", 500);
		requestPayload.put("shipping", 40);
		requestPayload.put("description", "Samsung best Mobile");
		requestPayload.put("manufacturer", "Samsung");
		requestPayload.put("model", "M21");

		Response respone = given().contentType(ContentType.JSON).body(requestPayload).when().post("/products");
		
		int id = respone.then().extract().path("id");
		
		System.out.println("---- Product Id : "+id +"-------------------");
		
		respone.then().log().all().statusCode(201);
		
		given()
	     .pathParam("id", id)
		 .log().all()
		.when()
		.get("/products/{id}")
		.then()
		.log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");

	}
	
	
	@Test
	public void verifyPutRequest() {

		Map<String, Object> requestPayload = new HashMap<String, Object>();

		requestPayload.put("name", "Samsung Mobile");
		requestPayload.put("type", "Mobile");
		requestPayload.put("upc", "04133824019");
		requestPayload.put("price", 500);
		requestPayload.put("shipping", 40);
		requestPayload.put("description", "Samsung best Mobile");
		requestPayload.put("manufacturer", "Samsung");
		requestPayload.put("model", "M21");

		Response respone = given().contentType(ContentType.JSON).body(requestPayload).when().post("/products");
		
		int id = respone.then().extract().path("id");
		
		System.out.println("---- Product Id : "+id +"-------------------");
		
		respone.then().log().all().statusCode(201);
		
		given()
	     .pathParam("id", id)
		
		.when()
		.get("/products/{id}")
		.then()
		
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
		//Put Request (Update) --------------------
		
		
		Map<String, Object> requestPayloadUpdated = new HashMap<String, Object>();

		requestPayloadUpdated.put("name", "Iphone Mobile");
		requestPayloadUpdated.put("type", "Mobile");
		requestPayloadUpdated.put("upc", "04133824019");
		requestPayloadUpdated.put("price", 500);
		requestPayloadUpdated.put("shipping", 40);
		requestPayloadUpdated.put("description", "Best Mobile");
		requestPayloadUpdated.put("manufacturer", "Apple");
		requestPayloadUpdated.put("model", "I12");
		
		
		
		Response responeUpdated = given().contentType(ContentType.JSON).body(requestPayloadUpdated).when().put("/products/"+id);
		
		int updatedId = responeUpdated.then().extract().path("id");
		
		System.out.println("---- Product Id : "+updatedId +"-------------------");
		
		responeUpdated.then().log().all().statusCode(200);
		

		given()
	     .pathParam("id", updatedId)
		 
		.when()
		.get("/products/{id}")
		.then()
		
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
	}

	
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

	
	public void dummyRequestPayloadAsExampleWithPojo() {

		EmployeePojo requestpayload = new EmployeePojo();

		requestpayload.setName("Saurabh");

		requestpayload.setLastName("Dhingra");

		requestpayload.setEmail("saurabh.d2106@gmail.com");

		List<Long> phoneNumbers = new ArrayList();

		phoneNumbers.add(45783467l);
		phoneNumbers.add(45783497598l);
		phoneNumbers.add(437568347l);

		requestpayload.setAllPhoneNumber(phoneNumbers);

		Address homeAddress = new Address();

		homeAddress.setHouseNumber("317");
		homeAddress.setType("Home");
		homeAddress.setPincode("3423344");

		Address officeAddress = new Address();

		homeAddress.setHouseNumber("3432");
		homeAddress.setType("Office");
		homeAddress.setPincode("122001");
		
		List<Address> allAddress = new ArrayList();
		
		allAddress.add(homeAddress);
		allAddress.add(officeAddress);
		
		requestpayload.setAllAddress(allAddress);
		
		

	}

}
