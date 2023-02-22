package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Imdbpage {

	public WebDriver driver;

	public Imdbpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li[1]/div/ul/li/a")
	private WebElement releasedate;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li[2]/div/ul/li/a")
	private WebElement countryoforigin;

	public WebElement releasedate() {
		return releasedate;
	}

	public WebElement countryoforigin() {
		return countryoforigin;
	}

}
