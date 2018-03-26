package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	public WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(tagName = "h1")
	private WebElement productName;

	public String GetProductName() {
		try {
			return productName.getText();
		} catch (NoSuchElementException e) {
			return "";
		}
	}
}
