package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains reusable methods to perform operations on properties fie
 * @author admin
 *
 */
public class PropertiesUtility {
	/**
	 * this method is used for read data from properties
	 * @param filepath
	 * @param key
	 * @return
	 */
    private Properties property;
	public void propertiesInitialization(String filePath) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public String readfromproperties(String key) {
		// TODO Auto-generated method stub
		return property.getProperty(key);
	}

}


