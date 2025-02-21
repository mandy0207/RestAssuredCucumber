package Utils;

import io.restassured.response.Response;

public class ScenarioContext {

	Response response;
	String bookId;
	String baseUrl; 
	
	
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getbaseUrl() {
		return baseUrl;
	}
	public void setbaseUrl(String baseUrl) {
		this.baseUrl= baseUrl;
	}

	
	
}
