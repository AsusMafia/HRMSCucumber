package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features"
	, glue="com/hrms/steps"				//where we specify the steps for the features
	, dryRun=true							//whether to run the code or only check for implementation
	, plugin= {"pretty", "html:target/html/cucumber-default-report", "json:target/cucumber.json", "rerun: target/failed.txt"}						//provides some details about the test being run (time and such)
	, monochrome=true						//readable form of details on the test being run
	, tags = {"@smoke1"}						//works the same as groups. You can specify each feature to belong
			)								//to a specific group; helps with group execution.s
public class SmokeRunner {					
	

}
