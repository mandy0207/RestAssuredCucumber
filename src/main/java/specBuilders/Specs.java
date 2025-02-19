package specBuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specs {

	public static  RequestSpecification makeRequestSpec(String baseUri) {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseUri).setContentType(ContentType.JSON).build();
		return req;
	}
	
	public static ResponseSpecification makeResponseSpec(int statusCode) {
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON).build();
		return res;
	}
}
