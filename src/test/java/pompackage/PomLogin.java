package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	
	// Object Repository
	
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input") WebElement Username;
		@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input") WebElement Password;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement Loginbutton;
	
	// Initiate Page Elements
		
		public PomLogin() {
			PageFactory.initElements(driver, this);
		}
		
		public void typeusername(String name) {
		   Username.sendKeys(name);
			
		}
		public void typepassword(String pass) {
			Password.sendKeys(pass);
		}
		public void clickbutton() {
			Loginbutton.click();
			
		}
		public String verify() {
			return driver.getTitle();
			
		}
	
	
	

}
