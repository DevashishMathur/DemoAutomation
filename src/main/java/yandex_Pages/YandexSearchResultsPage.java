package yandex_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import yandex_Base.Base;

public class YandexSearchResultsPage extends Base {
	//This is the page factory of search result page

	public YandexSearchResultsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}
//Below is the list of webelements stored in List Interface
	@FindBy(xpath = "//div[@class='organic__url-text']/child::b")
	List<WebElement> noOfLinks;
	
	//Below is the method to verify that the user is navigated successfully on the search result page
	
	public void verifySearchResultsPageTitle() {
		String titleOfSearchResultPage=driver.getTitle();
		
		System.out.println(titleOfSearchResultPage);
		Assert.assertEquals(titleOfSearchResultPage, "Yandex", "User is not successfully navigated to Search results page");
		System.out.println("User is successfully navigated to Search Result Page");
	}
	
	//Below is the method to verify that the search results are related to the user input

	public void verifySearchResults() {
		int temp = 0;

		for (int i = 0; i < noOfLinks.size(); i++) {


			if ((prop.getProperty("text").contains(noOfLinks.get(i).getText()))) {
				temp++;

			}
		}

		if (temp > 1) {
			System.out.println("The search results are coming related to the user input");

		}

	}

}
