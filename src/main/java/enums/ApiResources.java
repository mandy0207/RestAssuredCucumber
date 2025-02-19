package enums;

public enum ApiResources {

	postBook("/Library/Addbook.php"),
	getBook("/Library/GetBook.php");
	
	
	
	private final String resource;

	
	ApiResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
}
