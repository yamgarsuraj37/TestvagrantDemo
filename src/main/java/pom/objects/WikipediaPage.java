package pom.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {
	public WebDriver driver;

	public WikipediaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")
	private WebElement releaseDate2;

	@FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td")
	private WebElement countryOfOrigin2;

	public WebElement releaseDateWikpdia() {
		return releaseDate2;
	}

	public WebElement countryWikpdia() {
		return countryOfOrigin2;
	}

}
