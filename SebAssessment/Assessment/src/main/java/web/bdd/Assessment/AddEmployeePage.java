package web.bdd.Assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {

	@FindBy(id= "firstName")
	private WebElement firstname;
	
	@FindBy(id= "lastName")
	private WebElement lastname;
	
	@FindBy(xpath= "//*[@id=\"location_inputfileddiv\"]/div/input")
	private WebElement dropdown;
	
	@FindBy(id= "employeeId")
	private WebElement idno;
	
	@FindBy(xpath= "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
	private WebElement createlogdeets;
	
	@FindBy(id= "username")
	private WebElement username;
	
	@FindBy(id= "password")
	private WebElement password;
	
	@FindBy(id= "confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id= "systemUserSaveBtn")
	private WebElement saveuser;
	
	public void enterBasicDetails(String name, String surname, String idnno) {
		firstname.sendKeys(name);
		lastname.sendKeys(surname);
		idno.sendKeys(idnno);

		dropdown.click();
		dropdown.sendKeys(Keys.DOWN);
		dropdown.sendKeys(Keys.DOWN);
		dropdown.sendKeys(Keys.DOWN);
		dropdown.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void chooseToAddLogIn() {
		createlogdeets.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void createLogInDetails(String usernname, String pass) {
		username.click();
		username.sendKeys(usernname);	//NEED TO MANUALLY CHANGE FOR EACH TEST :/
		password.click();
		password.sendKeys(pass);
		confirmPassword.sendKeys(pass);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void clickSave() {
		saveuser.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
