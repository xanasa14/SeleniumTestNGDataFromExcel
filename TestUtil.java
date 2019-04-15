//Download and copy and paste the jar file into the project: 
// https://drive.google.com/file/d/0B2i0eXr3_uQDSFpkUElzNGNkYm8/view

//Download and extract into a new folder. Then, add external jar files in the project.
// https://www.apache.org/dyn/closer.lua/poi/dev/bin/poi-bin-3.17-beta1-20170701.tar.gz
	
//Make sure to edit excel colummns from the source project site.
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
		
		for (int rowNum = 2; rowNum<=reader.getRowCount("Sheet1"); rowNum++ ) {
			String firstName = reader.getCellData("Sheet1", "firstname", rowNum);
			String lastName = reader.getCellData("Sheet1", "lastname", rowNum);
			String e = reader.getCellData("Sheet1", "e", rowNum);
			System.out.println("the email is "  + e);
			String password = reader.getCellData("Sheet1", "p", rowNum);
			System.out.println(password);
			System.out.println(firstName + " " + e);
			Object ob[] = {firstName, lastName, e, password};
			myData.add(ob);
		}
		
		
		return myData;
		
	}
	
	/*
	 * So, in student.Student@82701e that you get as output ->
	 * 
	 * student.Student is the Type, and 82701e is the HashCode So, you need to
	 * override a toString method in your Student class to get required String
	 * representation: -
	 * 
	 * @Override public String toString() { return "Student No: " +
	 * this.getStudentNo() + ", Student Name: " + this.getStudentName(); }
	 */
		
	
	
	
	
}
