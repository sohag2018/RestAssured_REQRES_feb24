package api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.CRUD_UserModule;
import endpoints.CRUD_UserModule_PropData;
import io.restassured.response.Response;
import payload.UserModulePayload_POJO;

public class Test_UserModule {
	UserModulePayload_POJO data;
	Faker faker;
	
	@BeforeClass
	public void setData() {
		data=new UserModulePayload_POJO();
		faker=new Faker();
		data.setName(faker.name().firstName());
		data.setJob(faker.job().title());	
	}
	@Test(priority=1)
	public void testCreateUser() throws IOException {	
	//Response response=	CRUD_UserModule.createUser(data);
	Response response=	CRUD_UserModule_PropData.createUser(data);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 201);
		
	}
	
	
	@Test(priority=2)
	public void testGetUser() throws IOException {	
	//Response response=	CRUD_UserModule.getUserInfo("2");
	Response response=	CRUD_UserModule_PropData.getUserInfo("2");
	response.then().log().all();//to see in consol
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=3)
	public void testUpdateUser() {	
		
		data.setName(faker.name().firstName());
		data.setJob(faker.job().title());
		
	Response response=	CRUD_UserModule.updateUserInfo("2",data);
	response.then().log().all();//to see in consol
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//after update
	Response responseAfterUpdate=	CRUD_UserModule.getUserInfo("2");
	Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	
		
	}
	
	//test delete operaton
	@Test(priority=4)
	public void testDeleteUser() {	
	Response response=	CRUD_UserModule.deleteUser("2");
	response.then().log().all();//to see in consol
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
