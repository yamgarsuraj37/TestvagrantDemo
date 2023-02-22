package pom.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbPage {

	public WebDriver driver;

	public ImdbPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li[1]/div/ul/li")
	private WebElement releaseDate;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li[2]/div/ul/li")          //a[@xpath="1"]
	private WebElement countryOfOrigin;

	public WebElement releaseDateImdb() {
		return releaseDate;
	}

	public WebElement countryOfOriginImdb() {
		return countryOfOrigin;
	}

}
