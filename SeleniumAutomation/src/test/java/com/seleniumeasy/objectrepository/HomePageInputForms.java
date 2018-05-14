package com.seleniumeasy.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageInputForms {
    private WebDriver driver;

    public HomePageInputForms(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Input Forms")
    private WebElement linkInputForms;

    public WebElement getInputFormsLink(){
        return linkInputForms;
    }
    
    @FindBy(linkText = "Simple Form Demo")
    private WebElement linkSimpleForm;

    public WebElement getSimpleFormsLink(){
        return linkSimpleForm;
    }
    
    @FindBy(linkText = "Checkbox Demo")
    private WebElement linkCheckBoxDemo;

    public WebElement getCheckBoxDemoLink(){
        return linkCheckBoxDemo;
    }
    
    @FindBy(linkText = "Radio Buttons Demo")
    private WebElement linkRadioButtonDemo;

    public WebElement getRadioButtonemoLink(){
        return linkRadioButtonDemo;
    }    
    
    @FindBy(id = "user-message")
    private WebElement inputUserMessage;

    public WebElement getUserMessageInput(){
        return inputUserMessage;
    }

    @FindBy(xpath = "//button[text()='Show Message']")
    private WebElement buttonShowMessage;

    public WebElement getShowMessageButton(){
        return buttonShowMessage;
    }
    
    @FindBy(id = "display")
    private WebElement messageUserInput;

    public WebElement getUserInputMessage(){
        return messageUserInput;
    }
    
    @FindBy(id = "sum1")
    private WebElement inputField1;

    public WebElement getUserInputField1(){
        return inputField1;
    }
    
    @FindBy(id = "sum2")
    private WebElement inputField2;

    public WebElement getUserInputField2(){
        return inputField2;
    }
    
    @FindBy(xpath = "//button[text()='Get Total']")
    private WebElement buttonGetTotal;

    public WebElement getTotalCalculationButton(){
        return buttonGetTotal;
    }
    
    @FindBy(id = "displayvalue")
    private WebElement messageTotal;

    public WebElement getTotalCalculationMessage(){
        return messageTotal;
    }


}
