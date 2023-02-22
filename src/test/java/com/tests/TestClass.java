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

import pom.objects.ImdbPage;
import pom.objects.WikipediaPage;
import resorce.Base;

public class TestClass extends Base {

	public WebDriver driver;

	@BeforeTest
	public void invokbrowser() throws IOException {
		driver = initializeDriver(); // 'intializedriver' mthd is called & stored in driver
		driver.manage().window().maximize();
	}

	@Test()
	public void compareData() {
		try {
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			ImdbPage l = new ImdbPage(driver);
			WebElement dateImdb = l.releaseDateImdb();
			WebElement countryImdb = l.countryOfOriginImdb();

			SoftAssert softasert = new SoftAssert();

			softasert.assertNotNull(dateImdb);
			softasert.assertNotNull(countryImdb);

			String dateImdbData = dateImdb.getText();
			String countryImdbData = countryImdb.getText();

			System.out.println("IMDB Data: " + dateImdbData + "," + countryImdbData);

			driver.get(prop.getProperty("url1"));

			WikipediaPage l1 = new WikipediaPage(driver);
			WebElement dateWikipdia = l1.releaseDateWikpdia();
			WebElement countryWikidia = l1.countryWikpdia();

			softasert.assertNotNull(dateWikipdia);
			softasert.assertNotNull(countryWikidia);

			String DateWikiData = dateWikipdia.getText();
			String countryWikiData = countryWikidia.getText();

			System.out.println("Wiki Data: " + DateWikiData + "," + countryWikiData);

			softasert.assertEquals(countryImdbData, countryWikiData);
			softasert.assertEquals(dateImdbData, DateWikiData);

			softasert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	void tearDown() {

		driver.close();
	}

}
