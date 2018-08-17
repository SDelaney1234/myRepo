package web.bdd.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.*;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class AssessmentFeatures {

	private WebDriver driver;
	private HomePage home;
	private AddEmployeePage addemp;
	private EmployeeListPage listemp;
	
	private String name= "LorddFake";
	private String surname= "Fakingtonn";
	private String idno= "18488";
	
	private String username= "AUser946";
	private String password= "password";
	
	public ExtentTest test;
	public static ExtentReports report;
	
	//**********************************************************************************
	
	//WebDriverWait wait = new WebDriverWait(driver, 3);
	//wait.until(ExpectedConditions.visibilityOf(autocomplete));#
	
	//**********************************************************************************
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Documents//driver//chromedriver.exe");
		driver= new ChromeDriver();
		report= new ExtentReports("C:\\Users\\Admin\\Documents\\reports\\addingUser.html", true);
		test= report.startTest("Big ol test");
		
		driver.manage().window().maximize();
	}
	
	
	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}
	
	@Given("^the login page$")
	public void the_login_page() {
		test.log(LogStatus.INFO, "Going to log in page");
		driver.get("https://qa-trials641.orangehrmlive.com/auth/login");
		
	}

	@When("^I login$")
	public void i_login() {
		LogInPage login= PageFactory.initElements(driver, LogInPage.class);
		login.logIn();
		test.log(LogStatus.INFO, "Logged in to website");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^I click the PIM tab$")
	public void i_click_the_PIM_tab() {
		home= PageFactory.initElements(driver, HomePage.class);
		home.clickPIMtab();;
		test.log(LogStatus.INFO, "Clicked on PIM tab");
	}

	@When("^then the Add Employee Tab$")
	public void then_the_Add_Employee_Tab() {
		home.clickAddEmployee();
		test.log(LogStatus.INFO, "Clicked on add employee tab");
	}

	@When("^I fill out the Add Employee Details correctly$")
	public void i_fill_out_the_Add_Employee_Details_correctly() {
		addemp= PageFactory.initElements(driver, AddEmployeePage.class);
		addemp.enterBasicDetails(name,surname,idno);
		
		test.log(LogStatus.INFO, "added basic employee details");
	}

	@When("^I choose to create Login Details by clicking the appropriate button$")
	public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
		addemp.chooseToAddLogIn();
		
		test.log(LogStatus.INFO, "chooses to add log in details");
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() {
		addemp.createLogInDetails(username,password);
		
		test.log(LogStatus.INFO, "created username password details");
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() {
		addemp.clickSave();
		
		test.log(LogStatus.INFO, "user saved");
	}

	@Then("^I can search for the Employee I have just created$")
	public void i_can_search_for_the_Employee_I_have_just_created() {
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		home.clickEmployeeList();
		listemp= PageFactory.initElements(driver, EmployeeListPage.class);
		listemp.searchForEmployee(name+" "+surname, idno);
		
		test.log(LogStatus.INFO, "user searched for");
	}

	@Then("^select them for inspection$")
	public void select_them_for_inspection() {
		listemp.verifyEmployee();
		test.log(LogStatus.INFO, "user verified");
		
		if(driver.findElement(By.xpath("//*[@id=\"employee_id\"]")).equals(idno)) {
			test.log(LogStatus.PASS, "Passed the test- user verified");
		} else {
			test.log(LogStatus.FAIL, "Failed To Access Checkout Page");
		}
		
		assertEquals(driver.findElement(By.xpath("//*[@id=\"employee_id\"]")),idno);
	}
	
	
}
