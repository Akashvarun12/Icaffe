package webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataSuplier {

	// Read All Data from Excel.... 
	
	@DataProvider(name = "ReadDataFromExcel")
	public static Object[][] readAllData(Method method) throws IOException {

	    Test test = method.getAnnotation(Test.class);

	    if (test == null || test.description().isEmpty()) {
	        throw new RuntimeException("Please provide sheet name in @Test(description=...) for method: " + method.getName());
	    }

	    String sheetName = test.description();

	    File excelFile = new File("src/test/resources/TestByDataprovider.xlsx");
	    FileInputStream fis = new FileInputStream(excelFile);

	    XSSFWorkbook workBook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workBook.getSheet(sheetName);

	    if (sheet == null) {
	        throw new RuntimeException("Sheet not found: " + sheetName);
	    }

	    int noOfRows = sheet.getPhysicalNumberOfRows();
	    int noOfColumn = sheet.getRow(0).getLastCellNum();

	    Object[][] arrData = new Object[noOfRows - 1][noOfColumn];

	    DataFormatter df = new DataFormatter();

	    for (int i = 0; i < noOfRows - 1; i++) {
	        Row row = sheet.getRow(i + 1);

	        for (int j = 0; j < noOfColumn; j++) {
	            Cell cell = (row != null) ? row.getCell(j) : null;
	            arrData[i][j] = df.formatCellValue(cell);
	        }
	    }

	    workBook.close();
	    fis.close();

	    return arrData;
	}
	
	
// Read data Dynamically in Excel with Row wise...using ID
	
	public static Map<String, String> setExcelFile(String sheetName, String expDataId) {
	    Map<String, String> dataMap = new HashMap<>();

	    try (FileInputStream fls = new FileInputStream("src/test/resources/TestByDataprovider.xlsx");
	         Workbook workBook = new XSSFWorkbook(fls)) {

	        Sheet sheet = workBook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new RuntimeException("Sheet not found: " + sheetName);
	        }

	        int lastRowNumber = sheet.getLastRowNum();
	        int dataRowNumber = -1;

	        for (int i = 0; i <= lastRowNumber; i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            Cell cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            String actDataIdValue = cell.getStringCellValue();

	            if (actDataIdValue.equalsIgnoreCase(expDataId)) {
	                dataRowNumber = i;
	                break;
	            }
	        }

	        if (dataRowNumber == -1) {
	            throw new RuntimeException("Data ID not found: " + expDataId);
	        }

	        Row dataRow = sheet.getRow(dataRowNumber);
	        Row headerRow = sheet.getRow(0);

	        for (int j = 1; j < headerRow.getLastCellNum(); j++) {
	            String key = headerRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
	            String value = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

	            dataMap.put(key, value);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return dataMap;
	}
	
	//  Read data Dynamically in Excel with using List or Map Logic
	
	public static List<Map<String,String>> setExcelFile(String sheetName) {
		FileInputStream fls;
		List<Map<String,String>> listMap =	new ArrayList<Map<String,String>>();
		try {
			File excelFile = new File("/iCaffe/src/test/resources/TestByDataprovider.xlsx");

			System.out.println(excelFile.exists());
			 fls = new FileInputStream(excelFile);
			Workbook workBook = new XSSFWorkbook(fls);
			Sheet sheet = workBook.getSheet(sheetName);
			int lastRowNumber = sheet.getLastRowNum();

			
			for(int j=1;j<=sheet.getLastRowNum();j++) {
				Map<String, String> dataMap = new HashMap<String,String>();
	
			Row dataRow = sheet.getRow(j);
			Row firstRow = sheet.getRow(0);

			for (int i = 1; i <= firstRow.getLastCellNum() - 1; i++) {
				Cell cellKey = firstRow.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Cell cellData = dataRow.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);

				String coulmnName = cellKey.getStringCellValue();
				String dataValue = cellData.getStringCellValue();
				System.out.println(coulmnName + " :- " + dataValue);
				dataMap.put(coulmnName, dataValue);
			}
			listMap.add(dataMap);
			}
		} catch (IOException e) {

		}

		return listMap;
	}
	
//	@DataProvider(name = "WriteDataToExcel")
//	public static void writeData() throws IOException {
//		
//		XSSFWorkbook workBook = new XSSFWorkbook();
//		XSSFSheet sheet = workBook.createSheet("TestSheet");
//		int noOfRows = sheet.getPhysicalNumberOfRows();
//		int noOfCoulmn = sheet.getRow(0).getLastCellNum();
//			String[][] arrData = new String[noOfRows - 1][noOfCoulmn];
//			for (int i = 0; i < noOfRows - 1; i++) {
//				for (int j = 0; j < noOfCoulmn; j++) {
//					DataFormatter df = new DataFormatter();
//					df.createFormat(sheet.createRow(i).createCell(j));
//					
//					
////					sheet.createRow(0);
////					sheet.getRow(0).createCell(0).setCellValue("Hello");
////					sheet.getRow(0).createCell(1).setCellValue("Java");
//				}
//			}
//
//	}

	
	

//	@DataProvider(name = "ReadDataFromExcel")
//	public static String[][] readAllData(String sheetName) throws IOException {
//		File excelFile = new File("./src/test/resources/TestByDataprovider.xlsx");
//		System.out.println(excelFile.exists());
//		FileInputStream fInputStreamObj = new FileInputStream(excelFile);
//
//		XSSFWorkbook workBook = new XSSFWorkbook(fInputStreamObj);
//		XSSFSheet sheet = workBook.getSheet(sheetName);
//		int noOfRows = sheet.getPhysicalNumberOfRows();
//		int noOfCoulmn = sheet.getRow(0).getLastCellNum();
//
//		String[][] arrData = new String[noOfRows - 1][noOfCoulmn];
//		for (int i = 0; i < noOfRows - 1; i++) {
//			for (int j = 0; j < noOfCoulmn; j++) {
//				DataFormatter df = new DataFormatter();
//				arrData[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
//			}
//		}
//		workBook.close();
//		fInputStreamObj.close();
//		for (String[] strArrData : arrData) {
//			System.out.println(Arrays.toString(strArrData));
//		}
//		return arrData;
//
//	}

//	public static Map<String, String> setExcelFile(String sheetName, String expDataId) {
//		   sheetName = "";
//
//		
//		FileInputStream fls;
//		Map<String, String> dataMap = new HashMap<String,String>();
//		try {
//			File excelFile = new File("src/test/resources/TestByDataprovider.xlsx");
//
//			System.out.println(excelFile.exists());
//			 fls = new FileInputStream(excelFile);
//			Workbook workBook = new XSSFWorkbook(fls);
//			Sheet sheet = workBook.getSheet(sheetName);
//			int lastRowNumber = sheet.getLastRowNum();
//
//			int dataRowNumber = 0;
//
//			for (int i = 0; i <= lastRowNumber; i++) {
//				Row row = sheet.getRow(i);
//				Cell cell = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				String actDataIdValue = cell.getStringCellValue();
//				if (actDataIdValue.equalsIgnoreCase(expDataId)) {
//					dataRowNumber = i;
//				}
//			}
//			Row dataRow = sheet.getRow(dataRowNumber);
//			Row firstRow = sheet.getRow(0);
//
//			for (int j = 1; j <= firstRow.getLastCellNum() - 1; j++) {
//				Cell cellKey = firstRow.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				Cell cellData = dataRow.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//				String coulmnName = cellKey.getStringCellValue();
//				String dataValue = cellData.getStringCellValue();
//				System.out.println(coulmnName + " :- " + dataValue);
//				dataMap.put(coulmnName, dataValue);
//
//			}
//		} catch (IOException e) {
//
//		}
//
//		return dataMap;
//	}
}

