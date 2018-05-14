package com.seleniumeasy.managers;

import com.seleniumeasy.objectrepository.CheckBoxDemo;
import com.seleniumeasy.objectrepository.HomePageInputForms;
import com.seleniumeasy.objectrepository.RadioButtonDemo;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private HomePageInputForms homePageInputForms;
    private CheckBoxDemo checkBoxDemo;
    private RadioButtonDemo radioButtonDemo;
    private WebDriver driver ;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePageInputForms getHomePageInputForms(){
        return (homePageInputForms == null) ? homePageInputForms = new HomePageInputForms(driver) : homePageInputForms;
    }
    
    public CheckBoxDemo getCheckBoxDemo() {
    	return (checkBoxDemo == null) ? checkBoxDemo = new CheckBoxDemo(driver) : checkBoxDemo;
    }
    public RadioButtonDemo getRadioButtonDemo() {
    	return (radioButtonDemo == null) ? radioButtonDemo = new RadioButtonDemo(driver) : radioButtonDemo;
    }
}
