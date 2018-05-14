package com.seleniumeasy.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
	private WebDriver driver;
	private FileReadManager fileReadManager;
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return (driver == null) ? driver = openBrowser() : driver;
	}

	public WebDriver openBrowser() {
		String url = FileReadManager.getInstance().getConfigFileReader().getApplicationURL();
		String browser = FileReadManager.getInstance().getConfigFileReader().getBrowser();
		Long implicitWait = FileReadManager.getInstance().getConfigFileReader().getImplicitWait();

		if (browser.equals("chrome")) {
			String path = FileReadManager.getInstance().getConfigFileReader().getChromeDriverPath();
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public WebDriverWait getExplicitWait(WebElement element, String waitType) {
		Long explicitWait = FileReadManager.getInstance().getConfigFileReader().getExplicitWait();
		wait = new WebDriverWait(getDriver(), explicitWait);
		if (waitType.equals("visibility")) {
			wait.until(ExpectedConditions.visibilityOf(element));
		} else if (waitType.equals("invisibility")) {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} else if (waitType.equals("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} else {
			throw new RuntimeException("Wait Type mentioned is not supported");
		}
		return wait;
	}
	
	public void closeBrowser() {
		getDriver().close();
	}
}
