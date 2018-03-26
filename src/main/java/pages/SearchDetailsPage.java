package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDetailsPage {
	public WebDriver driver;

	public SearchDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "glf-pricefrom-var")
	private WebElement minPrice;
	@FindBy(linkText = "Показать подходящие")
	private WebElement searchResultsBt;

	public void setMinPrice(String price) {
		minPrice.sendKeys(price);
	}

	public void selectBrands(ArrayList<String> brands) {
		try {
			WebElement brandSection = driver.findElement(By.xpath(
					"//span[@class='title__content' and text()='Производитель']/ancestor::div[@class = 'n-filter-block__header']"))
					.findElement(By.xpath(".."));
			for (String brand : brands) {
				brandSection.findElement(By.linkText(brand)).click();
			}
		} catch (Exception e) {
			return;
		}
	}

	public void showSearchResults() {
		try {
		searchResultsBt.click();
		} catch (Exception e) {
			return;
		}
	}
}
