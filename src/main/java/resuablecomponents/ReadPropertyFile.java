package resuablecomponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import constants.FrameworkConstants;




//keep final as we do not want to extend this class
public final class ReadPropertyFile {
	private static Properties prop = new Properties();
	static FileInputStream fis;
	

	//keep private constructor if we do not want object to be created of this class.
	private ReadPropertyFile() {

	}

	//1. load data from properties file
	// use of static block to load all the data into the memory even before the main method called.
	// this will prevent loading reading of file input stream and loading data every time.
	static{
		try {
			fis = new FileInputStream(FrameworkConstants.getFilePath());
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}

	}

	public static String getPropertyKeyValue(String key)  {

		//2. read data
		//to perform null checks on key and value. 
		//if null key is passed as an argument, then Objects.isNull(key)will check for it
		//if value is null in config file, then Objects.isNull(prop.getProperty(key)will check for it
		if(Objects.isNull(prop.getProperty(key).trim())||Objects.isNull(key)){
			try{
				throw new Exception("Property Name "+key+" is not found. Please check Config Properties file");
			}catch(Exception ex){
				ex.getStackTrace();
			}	
		}

		return prop.getProperty(key);

	}


}
