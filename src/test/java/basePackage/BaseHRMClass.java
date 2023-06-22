package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;

public class BaseHRMClass {
	
	public static WebDriver driver;
	public static Properties prop=new Properties();
	
//Step: 1 Export or Read any file into BaseClass
	
	public BaseHRMClass() {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\Heeraa\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
// Step: 2 Initiation
	
	public static void initiation() throws InterruptedException {
	String browsername=prop.getProperty("browser");
	
		if(browsername.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");	
		driver=new FirefoxDriver();	
		}
		else if(browsername.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
		driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Timeutils.timepage));
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		
	}
	
	public static void screenshots(String Filename) throws IOException {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C:\\Users\\Heeraa\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg"));
		
	}
	

}
