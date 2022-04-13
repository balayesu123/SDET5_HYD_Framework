import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJsonTest {
   @Test
   public void readDataFromjson() throws Exception
   {
	   FileReader fr=new FileReader("C:\\Users\\sivaram\\eclipse-workspace\\SDET_HYD_5\\jsonBody.json");
	   JSONParser jp=new JSONParser();
	   Object jobj=jp.parse(fr);
	   HashMap hm=(HashMap)jobj;
	   String value=(String)hm.get("status");
	   System.out.println(value);
			   
   }
}
