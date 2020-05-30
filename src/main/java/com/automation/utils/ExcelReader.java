package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader {

	private static ExcelReader reader;
	private File file;

	/**
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	private ExcelReader(String filePath) throws FileNotFoundException {
		file = new File(filePath);
	}

	/**
	 * Creates instance for ExcelReader and returns the instance.
	 * 
	 * @param filePath
	 *            - Path of the file
	 * @return ExcelReaderInstance
	 */
	public static ExcelReader getInstance(String filePath) {
		try {
			reader = new ExcelReader(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return reader;
	}


	/**
	 * Returns sheet name.
	 * 
	 * @param sheetName
	 *            - Name of the sheet
	 * @return sheetName
	 */
	private HSSFSheet getSheet(String sheetName) {
		HSSFWorkbook workbook;
		HSSFSheet sheet = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(file));
			sheet = workbook.getSheet(sheetName);
			System.out.println(" Data will be read from the sheet :" + sheetName);
			return sheet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}


	/**
	 * Returns Column values from the given sheet.
	 * 
	 * @param sheet
	 *            - sheet
	 * @return columnvalues
	 */
	private List<String> getColumns(HSSFSheet sheet) {
		final HSSFRow row = sheet.getRow(0);
		final List<String> columnValues = new ArrayList<String>();
		final int firstCellNum = row.getFirstCellNum();
		final int lastCellNum = row.getLastCellNum();
		for (int i = firstCellNum; i < lastCellNum; i++) {
			final HSSFCell cell = row.getCell(i);
			columnValues.add(cell.getStringCellValue());
		}
		return columnValues;
	}

	private Map<String, String> getSheetData(String tcID, String sheetName) {
		final List<String> rowData = new ArrayList<String>();
		final Map<String, String> rowVal = new HashMap<String, String>();
		Object value = null;
		final HSSFSheet sheet = getSheet(sheetName);
		final List<String> coulmnNames = getColumns(sheet);
		final int totalRows = sheet.getPhysicalNumberOfRows();
		final HSSFRow row = sheet.getRow(0);
		final int firstCellNum = row.getFirstCellNum();
		final int lastCellNum = row.getLastCellNum();
		for (int i = 1; i < totalRows; i++) {
			final HSSFRow rows = sheet.getRow(i);
			final String testLinkID = rows.getCell(0).getStringCellValue();
			if (tcID.equalsIgnoreCase(testLinkID)) {
				for (int j = firstCellNum; j < lastCellNum; j++) {
					final HSSFCell cell = rows.getCell(j);
					if (cell == null
							|| cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						rowData.add("");
					} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						final Double val = cell.getNumericCellValue();
						value = val.intValue();// cell.getNumericCellValue();
						rowData.add(value.toString());
					} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						rowData.add(cell.getStringCellValue());
					} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN
							|| cell.getCellType() == Cell.CELL_TYPE_ERROR
							|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
						throw new RuntimeException(
								" Cell Type is not supported ");
					}
					rowVal.put(coulmnNames.get(j), rowData.get(j).trim());
				}
				break;
			}
		}
		return rowVal;
	}

	/**
	 * Get row value as Map for the given TestLink ID and sheet name.
	 * 
	 * @param tcID
	 *            - TestLink ID
	 * @param sheetName
	 *            - Sheet Name to fetch data
	 * @return Map
	 */
	public Map<String, String> getRowValue(String tcID, String sheetName) {
		final Map<String, String> rowData = getSheetData(tcID, sheetName);
		if (!rowData.isEmpty()) {
			return rowData;
		} else {
			throw new NullPointerException(tcID + " : doen't exist in "+ sheetName + " sheet");
		}
	}

	static Map<Integer, String> rowData;
	List<String> rowValue;

	public void gettingdata(String sheetName) {
		rowData = new HashMap<Integer, String>();
		rowValue = new ArrayList<String>();
		final HSSFSheet sheet = getSheet(sheetName);
		final int totalRows = sheet.getPhysicalNumberOfRows();
		System.out.println(totalRows);
		final HSSFRow row = sheet.getRow(0);
		final int lastCellNum = row.getLastCellNum();
		System.out.println(lastCellNum);	
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				HSSFCell cell =sheet.getRow(i).getCell(j);
				if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					rowValue.add("");
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					Object value = cell.getNumericCellValue();
					rowValue.add(value.toString());
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					String text =cell.getStringCellValue();
					rowValue.add(text.trim());
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN
						|| cell.getCellType() == Cell.CELL_TYPE_ERROR
						|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					throw new RuntimeException(
							" Cell Type is not supported ");
				}

			}
			rowData.put(i, rowValue.toString());
		}
	}



	public static void main(String[] args) throws FileNotFoundException {
		ExcelReader excelreader = new ExcelReader("C:\\Users\\rkakumani\\git\\Automation\\src\\main\\resources\\TestDataFiles\\TestDataSheetRegister.xls");
		excelreader.gettingdata("Register");
		System.out.print(rowData);
	}
}