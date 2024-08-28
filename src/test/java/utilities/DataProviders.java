package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//mathod to supply data for reqPayload
	
	@DataProvider(name ="payloadDataProvidr")
	public String[][] getPayLoadData() throws IOException{
		String path="C:\\Users\\enthr\\Desktop\\testDataReqRes.xlsx";
		XLReader xl=new XLReader(path);
		//to create array get r and c number
		int totalrow=xl.getRowcount("Sheet1");
		int totalCol=xl.getCellcount("Sheet1", 1);
		
		//create 2D array and store data
		String data[][]=new String[totalrow][totalCol];;
		
		for(int i=1;i<=totalrow;i++) {
			for(int j=0;j<totalCol;j++) {
				data[i-1][j]=xl.getCellValue("Sheet1", 1, j);
			}		
		}
		return data;
		
		
	}
	
	@DataProvider(name ="payloadDataProvidr_id")
	public String[] getUserID() throws IOException {
		String path="C:\\Users\\enthr\\Desktop\\testDataReqRes_ID.xlsx";
		XLReader xl=new XLReader(path);
		int totalRow=xl.getRowcount("Sheet1");
		 
		String[] ids=new String[totalRow];
		for(int i=1; i<=totalRow;i++) {
			ids[i-1]=xl.getCellValue("Sheet1", i, 1);
		}
		
		return ids;
		
	}
	


}
