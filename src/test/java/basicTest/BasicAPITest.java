package basicTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BasicAPITest {
	
	@Test
	public void getSingleUserInfo() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200).log().all();
		
	}
	

}
