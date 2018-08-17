package web.bdd.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

	@FindBy(id= "txtUsername")
	private WebElement username;
	
	@FindBy(id= "txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginbtn;
	
	public void logIn() {
		/*POSSIBLY NEED TO ADD .CLICK() BEFORE SENDING KEYS*/
		username.sendKeys("Admin");
		password.sendKeys("AdminAdmin");
		loginbtn.click();
	}
	
	
}
