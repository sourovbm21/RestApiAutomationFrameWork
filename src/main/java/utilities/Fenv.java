package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Fenv {
	
	
	

	public static Map<String ,String > main()  {
		
		
	Properties prop=new Properties();
	Map<String ,String > m=new HashMap<String,String>();
	
	try {
		String 	envName=System.getProperty("env");
		
		if (envName.equalsIgnoreCase("dev")) {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
			prop.load(fis);
			m.put("serverurl",prop.getProperty("serverUrl"));
			m.put("port",prop.getProperty("port"));
			m.put("username",prop.getProperty("username"));
			m.put("pwd", prop.getProperty("password"));
			
		}else if(envName.equalsIgnoreCase("qa")) {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
			prop.load(fis);
			m.put("serverurl",prop.getProperty("serverUrl"));
			m.put("port",prop.getProperty("port"));
			m.put("username",prop.getProperty("username"));
			m.put("pwd", prop.getProperty("password"));
			
			
			
		}else if  (envName.equalsIgnoreCase("staging")){
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/staging.properties");
			prop.load(fis);
			m.put("serverurl",prop.getProperty("serverUrl"));
			m.put("port",prop.getProperty("port"));
			m.put("username",prop.getProperty("username"));
			m.put("pwd", prop.getProperty("password"));
		}
		
	}catch(Exception e) {
		
		
	   }
			
	return m;
	}


	public static void deleteDirectory(File directory) {
		
		
		
		if (directory.exists()) {
			
			File []files=directory.listFiles();
			if (files !=null) {
				
				for (int i=0;i<files.length;i++) {
					if (files[i].isDirectory()) {
						
						deleteDirectory(files[i]);
					}else 
						files[i].delete();
				}
			}
			
		}
		
	}
	
 }
