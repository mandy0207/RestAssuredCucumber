package payloads;

public class PayLoad {

	  public static String getAddBookPayLoad(String isbn, String aisle) {
	        return "{\n" +
	                "  \"name\": \"Automation Learning With Obsqura\",\n" +
	                "  \"isbn\": \"" + isbn + "\",\n" +
	                "  \"aisle\": \"" + aisle + "\",\n" +
	                "  \"author\": \"Sugesh & Vinod\"\n" +
	                "}";
	    }
	  
	  public static String getAddBookPayLoad(String bookName,String isbn, String aisle, String author) {
	        return "{\n" +
	                "  \"name\": \""+bookName+"\",\n" +
	                "  \"isbn\": \"" + isbn + "\",\n" +
	                "  \"aisle\": \"" + aisle + "\",\n" +
	                "  \"author\": \""+author+"\"\n" +
	                "}";
	    }
	  
	  public static String getDeleteBookPayload(String ID) {
		  return "\r\n"
		  		+ " {\r\n"
		  		+ "\"ID\": \""+ID+"\"\r\n"
		  		+ "}";
		  
	  }
	  
	  public static String getDummyJsonOfBooks() {
		  return "[\r\n"
		  		+ "    {\r\n"
		  		+ "        \"book_name\": \"Automation Learning With Obsqura\",\r\n"
		  		+ "        \"isbn\": \"MT826\",\r\n"
		  		+ "        \"aisle\": \"330\",\r\n"
		  		+ "        \"author\": \"Vinod\"\r\n"
		  		+ "    },\r\n"
		  		+ "    {\r\n"
		  		+ "        \"book_name\": \"Introduction to Python Programming\",\r\n"
		  		+ "        \"isbn\": \"PY123\",\r\n"
		  		+ "        \"aisle\": \"101\",\r\n"
		  		+ "        \"author\": \"John Doe\"\r\n"
		  		+ "    },\r\n"
		  		+ "    {\r\n"
		  		+ "        \"book_name\": \"Mastering JavaScript\",\r\n"
		  		+ "        \"isbn\": \"JS456\",\r\n"
		  		+ "        \"aisle\": \"202\",\r\n"
		  		+ "        \"author\": \"Jane Smith\"\r\n"
		  		+ "    },\r\n"
		  		+ "    {\r\n"
		  		+ "        \"book_name\": \"Web Development Fundamentals\",\r\n"
		  		+ "        \"isbn\": \"WD789\",\r\n"
		  		+ "        \"aisle\": \"404\",\r\n"
		  		+ "        \"author\": \"Alice Johnson\"\r\n"
		  		+ "    }\r\n"
		  		+ "]\r\n"
		  		+ "";
	  }
	  
	  public static String getpracticeJson() {
		  return "{\r\n"
		  		+ "  \"data\": [\r\n"
		  		+ "    {\r\n"
		  		+ "      \"drink\": \"Espresso\",\r\n"
		  		+ "      \"price\": 250,\r\n"
		  		+ "      \"category\": \"Hot Beverage\"\r\n"
		  		+ "    },\r\n"
		  		+ "    {\r\n"
		  		+ "      \"drink\": \"Cold Brew Coffee\",\r\n"
		  		+ "      \"price\": 400,\r\n"
		  		+ "      \"category\": \"Cold Beverage\"\r\n"
		  		+ "    },\r\n"
		  		+ " \r\n"
		  		+ "    {\r\n"
		  		+ "      \"drink\": \"Fresh Orange Juice\",\r\n"
		  		+ "      \"price\": 350,\r\n"
		  		+ "      \"category\": \"Fruit Juice\"\r\n"
		  		+ "    }\r\n"
		  		+ "  ],\r\n"
		  		+ "  \"totalDrinks\": 4,\r\n"
		  		+ "  \"availableCategories\": 3,\r\n"
		  		+ "  \"offers\" :{\r\n"
		  		+ "   \"Espresso\" : \"No off\",\r\n"
		  		+ "    \"FruitJuice\" : \"Discount available\"\r\n"
		  		+ "\r\n"
		  		+ "}}\r\n"
		  		+ "";
	  }
	  
	  public static String  getGitHubPayload(String clienID, String clientSecret, String code) {
		  return "{\r\n"
		  		+ "  \"client_id\": \""+clienID+"\",\r\n"
		  		+ "  \"client_secret\": \""+clientSecret+"\",\r\n"
		  		+ "  \"code\": \""+code+"\",\r\n"
		  		+ "  \"redirect_uri\": \"http://localhost/callback\"\r\n"
		  		+ "}\r\n"
		  		+ "";
		  
	  }
	  
	 


}
