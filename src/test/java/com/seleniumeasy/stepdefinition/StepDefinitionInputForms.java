package com.seleniumeasy.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.seleniumeasy.injector.TestContext;
import com.seleniumeasy.objectrepository.AjaxFormSubmit;
import com.seleniumeasy.objectrepository.CheckBoxDemo;
import com.seleniumeasy.objectrepository.HomePageInputForms;
import com.seleniumeasy.objectrepository.JquerySelectDropDown;
import com.seleniumeasy.objectrepository.RadioButtonDemo;
import com.seleniumeasy.objectrepository.SelectDropdownList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.internal.connection.RouteSelector.Selection;

public class StepDefinitionInputForms {
	TestContext testContext;
	private HomePageInputForms homePageInputForms;
	private CheckBoxDemo checkBoxDemo;
	private RadioButtonDemo radioButtonDemo;
	private SelectDropdownList selectDropdownList;
	private AjaxFormSubmit ajaxFormSubmit;
	private JquerySelectDropDown jquerySelectDropDown;

	public StepDefinitionInputForms(TestContext test) {
		testContext = test;
		homePageInputForms = testContext.getPageObjectManager().getHomePageInputForms();
		checkBoxDemo = testContext.getPageObjectManager().getCheckBoxDemo();
		radioButtonDemo = testContext.getPageObjectManager().getRadioButtonDemo();
		selectDropdownList = testContext.getPageObjectManager().getSelectDropdownList();
		ajaxFormSubmit = testContext.getPageObjectManager().getAjaxFormSubmit();
		jquerySelectDropDown = testContext.getPageObjectManager().getJquerySelectDropDown();
	}

	@Given("^User opens application in browser$")
	public void user_opens_application_in_browser() throws Throwable {
	}

	@When("^User clicks on Input Forms$")
	public void user_clicks_on_Input_Forms() throws Throwable {
		homePageInputForms.getInputFormsLink().click();
	}

	@When("^Selects \"([^\"]*)\"$")
	public void selects(String inputForm) throws Throwable {
		if (inputForm.equals("Single Input") || inputForm.equals("Two Input")) {
			homePageInputForms.getSimpleFormsLink().click();
		} else if (inputForm.equals("Single Check Box") || inputForm.equals("Multiple Check Box")) {
			homePageInputForms.getCheckBoxDemoLink().click();
		} else if (inputForm.equals("Radio Button") || inputForm.equals("Group Radio Button")) {
			homePageInputForms.getRadioButtonemoLink().click();
		} else if (inputForm.equals("Select Dropdown List") || inputForm.equals("Multi Select Dropdown List")) {
			homePageInputForms.getSelectDropdownListLink().click();
		} else if(inputForm.equals("Ajax Form Submit")) {
			homePageInputForms.getAjaxFormSubmitButton().click();
		} else if(inputForm.equals("JQuery Select dropdown")) {
			homePageInputForms.getJQuerySelectDropdown().click();
		}

	}

	@When("^Verifies \"([^\"]*)\"$")
	public void verifies(String inputForm) throws Throwable {
		if (inputForm.equals("Single Input")) {
			homePageInputForms.getUserMessageInput().sendKeys("Tester");
			homePageInputForms.getShowMessageButton().click();
		} else if (inputForm.equals("Two Input")) {
			homePageInputForms.getUserInputField1().sendKeys("5");
			homePageInputForms.getUserInputField2().sendKeys("6");
			homePageInputForms.getTotalCalculationButton().click();
		} else if (inputForm.equals("Single Check Box")) {
			if (!checkBoxDemo.getAgeSelectionCheckBox().isSelected()) {
				checkBoxDemo.getAgeSelectionCheckBox().click();
			}
		} else if (inputForm.equals("Multiple Check Box")) {
			Assert.assertEquals("Check All", checkBoxDemo.getCheckAllButton().getAttribute("value"));
			checkBoxDemo.getCheckAllButton().click();
			Assert.assertEquals("Uncheck All", checkBoxDemo.getCheckAllButton().getAttribute("value"));
			int size = checkBoxDemo.getMultipleCheckBoxList().size();
		} else if (inputForm.equals("Radio Button")) {
			radioButtonDemo.getMaleOptionRadioButton().click();
			radioButtonDemo.getCheckValueButton().click();
		} else if (inputForm.equals("Group Radio Button")) {
			radioButtonDemo.getGroupMaleOptionRadioButton().click();
			radioButtonDemo.getZeroToFiveAgeOptionRadioButton().click();
			radioButtonDemo.getGroupCheckValuesButton().click();
		} else if (inputForm.equals("Select Dropdown List")) {
			Select selection = new Select(selectDropdownList.getSelectADaySelectDropDownList());
			selection.selectByValue("Monday");
		} else if (inputForm.equals("Multi Select Dropdown List")) {
			Select selection = new Select(selectDropdownList.getMultiSelectStateSelectDropDownList());
			selection.selectByValue("California");
			selection.selectByValue("New Jersey");
			selection.selectByValue("Washington");
		} else if(inputForm.equals("Ajax Form Submit")) {
			ajaxFormSubmit.getNameInput().sendKeys("Akshat");
			ajaxFormSubmit.getCommentsTextArea().sendKeys("Testers Rock");
			ajaxFormSubmit.getSubmitButton().click();
			testContext.getWebDriverManager().getExplicitWait(ajaxFormSubmit.getFormSubmissionMessage(), "visibility");
		} else if(inputForm.equals("JQuery Select dropdown")) {
			jquerySelectDropDown.getSelectCountryDropDown().click();
			int sizeBefore = jquerySelectDropDown.getCountryList().size();
			System.out.println("Original Size = "+ sizeBefore );
			jquerySelectDropDown.getSearchCountryInput().sendKeys("In");
			Thread.sleep(5000);
			int sizeAfter = jquerySelectDropDown.getCountryList().size();
			System.out.println("Sorted Size = "+ sizeAfter );
		}

	}

	@Then("^User should be able to execute all the test cases for the specified \"([^\"]*)\"\\.$")
	public void user_should_be_able_to_execute_all_the_test_cases_for_the_specified(String inputForm) throws Throwable {
		if (inputForm.equals("Single Input")) {
			Assert.assertEquals("Tester", homePageInputForms.getUserInputMessage().getText());
		} else if (inputForm.equals("Two Input")) {
			Assert.assertEquals("11", homePageInputForms.getTotalCalculationMessage().getText());
		} else if (inputForm.equals("Single Check Box")) {
			Assert.assertEquals("Success - Check box is checked", checkBoxDemo.getAgeSelectionMessage().getText());
		} else if (inputForm.equals("Radio Button")) {
			Assert.assertEquals("Radio button 'Male' is checked", radioButtonDemo.getCheckValueMessage().getText());
		} else if (inputForm.equals("Group Radio Button")) {
			Assert.assertEquals("Sex : Male\n" + "Age group: 0 - 5",
					radioButtonDemo.getGroupCheckValuesMessage().getText());
		} else if (inputForm.equals("Select Dropdown List")) {
			Assert.assertEquals("Monday", selectDropdownList.getSelectADaySelectDropDownList().getAttribute("value"));
		} else if (inputForm.equals("Multi Select Dropdown List")) {
			Select S = new Select(selectDropdownList.getMultiSelectStateSelectDropDownList());
			Assert.assertEquals(Integer.parseInt("3"), S.getAllSelectedOptions().size());
		} else if (inputForm.equals("Ajax Form Submit")) {
			Assert.assertEquals("Form submited Successfully!", ajaxFormSubmit.getFormSubmissionMessage().getText());
		}
	}

}
