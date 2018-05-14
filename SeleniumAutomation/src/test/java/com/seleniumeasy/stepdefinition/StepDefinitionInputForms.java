package com.seleniumeasy.stepdefinition;

import org.junit.Assert;

import com.seleniumeasy.injector.TestContext;
import com.seleniumeasy.objectrepository.CheckBoxDemo;
import com.seleniumeasy.objectrepository.HomePageInputForms;
import com.seleniumeasy.objectrepository.RadioButtonDemo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionInputForms {
	TestContext testContext;
	private HomePageInputForms homePageInputForms;
	private CheckBoxDemo checkBoxDemo;
	private RadioButtonDemo radioButtonDemo;

	public StepDefinitionInputForms(TestContext test) {
		testContext = test;
		homePageInputForms = testContext.getPageObjectManager().getHomePageInputForms();
		checkBoxDemo = testContext.getPageObjectManager().getCheckBoxDemo();
		radioButtonDemo = testContext.getPageObjectManager().getRadioButtonDemo();
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
		} else if(inputForm.equals("Radio Button")) {
			Assert.assertEquals("Radio button 'Male' is checked", radioButtonDemo.getCheckValueMessage().getText());
		}
	}

}
