package APIconfig;

import java.util.HashMap;
import java.util.Map;

public class headerconfig {

	
	
	public Map<String ,String>defaultHeaders(){
		
		Map<String ,String >defaultHeaders=new HashMap<String ,String>();
		defaultHeaders.put("Content_Type","application/json");
		
		return defaultHeaders;
	}
	
public Map<String ,String>headerswithToken(){
		
		Map<String ,String >defaultHeaders=new HashMap<String ,String>();
		defaultHeaders.put("Content_Type","application/json");
		defaultHeaders.put("Access_Token","fsafhasfsjfskj");
		defaultHeaders.put("Tenet_user","asljfsfjfjflsjfdk");
		
		return defaultHeaders;
	}
	
	

}
	
	

