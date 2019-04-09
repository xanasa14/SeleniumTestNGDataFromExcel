//Download and copy and paste the jar file into the project: 
// https://drive.google.com/file/d/0B2i0eXr3_uQDSFpkUElzNGNkYm8/view

//Download and extract into a new folder. Then, add external jar files in the project.
// https://www.apache.org/dyn/closer.lua/poi/dev/bin/poi-bin-3.17-beta1-20170701.tar.gz
	

import java.util.ArrayList;
import com.excel.utility.*;
public class TestUtil {
	
	static Xls_Reader reader; 
		
	public static ArrayList<Object[]> getDatafromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C://Users/Administrator/eclipse-workspace/TestNGGoogle/src/SelPractice.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum<=reader.getRowCount("SelPractice.xlsx"); rowNum++ ) {
			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			String email = reader.getCellData("RegTestData", "email", rowNum);
			String password = reader.getCellData("RegTestData", "password", rowNum);
			Object ob[] = {firstName, lastName, email, password};
			myData.add(ob);
		}
		
		
		return myData;
		
	}
}
