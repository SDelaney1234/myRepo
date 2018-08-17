package web.bdd.Assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage {

	@FindBy(id= "employee_name_quick_filter_employee_list_value")
	private WebElement employeesearch;
	
	@FindBy(id="employee_name_quick_filter_employee_list_dropdown")
	private WebElement employeesuggestions;
	
	@FindBy(xpath="//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")
	private WebElement result;
	
	public void searchForEmployee(String name, String id) {
		employeesearch.click();
		employeesearch.sendKeys(name);
		
		employeesearch.sendKeys(Keys.ENTER);
	}
	
	public void verifyEmployee() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
