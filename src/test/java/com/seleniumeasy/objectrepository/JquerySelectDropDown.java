package com.seleniumeasy.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JquerySelectDropDown {
	private WebDriver driver;

	public JquerySelectDropDown(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@class='select2-selection select2-selection--single'])[1]")
	private WebElement dropDownCountry;

	public WebElement getSelectCountryDropDown() {
		return dropDownCountry;
	}
	
	@FindBy(xpath = "(//input[@class='select2-search__field'])")
	private WebElement inputSearchCountry;

	public WebElement getSearchCountryInput() {
		return inputSearchCountry;
	}
	
	@FindAll(value = { @FindBy (xpath = "//ul[@id='select2-country-results']/li" ) })
	private List<WebElement> listCountry;
	public List<WebElement> getCountryList(){
		return listCountry;
	}
}
