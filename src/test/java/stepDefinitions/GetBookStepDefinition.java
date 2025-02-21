package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import Utils.ParseJson;
import Utils.ScenarioContext;
import Utils.TestProperties;
import enums.ApiResources;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import specBuilders.Specs;

public class GetBookStepDefinition {

	RequestSpecification req;
	Response res;
	String baseUrl = "";
	
    private ScenarioContext scenarioContext;
    
	public GetBookStepDefinition(ScenarioContext scenarioContext) {
		this.scenarioContext=  scenarioContext;
	}

	@Then("user sends get request to grab book using ID")
	public void user_sends_get_request_to_grab_book_using_ID() throws IOException {
	     String bookID = scenarioContext.getBookId();
	     System.out.println("Book ID received : "+bookID);
	     baseUrl = ApiResources.libraryBaseUrl.getResource();

		req = given().spec(Specs.makeRequestSpec(baseUrl)).queryParam("ID", bookID);
		res = req.when().get(ApiResources.getBook.getResource()).then().log().all().extract().response();
		
		scenarioContext.setResponse(res);
		
	}

	@Then("verify user is able to retrive same data sent while creating book")
	public void verify_user_is_able_to_retrive_same_data_sent_while_creating_book() {

		JsonPath js = ParseJson.getJsonPathObject(res.asString());
		List<String> isbn = ParseJson.getJsonPathObject(res.asString()).getList("isbn");
		List<String> aisle = ParseJson.getJsonPathObject(res.asString()).getList("aisle");
		String aisleNumber = aisle.get(0);
		String isbnNumber = isbn.get(0);

		String actualID = isbnNumber + aisleNumber;

		Assert.assertEquals(actualID, scenarioContext.getBookId());
	}

}
