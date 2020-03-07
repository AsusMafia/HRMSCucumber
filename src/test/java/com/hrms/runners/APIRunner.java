package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/resources/features", 
				glue="com.hrms.API.steps.practice",
				dryRun= false,
				tags = "@SyntaxHRMSAPIEndToEnd22"
				)
public class APIRunner {

}
