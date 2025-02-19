package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.Constants;

public class TestProperties {

	
	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Constants.PROPERTIESFILEPATH);
		prop.load(fis);
		return prop;
	}
}
