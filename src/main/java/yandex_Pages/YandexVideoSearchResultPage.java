package yandex_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import yandex_Base.Base;

public class YandexVideoSearchResultPage extends Base {
//Page Factory for Video search results
	

	public YandexVideoSearchResultPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@id='tab-video']")
	WebElement videoLink;

	public void clickOnVideo() throws IOException {
		
		videoLink.click();
		Boolean msg = driver.findElement(By.xpath("//span[@class='misspell__message']")).isDisplayed();
		Assert.assertFalse(msg);
		
		
	}
	
	
}
