package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import Utils.ParseJson;
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

public class StepDefinition {

	RequestSpecification req;
	Response res;
	String baseUrl = "";

	@Given("library api is available")
	public void library_api_is_available() throws IOException {
		baseUrl = TestProperties.getProperties().getProperty("baseUrl");
	}

	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {

		req = given().spec(Specs.makeRequestSpec(baseUrl)).body(PayLoad.getAddBookPayLoad(
				UniqueGenerators.getUniqueString(), Integer.toString(UniqueGenerators.getRandomNumber())));
		res = req.when().post(ApiResources.postBook.getResource()).then().log().all().extract().response();

	}

	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		req = given().spec(Specs.makeRequestSpec(baseUrl)).body(PayLoad.getAddBookPayLoad(bookName, isbn+UniqueGenerators.getUniqueString(), aisle, author));
		res = req.when().post(ApiResources.postBook.getResource()).then().log().all().extract().response();
	}

	@Then("the status code  should be {string}")
	public void the_status_code_should_be(String statusCodeVal) {
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, Integer.parseInt(statusCodeVal));
	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedMsg) {
		JsonPath js = ParseJson.getJsonPathObject(res.asString());
		String actualMsg = js.getString("Msg");
		Assert.assertEquals(actualMsg, expectedMsg);
	}

}
