package yandex_TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import yandex_Base.Base;
import yandex_Pages.YandexSearchHomePage;
import yandex_Pages.YandexSearchResultsPage;
import yandex_Pages.YandexVideoSearchResultPage;

public class YandexSearchHomePageTest extends Base {
	// Below the reference object variables are declared
	public YandexSearchHomePage hp;
	public YandexSearchResultsPage rp;
	public YandexVideoSearchResultPage vrp;

	public YandexSearchHomePageTest() throws IOException {
		super();

	}

//Below @BeforeMethod annotations is used to call the initialization method and creating objects before every @Test Methods
	@BeforeMethod
	public void launch() throws IOException {
		initialization();
		hp = new YandexSearchHomePage();
		rp = new YandexSearchResultsPage();
		vrp = new YandexVideoSearchResultPage();
	}

//Below are different Methods to test the product functionality

	@Test
	public void enterSearchText() throws IOException {
		hp.enterTextInSearchbox();

	}
	// Below code implementation is to verify the search results

	@Test
	public void verifySearch() throws IOException {
		hp.enterTextInSearchbox();
		rp.verifySearchResults();

	}

//Below code implementation is to verify the navigation
	@Test
	public void verifyNavigation() throws IOException {

		hp.enterTextInSearchbox();
		rp.verifySearchResultsPageTitle();

	}

//Below code implementation is to verify the most recent video feed
	@Test
	public void verifyingTheVideoFeed() throws IOException {
			
		vrp.clickOnVideo();
		

	}
	// Below is the implementation of @AfterMethod in which the browser is getting
	// closed after @Test method run

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
