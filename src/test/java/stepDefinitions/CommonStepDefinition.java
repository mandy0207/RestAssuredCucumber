package stepDefinitions;

import org.testng.Assert;

import Utils.ScenarioContext;
import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefinition {

	private ScenarioContext scenarioContext;
	
	public CommonStepDefinition(ScenarioContext scenarioContext) {
		this.scenarioContext=scenarioContext;
	}
	
	
	@Given("library baseURL is available")
	public void library_baseURL_is_available() {
		String baseUrl = ApiResources.libraryBaseUrl.getResource();
		scenarioContext.setbaseUrl(baseUrl);
	}
	
	
	@Then("the status code should be {string}")
	public void the_status_code_should_be(String statusCodeVal) {
		int statusCode = scenarioContext.getResponse().getStatusCode();
		Assert.assertEquals(statusCode, Integer.parseInt(statusCodeVal));
	}
	
}
