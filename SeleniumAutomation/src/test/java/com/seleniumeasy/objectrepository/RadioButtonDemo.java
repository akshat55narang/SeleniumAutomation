package com.seleniumeasy.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonDemo {
	private WebDriver driver;

	public RadioButtonDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='panel-body'])[2]/label/input[@value = 'Male']")
	private WebElement radioButtonMale;

	public WebElement getMaleOptionRadioButton() {
		return radioButtonMale;
	}

	@FindBy(xpath = "//button[text()='Get Checked value']")
	private WebElement buttonGetCheckedValue;

	public WebElement getCheckValueButton() {
		return buttonGetCheckedValue;
	}
	@FindBy(xpath = "//p[@class='radiobutton']")
	private WebElement messageCheckValue;

	public WebElement getCheckValueMessage() {
		return messageCheckValue;
	}
}
