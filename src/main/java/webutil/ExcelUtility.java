package webutil;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	public static Object[][] getTestData(String filePath, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fis.close();
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        // Total data rows (excluding header row)
        int rowCount = sheet.getLastRowNum(); // row 0 = header

        // Total columns from header row
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        DataFormatter formatter = new DataFormatter(); // Converts any cell type to String

        // Start from row 1 (skip header)
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                String value = "";

                if (row != null) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        value = formatter.formatCellValue(cell).trim();
                    }
                }

                data[i - 1][j] = value;
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
	
	
	
	
	
	
	
}
