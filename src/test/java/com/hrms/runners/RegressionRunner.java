package com.hrms.runners;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features"
	, glue="com/hrms/steps"				//where we specify the steps for the features
	, dryRun=false							//whether to run the code or only check for implementation
	, plugin= {"pretty", "html:target/html/cucumber-default-report"}						//provides some details about the test being run (time and such)
	, monochrome=true						//readable form of details on the test being run
	, tags = {"@regression"})
public class RegressionRunner {

}
