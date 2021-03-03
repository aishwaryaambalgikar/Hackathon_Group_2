package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;

public class InputFromExcel {
	public static String[] formData = new String[8];

	@Test
	public String searchInput() throws IOException {
		String course;
		// to read course name from excel file get the excel file
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Excel_Input\\SearchInput.xlsx");

		// create workbook object
		@SuppressWarnings("resource")
		XSSFWorkbook wk = new XSSFWorkbook(fs);

		// get the sheet
		XSSFSheet sheet = wk.getSheetAt(0);

		// get first row of the sheet
		Row row = sheet.getRow(0);

		// get first column of sheet
		Cell cell = row.getCell(0);
		course = cell.getStringCellValue();

		return course;
	}

	@Test
	public static String[] businessInput() throws IOException {
		// get the excel file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Excel_Input\\FormInput.xlsx");

		// create workbook object
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Values");

		// get first row of the sheet
		XSSFRow row = sheet.getRow(0);

		// looping to get input from excel
		for (int i = 0; i <= 7; i++) {
			if (i == 3) {
				// get the phone number from excel and convert it into long datatype
				long data = (long) row.getCell(i).getNumericCellValue();

				// store the value in the variable
				formData[i] = Long.toString(data);
			} else {
				// store the value in the variable
				formData[i] = String.valueOf(row.getCell(i));
			}
		}

		// close workbook
		workbook.close();

		// return data
		return formData;
	}
	
	@Test
	public static String[] businessValidInput() throws IOException {
		// get the excel file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Excel_Input\\FormValidInput.xlsx");

		// create workbook object
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Values");

		// get first row of the sheet
		XSSFRow row = sheet.getRow(0);

		// looping to get input from excel
		for (int i = 0; i <= 7; i++) {
			if (i == 3) {
				// get the phone number from excel and convert it into long datatype
				long data = (long) row.getCell(i).getNumericCellValue();

				// store the value in the variable
				formData[i] = Long.toString(data);
			} else {
				// store the value in the variable
				formData[i] = String.valueOf(row.getCell(i));
			}
		}

		// close workbook
		workbook.close();

		// return data
		return formData;
	}

	public static String[] businessInput(int rno) {
		// TODO Auto-generated method stub
		return null;
	}
}