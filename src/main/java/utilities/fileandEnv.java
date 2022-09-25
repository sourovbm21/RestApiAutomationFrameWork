package utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

public class fileandEnv {

	public static Map<String ,String>fileandenv= new HashMap<String ,String >();
	public static Properties prop=new Properties();
	
	
	public static Map<String ,String>envAddFile() {
		String environment= System.getProperty("env");//dev,qa,staging
		
		try {
			if (environment.equalsIgnoreCase("dev")) {
				
				//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
				
				prop.load(new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties"));
				fileandenv.put("serverurl",prop.getProperty("serverUrl"));
				fileandenv.put("portnumber",prop.getProperty("port"));
				fileandenv.put("username",prop.getProperty("username"));
				fileandenv.put("pasword",prop.getProperty("password"));
				
				
			}else if(environment.equalsIgnoreCase("qa")) {
				FileInputStream fiqa=new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
				prop.load(fiqa);
				fileandenv.put("serverurl",prop.getProperty("serverUrl"));
				fileandenv.put("portnumber",prop.getProperty("port"));
				fileandenv.put("username",prop.getProperty("username"));
				fileandenv.put("pasword",prop.getProperty("password"));
			}else if(environment.equalsIgnoreCase("qa")) {
				FileInputStream fiqa=new FileInputStream(System.getProperty("user.dir")+"/inputs/staging.properties");
				prop.load(fiqa);
				fileandenv.put("serverurl",prop.getProperty("serverUrl"));
				fileandenv.put("portnumber",prop.getProperty("port"));
				fileandenv.put("username",prop.getProperty("username"));
				fileandenv.put("pasword",prop.getProperty("password"));
			}
			
		}catch (Exception e) {
			
		}
		return fileandenv;
	}
	
	
	public static Map<String,String>getconfigReader() {
		
		if(fileandenv==null) {
		fileandenv=envAddFile();
		}
		return fileandenv;
	}

}
