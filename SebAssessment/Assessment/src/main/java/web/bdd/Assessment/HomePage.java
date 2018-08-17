package web.bdd.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath= "//*[@id=\"menu_pim_viewPimModule\"]/a")
	private WebElement pimtab;
	
	@FindBy(xpath= "//*[@id=\"menu_pim_addEmployee\"]")
	private WebElement addemployee;
	
	@FindBy(xpath= "//*[@id=\"menu_pim_viewEmployeeList\"]")
	private WebElement employeelist;
	
	public void clickPIMtab() {
		pimtab.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddEmployee() {
		addemployee.click();
		try {
			Thread.sleep(22000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEmployeeList() {
		employeelist.click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
