package testRunners;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature/testing.feature",glue=("stepDefinition"),plugin = { "pretty", "html:target/cucumber-reports" },monochrome = true)
public class runner {

}
