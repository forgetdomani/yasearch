package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	public WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "market-search")
	private WebElement searchField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBt;

	public int countResultCards() {
		try {
			List<WebElement> results = driver.findElements(By.className("n-snippet-card2__title"));
			return results.size();
		} catch (Exception e) {
			return 0;
		}
	}
	public int countResultCells() {
		try {
			List<WebElement> results = driver.findElements(By.className("n-snippet-cell2_type_product"));
			return results.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public String GetProductNameByCard(int i) {
		try {
			String RetVal = "";
			List<WebElement> results = driver.findElements(By.className("n-snippet-card2__title"));
			RetVal = results.get(i - 1).findElement(By.tagName("a")).getAttribute("title");
			return RetVal;
		} catch (Exception e) {
			return "";
		}
	}
	public String GetProductNameByCell(int i) {
		try {
			String RetVal = "";
			List<WebElement> results = driver.findElements(By.className("n-snippet-cell2__title"));
			RetVal = results.get(i - 1).findElement(By.tagName("a")).getAttribute("title");
			return RetVal;
		} catch (Exception e) {
			return "";
		}
	}

	public void PerformSearch(String name) {
		try {
			driver.findElement(By.id("header-search")).click();
			driver.findElement(By.id("header-search")).sendKeys(name);
			searchBt.click();
		} catch (Exception e) {
			return;
		}
	}
}
