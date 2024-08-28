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
import utilities.DataProviders;
import utilities.XLReader;

public class Test_UserModule_dataProvider {
	//for debugging purpose
	//@Test
	public void readdata() throws IOException {
		String path="C:\\Users\\enthr\\Desktop\\testDataReqRes.xlsx";
		XLReader xl=new XLReader(path);
		//to create array get r and c number
		int totalrow=xl.getRowcount("Sheet1");
		int totalCol=xl.getCellcount("Sheet1", 1);
		
		//create 2D array and store data
		String data[][]=new String[totalrow][totalCol];

		for(int i=1;i<=totalrow;i++) {
			for(int j=0;j<totalCol;j++) {
				data[i-1][j]=xl.getCellValue("Sheet1", 1, j);
			}		
		}
		
		System.out.println(data[1][1]);
		
	}
	

	//dataProvider = "data-provider", dataProviderClass = DP.class
	//@Test(priority=1,dataProvider="payloadDataProvidr",dataProviderClass=DataProviders.class)
	public void test(String name,String job) throws IOException {	
		UserModulePayload_POJO data=new UserModulePayload_POJO();
		data.setName(name);
		data.setJob(job);	
	System.out.println(data.getName());
	System.out.println(data.getJob());
	
		
	}
	
	//Main test case
	//@Test(priority=1,dataProvider="payloadDataProvidr",dataProviderClass=DataProviders.class)
	public void testCreateUser(String name,String job) throws IOException {	
		UserModulePayload_POJO data=new UserModulePayload_POJO();
		data.setName(name);
		data.setJob(job);	
	//Response response=	CRUD_UserModule.createUser(data);
	Response response=	CRUD_UserModule_PropData.createUser(data);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 201);
		
	}
	
	
//	@Test(priority=2,dataProvider="payloadDataProvidr_id",dataProviderClass=DataProviders.class)
	public void testGetUser(String id) throws IOException {	
	Response response=	CRUD_UserModule_PropData.getUserInfo(id);
	response.then().log().all();//to see in consol
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=2,dataProvider="payloadDataProvidr_id",dataProviderClass=DataProviders.class)
	public void testUpdateUser(String id) {	
		
		UserModulePayload_POJO data=new UserModulePayload_POJO();
		data.setName("Narimar");
		data.setJob("Manager");	
		
	Response response=	CRUD_UserModule.updateUserInfo(id,data);
	response.then().log().all();//to see in consol
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//after update
	Response responseAfterUpdate=	CRUD_UserModule.getUserInfo("2");
	Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	
		
	}
	
	//test delete operaton
	@Test(priority=4,dataProvider="payloadDataProvidr_id",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String id) {	
	Response response=	CRUD_UserModule.deleteUser(id);
	response.then().log().all();//to see in consol
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
