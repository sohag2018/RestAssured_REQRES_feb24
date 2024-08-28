package endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.UserModulePayload_POJO;
import support.ReuseableMethods;

public class CRUD_UserModule_PropData {

	
	
	// method to create user response-getting url from properties file by calling method
	public static Response createUser(UserModulePayload_POJO data) throws IOException {
		Response response = given().contentType(ContentType.JSON) // "application/json"
				.accept(ContentType.JSON) // "application/json"
				.body(data)

				.when().post(ReuseableMethods.getUrlFromProperties("post_url"));//https://reqres.in/api/users

		return response;

	}

	// method to get user response-getting url from properties file by calling method
	public static Response getUserInfo(String id) throws IOException {
	
		Response response = given().pathParam("userid", id)
				.when().get(ReuseableMethods.getUrlFromProperties("get_url"));

		return response;

	}

	// method to update user response---updateUserInfo
	public static Response updateUserInfo(String id,UserModulePayload_POJO data) throws IOException {
		Response response = given()
				.contentType(ContentType.JSON) // "application/json"
				.accept(ContentType.JSON) // "application/json"
				.body(data)
				.pathParam("userid", id)
			.when().put(ReuseableMethods.getPropertiesURL("put_url"));
			
		return response;

	}

	// method to delete user response-deleteUser
	public static Response deleteUser(String id) throws IOException {
		Response response = given()
				.pathParam("userid", id)
			.when().get(ReuseableMethods.getPropertiesURL("delete_url"));

		return response;

	}
}
