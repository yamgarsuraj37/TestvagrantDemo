package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipediapage {
	public WebDriver driver;

	public Wikipediapage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")
	private WebElement releasedate2;

	@FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td")
	private WebElement country2;

	public WebElement Releasedate() {
		return releasedate2;
	}

	public WebElement country() {
		return country2;
	}

}
