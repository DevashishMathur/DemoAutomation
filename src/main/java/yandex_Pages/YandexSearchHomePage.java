package yandex_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yandex_Base.Base;

public class YandexSearchHomePage extends Base {
	
	//This is a Page Factory class of Search Page
	//Below the different WebElemets are initialized to perform action

	@FindBy(xpath = "//input[@id='text']")
	WebElement searchbox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	
	@FindBy(xpath = "//i[@class='b-ico keyboard-loader__icon b-ico-kbd']")
	WebElement keyboard;

	//below a constructor is created and Super keyword is used, such that it will call the Parent class constructor
	public YandexSearchHomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}
//Below is the method to enter text into search input field and click on search
	public YandexSearchResultsPage enterTextInSearchbox() throws IOException {
		searchbox.click();
		searchbox.sendKeys(prop.getProperty("text"));
		searchButton.click();
		return new YandexSearchResultsPage();
	}

	

}
