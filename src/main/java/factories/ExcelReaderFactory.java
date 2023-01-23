package factories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import constants.FrameworkConstants;

public final class ExcelReaderFactory {

	protected ExcelReaderFactory(){

	}

	public static Object[][] getExcelData(String filePath, String sheetName) throws RuntimeException, InvalidFormatException, IOException{
		FileInputStream file = null;
		DataFormatter formatter = new DataFormatter();
		// 2D array not initialized
		Object dataSets[][] = null;
		file = new FileInputStream(filePath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		// get the active row counts in the excel sheet
		int getRow = sheet.getLastRowNum();
		// get the active columns in row
		int getColumn = sheet.getRow(0).getLastCellNum();
		dataSets = new Object[getRow][getColumn];
		for (int i = 0; i < getRow; i++) {
			for (int k = 0; k < getColumn; k++) {
				dataSets[i][k] = formatter.formatCellValue(sheet.getRow(i+1).getCell(k));											
			}
		}		
		return dataSets;						
	}

	@DataProvider(name="LoginTestDataProvider")
	public static Object[][] testData() throws Exception, RuntimeException, IOException{
		Object[][] data = getExcelData(FrameworkConstants.getTestdataFilePath(), FrameworkConstants.getSheetName());
		return data;
	}
}
