package testLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.Excelsheet;

public class Logintest extends BaseHRMClass {

	PomLogin Log;
	
	public Logintest() {
		super();	// Initialize or Read Config.properties.Calling constructor of Parent class
	}
	
@BeforeMethod
	public void initialsetup() throws InterruptedException, IOException {
		initiation();	// Calling values from Config.properties
		screenshots("Login");
		Log= new PomLogin(); //Calling methods of PomLogin 
	}
	
@Test
	public void Title() {
	String actual=Log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual, "OrangeHRM");
	
}

@DataProvider // Read Data from Excel sheet
public Object[][] Details(){
	Object result[][]=Excelsheet.readdata("Sheet1");
	return result;

	
}

@Test(dataProvider="Details")
	public void Login(String name,String password) {
	Log.typeusername(name);
	Log.typepassword(password);
	Log.clickbutton();
}
@AfterMethod
	public void close() {
	driver.close();
}


	
	
}
