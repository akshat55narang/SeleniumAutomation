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

	/**
	 * WebElement for the Group Radio Button Demo
	 */
	@FindBy(xpath = "(//div[@class='panel-body'])[3]/div/label/input[@value='Male']")
	private WebElement groupRadioButtonMale;

	public WebElement getGroupMaleOptionRadioButton() {
		return groupRadioButtonMale;
	}

	@FindBy(xpath = "//input[@value='0 - 5']")
	private WebElement groupRadioButtonAge;

	public WebElement getZeroToFiveAgeOptionRadioButton() {
		return groupRadioButtonAge;
	}

	@FindBy(xpath = "//button[text()='Get values']")
	private WebElement buttonGetValues;

	public WebElement getCheckValuesButton() {
		return buttonGetValues;
	}

	@FindBy(xpath = "//p[@class='groupradiobutton']")
	private WebElement messageCheckGroupValues;

	public WebElement getGroupCheckValuesMessage() {
		return messageCheckGroupValues;
	}
}
