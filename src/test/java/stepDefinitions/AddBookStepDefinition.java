package stepDefinitions;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.Assert;
import Utils.ParseJson;
import Utils.ScenarioContext;
import Utils.TestProperties;
import Utils.UniqueGenerators;
import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.PayLoad;
import specBuilders.Specs;

public class AddBookStepDefinition {

	RequestSpecification req;
	Response res;
	private ScenarioContext scenarioContext;
	

	public AddBookStepDefinition(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}
	
	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {

		req = given().spec(Specs.makeRequestSpec(scenarioContext.getbaseUrl())).body(PayLoad.getAddBookPayLoad(
				UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber())));
		res = req.when().post(ApiResources.postBook.getResource()).then().log().all().extract().response();
		
		scenarioContext.setResponse(res);
		
		JsonPath js = ParseJson.getJsonPathObject(res.asString());
		String bookID = js.getString("ID");
		scenarioContext.setBookId(bookID);
		System.out.println("Book ID stored : "+bookID);
	}
	

	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		req = given().spec(Specs.makeRequestSpec(scenarioContext.getbaseUrl()))
				.body(PayLoad.getAddBookPayLoad(bookName, isbn + UniqueGenerators.getUniqueString(), aisle, author));
		res = req.when().post(ApiResources.postBook.getResource()).then().log().all().extract().response();
		scenarioContext.setResponse(res);
	}

	

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedMsg) {
		JsonPath js = ParseJson.getJsonPathObject(res.asString());
		String actualMsg = js.getString("Msg");

		Assert.assertEquals(actualMsg, expectedMsg);
	}

}
