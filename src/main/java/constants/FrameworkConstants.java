package constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}

	private static final String RESOURCE_PATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIG_FILE_PATH = RESOURCE_PATH+"/config/config.properties";
	private static final String TESTDATA_FILE_PATH=RESOURCE_PATH+"/testdata/TestData.xlsx";
	private static final String SHEET_NAME="LoginDetails";
	private static final int TIME_UNIT = 10;
	
	public static String getSheetName() {
		return SHEET_NAME;
	}

	public static String getTestdataFilePath() {
		return TESTDATA_FILE_PATH;
	}

	
	public static int getTimeUnit() {
		return TIME_UNIT;
	}

	public static String getFilePath() {
		return CONFIG_FILE_PATH;
	}
	
}
