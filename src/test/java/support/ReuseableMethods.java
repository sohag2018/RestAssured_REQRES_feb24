package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReuseableMethods {
	
	//method to read property file (returning ResourceBundle)
		public static String getUrlFromProperties(String key) {
			ResourceBundle reourcebundle=ResourceBundle.getBundle("data");//.properties file should be in proper src
		String	url=reourcebundle.getString(key);
			
			return url;}

		
		
		//method using Properies obj-returns url (string)
		public static String getPropertiesURL(String key) throws IOException {
			Properties prop=new Properties();
			InputStream input=new FileInputStream("C:\\Users\\enthr\\eclipse-workspace-lecture\\com.testFramework.reqres\\src\\test\\java\\data.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//file load
			String url=prop.getProperty(key);
			return url;
			
		}
		
		
}
