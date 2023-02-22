package com.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomObjects.Imdbpage;
import pomObjects.Wikipediapage;
import resorce.Base;

public class Testcls extends Base {

	public WebDriver driver;

	@BeforeTest
	public void invokbrowser() throws IOException {

		driver = initializeDriver(); // 'intializedriver' mthd is called & stored in driver

		driver.manage().window().maximize();
		// log.info("window is maximized");
	}
	// inheritance
	// by creating object

	@Test()
	public void compareData() {

		try {
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			Imdbpage l = new Imdbpage(driver);
			WebElement releaseDateImdb = l.releasedate();
			WebElement countryImdb = l.countryoforigin();

			SoftAssert softasert = new SoftAssert();

			softasert.assertNotNull(releaseDateImdb);
			softasert.assertNotNull(countryImdb);
			
			String releaseDateImdbData = releaseDateImdb.getText();
			String countryImdbData = countryImdb.getText();

			System.out.println("IMDB Data: " + releaseDateImdbData + "," + countryImdbData);

			driver.get(prop.getProperty("url1"));

			Wikipediapage l1 = new Wikipediapage(driver);
			WebElement releaseDateWiki = l1.Releasedate();
			WebElement countryWiki = l1.country();

			softasert.assertNotNull(releaseDateWiki);
			softasert.assertNotNull(countryWiki);
			
			String releaseDateWikiData = releaseDateWiki.getText();
			String countryWikiData = countryWiki.getText();

			System.out.println("Wiki Data: " + releaseDateWikiData + "," + countryWikiData);

			softasert.assertEquals(countryImdbData, countryWikiData);
			softasert.assertEquals(releaseDateImdbData, releaseDateWikiData);

			softasert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public void wikiptest() {
//		driver.get(prop.getProperty("url1"));
//
//		Wikipediapage l1 = new Wikipediapage(driver);
//		WebElement releasedatewiki = l1.Releasedate();
//		WebElement countrywiki = l1.country();
//
//	}

	@AfterMethod
	@AfterTest
	void tearDown() {

		driver.close();
	}

}
