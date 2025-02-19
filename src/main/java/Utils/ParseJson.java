package Utils;

import io.restassured.path.json.JsonPath;

public class ParseJson {

	public static JsonPath getJsonPathObject(String jsonBody) {
		return  new JsonPath(jsonBody);
	}
}
