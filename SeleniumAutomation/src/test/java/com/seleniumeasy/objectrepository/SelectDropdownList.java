package com.seleniumeasy.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectDropdownList {
	private WebDriver driver;

	public SelectDropdownList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selectSelectADay;

	public WebElement getSelectADaySelectDropDownList() {
		return selectSelectADay;
	}

	/**
	 * WebElements for Multi Select Demo
	 */

	@FindBy(xpath = "//select[@id = 'multi-select']")
	private WebElement multiSelectOptions;

	public WebElement getMultiSelectStateSelectDropDownList() {
		return multiSelectOptions;
	}

	@FindBy(xpath = "//button[@id = 'printMe']")
	private WebElement buttonFirstSelected;

	public WebElement getFirstSelectedButton() {
		return multiSelectOptions;
	}

	@FindBy(xpath = "//button[@id = 'printAll']")
	private WebElement buttonGetAllSelected;

	public WebElement getGetAllSelectedButton() {
		return buttonGetAllSelected;
	}
}
