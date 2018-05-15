package com.seleniumeasy.stepdefinition;

import com.seleniumeasy.injector.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StepDefinitionGeneric {
	TestContext testContext;
	
	public StepDefinitionGeneric(TestContext test) {
		testContext = test;
	}
	
	@Before
	public void performPrerequisiteActions(Scenario scenario) {
		System.out.println("+++++++++++++++ Starting Scenario : "+scenario.getName()+"++++++++++++++++");
	}
	
	@After
	public void performPostScenarioExecutionActions() {
		//testContext.getWebDriverManager().closeBrowser();
		System.out.println("+++++++++++++++ Ending Scenario ++++++++++++++++++++");
	}

}
