package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPage {
	public WebDriver driver;

	public YandexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@data-id='market']")
	private WebElement yaMarket;

	@FindBy(xpath = "//li[@data-department='Электроника']")
	private WebElement electronics;

	@FindBy(css = "div.catalog-menu")
	private WebElement sideMenu;

	@FindBy(partialLinkText = "Перейти ко всем фильтрам")
	private WebElement searchDetails;

	public void goToMarket() {
		try {
			yaMarket.click();
		} catch (Exception e) {
			return;
		}
	}

	public void goToElectronics() {
		try {
			electronics.click();
		} catch (Exception e) {
			return;
		}
	}
	public void goToDepartment(String department) {
		try {
			List<WebElement> depts = sideMenu.findElements(By.partialLinkText(department));
			for(WebElement dept:depts) {
				if(dept.isDisplayed())
					dept.click();
			}
			
		} catch (Exception e) {
			return;
		}
	}


	public void goToSearchDetials() {
		try {
			searchDetails.click();
		} catch (Exception e) {
			return;
		}
	}
}
