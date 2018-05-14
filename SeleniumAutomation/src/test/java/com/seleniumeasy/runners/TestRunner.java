package com.seleniumeasy.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature"
,glue = "com/seleniumeasy/stepdefinition"
,plugin = "pretty"
//,dryRun = true
)

public class TestRunner {
}
