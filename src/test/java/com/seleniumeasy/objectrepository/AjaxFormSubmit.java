package com.seleniumeasy.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjaxFormSubmit {
	private WebDriver driver;

	public AjaxFormSubmit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id= 'title']")
	private WebElement inputName;

	public WebElement getNameInput() {
		return inputName;
	}

	@FindBy(xpath = "//textarea[@id= 'description']")
	private WebElement textAreaComments;

	public WebElement getCommentsTextArea() {
		return textAreaComments;
	}

	@FindBy(xpath = "//input[@id = 'btn-submit']")
	private WebElement inputButtonSubmit;

	public WebElement getSubmitButton() {
		return inputButtonSubmit;
	}

	@FindBy(xpath = "//div[text()='Form submited Successfully!']")
	private WebElement messageFormSubmission;

	public WebElement getFormSubmissionMessage() {
		return messageFormSubmission;
	}

}
