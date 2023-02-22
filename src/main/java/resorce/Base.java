package resorce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;

	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\tools\\Java\\TestvagrantDemo\\src\\main\\java\\resorce\\data.properties");
		prop.load(fis);

		System.out.println(prop.getProperty("browser")); // chrome

		String browserName = prop.getProperty("browser"); // lauched browser here

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\CD_Final\\chromedriver_win32\\chromedriver.exe");

			try {

				driver = new ChromeDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (browserName == "firefox") {

			// firefox code

		} else if (browserName == "IE") {

			// IE code

		}
		return driver;

	}

}
