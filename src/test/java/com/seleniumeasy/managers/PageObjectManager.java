package com.seleniumeasy.managers;

import com.seleniumeasy.objectrepository.AjaxFormSubmit;
import com.seleniumeasy.objectrepository.CheckBoxDemo;
import com.seleniumeasy.objectrepository.HomePageInputForms;
import com.seleniumeasy.objectrepository.JquerySelectDropDown;
import com.seleniumeasy.objectrepository.RadioButtonDemo;
import com.seleniumeasy.objectrepository.SelectDropdownList;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private HomePageInputForms homePageInputForms;
	private CheckBoxDemo checkBoxDemo;
	private RadioButtonDemo radioButtonDemo;
	private SelectDropdownList selectDropdownList;
	private AjaxFormSubmit ajaxFormSubmit;
	private JquerySelectDropDown jquerySelectDropDown;
	private WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageInputForms getHomePageInputForms() {
		return (homePageInputForms == null) ? homePageInputForms = new HomePageInputForms(driver) : homePageInputForms;
	}

	public CheckBoxDemo getCheckBoxDemo() {
		return (checkBoxDemo == null) ? checkBoxDemo = new CheckBoxDemo(driver) : checkBoxDemo;
	}

	public RadioButtonDemo getRadioButtonDemo() {
		return (radioButtonDemo == null) ? radioButtonDemo = new RadioButtonDemo(driver) : radioButtonDemo;
	}

	public SelectDropdownList getSelectDropdownList() {
		return (selectDropdownList == null) ? selectDropdownList = new SelectDropdownList(driver) : selectDropdownList;
	}

	public AjaxFormSubmit getAjaxFormSubmit() {
		return (ajaxFormSubmit == null) ? ajaxFormSubmit = new AjaxFormSubmit(driver) : ajaxFormSubmit;
	}

	public JquerySelectDropDown getJquerySelectDropDown() {
		return (jquerySelectDropDown == null) ? jquerySelectDropDown = new JquerySelectDropDown(driver) : jquerySelectDropDown;
	}
}
