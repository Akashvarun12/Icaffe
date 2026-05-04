package webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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

	// 1st Logic- Read data from Excel using Properties file path.....

	@DataProvider(name = "ReadDataFromExcel")
	public static Object[][] readAllData() throws IOException {

		// properties load

		String fileName = WebUtil.getConfig("excel.file");
		String sheetName = WebUtil.getConfig("excel.sheet");

		String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

		FileInputStream fis = new FileInputStream(path);
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

	// 2nd Logic- Read data from Excel using the file name and sheet name in the
	// @Test annotation.

	@DataProvider(name = "ReadDataFromExcel")
	public static Object[][] readAllData(Method method) throws IOException {

		Test test = method.getAnnotation(Test.class);

		if (test == null || test.description().isEmpty()) {
			throw new RuntimeException("Please provide sheetName|fileName in @Test(description)");
		}

		String[] data = test.description().split("\\|");

		String sheetName = data[0];
		String fileName = data[1];

		String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

		File excelFile = new File(path);
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

	// 3rd Logic- Read data Dynamically in Excel with Row wise...using ID and sheet
	// name

	public static Map<String, String> setExcelFile(String sheetName, String expDataId) {
		Map<String, String> dataMap = new HashMap<>();

		try (FileInputStream fls = new FileInputStream("Akash_TestByDataprovider.xlsx");
				Workbook workBook = new XSSFWorkbook(fls)) {

			Sheet sheet = workBook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet not found: " + sheetName);
			}

			int lastRowNumber = sheet.getLastRowNum();
			int dataRowNumber = -1;

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

	//4th Logic- Read data dynamically from Excel row-wise using an ID (path taken from the
	// properties file).

	public static Map<String, String> readDynamicDataFromExcel(String expDataId) {
		Map<String, String> dataMap = new HashMap<>();

		String fileName = WebUtil.getConfig("excel.file");
		String sheetName = WebUtil.getConfig("excel.sheet");

		String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

		try (FileInputStream fls = new FileInputStream(path); Workbook workBook = new XSSFWorkbook(fls)) {

			Sheet sheet = workBook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet not found: " + sheetName);
			}

			int lastRowNumber = sheet.getLastRowNum();
			int dataRowNumber = -1;

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

	//5th Logic- Read All data from Excel using List or Map logic, without using a Data
	// Provider.

	public static List<Map<String, String>> setExcelFile() {
		FileInputStream fls;
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		String fileName = WebUtil.getConfig("excel.file");
		String sheetName = WebUtil.getConfig("excel.sheet");

		String path = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

		try {
			File excelFile = new File(path);

			System.out.println(excelFile.exists());
			fls = new FileInputStream(excelFile);
			Workbook workBook = new XSSFWorkbook(fls);
			Sheet sheet = workBook.getSheet(sheetName);
			int lastRowNumber = sheet.getLastRowNum();

			for (int j = 1; j <= sheet.getLastRowNum(); j++) {
				Map<String, String> dataMap = new HashMap<String, String>();

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

}
