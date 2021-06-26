package stepDefinition;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class Blankfile {
	@Given("givenstep\"([^\"]*)\"$")
	public void givenstep(String str) {
	    System.out.println("Executed Given "+str);
	}

	@When("whenstep")
	public void whenstep() {
		System.out.println("Executed When");
	}

	@Then("thenstep")
	public void thenstep() {
		System.out.println("Executed Then");
		
	}
	
	@After
	public void if_Failed(){
		System.out.println("Executed After");
			
			
		}
	
}
