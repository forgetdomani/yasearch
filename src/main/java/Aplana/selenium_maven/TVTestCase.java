package Aplana.selenium_maven;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.ProductDetailsPage;
import pages.SearchDetailsPage;
import pages.SearchResultsPage;
import pages.YandexPage;
import testdatamodels.Product;
import testdatamodels.SearchCriteria;

public class TVTestCase {

	private static WebDriver driver;
	private static YandexPage homePage;
	private static SearchDetailsPage searchDetailsPage;
	private static SearchResultsPage searchResultsPage;
	private static ProductDetailsPage productDetailsPage;

	@BeforeClass
	public static void setup() {

		System.setProperty("webdriver.gecko.driver", "c:\\gecodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new YandexPage(driver);
		searchDetailsPage = new SearchDetailsPage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		// 1. Открыть браузер и развернуть на весь экран.
		driver.manage().window().maximize();
		driver.navigate().to("http://yandex.ru");
	}

	@Test
	public void TVSearchTest() {

		ArrayList<String> searchForBrands = new ArrayList<String>();
		searchForBrands.add("Samsung");
		searchForBrands.add("LG");
		SearchCriteria tvSearch = new SearchCriteria();
		tvSearch.setBrands(searchForBrands);
		tvSearch.setMinPrice("20000");

		// 3. Перейти в яндекс маркет
		homePage.goToMarket();

		// 4. Выбрать раздел Электроника
		homePage.goToElectronics();

		// 5. Выбрать раздел Телевизоры
		homePage.goToDepartment("Телевизоры");

		// 6. Зайти в расширенный поиск
		homePage.goToSearchDetials();

		// 7. Задать параметр поиска от 20000 рублей.
		searchDetailsPage.setMinPrice(tvSearch.getMinPrice());

		// 8. Выбрать производителей Samsung и LG
		searchDetailsPage.selectBrands(tvSearch.getBrands());

		// 9. Нажать кнопку Применить.
		searchDetailsPage.showSearchResults();

		// 10. Проверить, что элементов на странице 12.
		// Прим: по умолчанию выводит 48
		int searchresultscount = searchResultsPage.countResultCards();
		Assert.assertEquals(searchresultscount, 48);

		// 11. Запомнить первый элемент в списке.
		Product firstTVinSearchResults = new Product(searchResultsPage.GetProductNameByCard(1));

		// 12. В поисковую строку ввести запомненное значение.
		searchResultsPage.PerformSearch(firstTVinSearchResults.getName());
		
		// 13. Найти и проверить, что наименование товара соответствует запомненному значению.
		Product anotherTVInSearchResults = new Product(productDetailsPage.GetProductName());
		Assert.assertTrue(firstTVinSearchResults.equals(anotherTVInSearchResults));

	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}
}
