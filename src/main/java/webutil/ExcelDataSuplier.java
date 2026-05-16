package webutil;

import java.io.FileInputStream;
import java.io.IOException;

import java.lang.reflect.Method;

import java.util.HashMap;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataSuplier {

	/*******************************************************************************
	 * 1st Logic: Read data from Excel using TestNG XML & @Test
	 * description. Supports dynamic run configuration and fallback to default
	 * properties.
	 * 
	 * Excel DataProvider Priority: 1. @Test description (excelFile, sheet) 2.
	 * TestNG XML parameters 
	 ********************************************************************************/
	
	@DataProvider(name = "ReadDataFromExcel")
	public static Object[][] readAllData(Method method, ITestContext context) throws IOException {

	    String fileName = null;
	    String sheetName = null;

	    // Read from @Test description
	    Test testAnnotation = method.getAnnotation(Test.class);

	    if (testAnnotation != null) {

	        String desc = testAnnotation.description();

	        if (desc != null && !desc.isEmpty()) {

	            String[] parts = desc.split(";");

	            for (String part : parts) {

	                if (part.contains("excelFile=")) {
	                    fileName = part.split("=")[1].trim();
	                }

	                if (part.contains("sheet=")) {
	                    sheetName = part.split("=")[1].trim();
	                }
	            }
	        }
	    }

	    // Fallback XML
	    if (fileName == null) {
	        fileName = context.getCurrentXmlTest().getParameter("excelFile");
	    }

	    if (sheetName == null) {
	        sheetName = context.getCurrentXmlTest().getParameter("sheetName");
	    }

	    String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

	    FileInputStream fis = new FileInputStream(path);
	    XSSFWorkbook workBook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workBook.getSheet(sheetName);

	    if (sheet == null) {
	        throw new RuntimeException("Sheet not found: " + sheetName);
	    }

	    DataFormatter df = new DataFormatter();

	    int noOfRows = sheet.getPhysicalNumberOfRows();
	    int noOfColumns = sheet.getRow(0).getLastCellNum();

	    // -1 row for header
	    // -1 column for first column skip
	    Object[][] data = new Object[noOfRows - 1][noOfColumns - 1];

	    // Start from row 1 -> skip header
	    for (int i = 1; i < noOfRows; i++) {

	        Row row = sheet.getRow(i);

	        // Start from column 1 -> skip first column
	        for (int j = 1; j < noOfColumns; j++) {

	            Cell cell = (row != null) ? row.getCell(j) : null;

	            data[i - 1][j - 1] = df.formatCellValue(cell);
	        }
	    }

	    workBook.close();
	    fis.close();

	    return data;
	}
	

	

	// 2ND Logic- Read data dynamically from Excel row-wise using an ID (path taken
	// from the
	// properties file,TestNG XML).

	public static Map<String, String> readDynamicDataFromExcel(ITestContext context) {

		Map<String, String> dataMap = new HashMap<>();

		try {

			// 🔹 Step 1: XML override (highest priority)
			String fileName = context.getCurrentXmlTest().getParameter("excelFile");
			String sheetName = context.getCurrentXmlTest().getParameter("sheetName");
			String expDataId = context.getCurrentXmlTest().getParameter("action");
		
			// 🔹 Step 3: build path
			String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;


			try (FileInputStream fis = new FileInputStream(path); Workbook workBook = new XSSFWorkbook(fis)) {

				Sheet sheet = workBook.getSheet(sheetName);

				if (sheet == null) {
					throw new RuntimeException("Sheet not found: " + sheetName);
				}

				int lastRowNumber = sheet.getLastRowNum();
				int dataRowNumber = -1;

				// 🔹 Step 4: find row by dataId
				for (int i = 0; i <= lastRowNumber; i++) {
					Row row = sheet.getRow(i);
					if (row == null)
						continue;

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

				// 🔹 Step 5: map header-value
				Row dataRow = sheet.getRow(dataRowNumber);
				Row headerRow = sheet.getRow(0);

				for (int j = 1; j < headerRow.getLastCellNum(); j++) {

					String key = headerRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

					String value = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

					dataMap.put(key, value);
				}

			}

		} catch (Exception e) {
			throw new RuntimeException("Error reading Excel data: " + e.getMessage(), e);
		}

		return dataMap;
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

}
