package com.seleniumeasy.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxDemo {
	private WebDriver driver;

	public CheckBoxDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "isAgeSelected")
	private WebElement checkBoxAgeSelection;

	public WebElement getAgeSelectionCheckBox() {
		return checkBoxAgeSelection;
	}
	
	@FindBy(id = "txtAge")
	private WebElement messageAgeSelection;

	public WebElement getAgeSelectionMessage() {
		return messageAgeSelection;
	}
	
	@FindBy(xpath = "//*[@id='check1']")
	private WebElement buttonCheckAll;

	public WebElement getCheckAllButton() {
		return buttonCheckAll;
	}
	//
	@FindBys(value = { @FindBy(xpath = "(//div[@class='panel panel-default'])[3]/div[@class='panel-body']/div[@class='checkbox']") })
	private List<WebElement> listMultipleCheckBoxes;

	public List<WebElement> getMultipleCheckBoxList() {
		return listMultipleCheckBoxes;
	}
}
