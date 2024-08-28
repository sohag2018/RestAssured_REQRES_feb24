package endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.UserModulePayload_POJO;

public class CRUD_UserModule {

	// method to create user response
	public static Response createUser(UserModulePayload_POJO data) {

		Response response = given().contentType(ContentType.JSON) // "application/json"
				.accept(ContentType.JSON) // "application/json"
				.body(data)

				.when().post(All_URLs.post_url);

		return response;

	}

	// method to get user response
	public static Response getUserInfo(String id) {
		Response response = given().pathParam("userid", id).when().get(All_URLs.get_url);

		return response;

	}

	// method to update user response---updateUserInfo
	public static Response updateUserInfo(String id,UserModulePayload_POJO data) {
		Response response = given()
				.contentType(ContentType.JSON) // "application/json"
				.accept(ContentType.JSON) // "application/json"
				.body(data)
				.pathParam("userid", id)
			.when().put(All_URLs.update_url);
			
		return response;

	}

	// method to delete user response-deleteUser
	public static Response deleteUser(String id) {
		Response response = given()
				.pathParam("userid", id)
			.when().get(All_URLs.delete_url);

		return response;

	}
}
