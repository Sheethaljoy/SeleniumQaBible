package com.utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
		/*try {
			File f = new File(System.getProperty("user.dir") +"//src//main//resources//ExcelReadExample.xlsx");
			FileInputStream file = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			// first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
				}
				System.out.println();
				file.close();
				workbook.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	*/
	
  public static FileInputStream file; //-->file read
  public static XSSFWorkbook workBook; //-->workbook read
  public static XSSFSheet sheet; //-->sheet read

	public static String getStringData(int row, int col,String sheet1) throws IOException

	{
		
		file = new FileInputStream(System.getProperty("user.dir") +"/src/main/resources/ExcelReadExample.xlsx");
		workBook = new XSSFWorkbook(file);
		sheet = workBook.getSheet(sheet1);
		Row r = sheet.getRow(row);
		Cell f = r.getCell(col);
		return f.getStringCellValue();

	}
	/*
	public static String getIntegerData(int x, int y) throws IOException

	{
		a = new FileInputStream(System.getProperty("user.dir") +"/src/main/resources/ExcelReadExample.xlsx");
		b = new XSSFWorkbook(a);
		c = b.getSheet("Sheet1");
		Row r = c.getRow(x);
		Cell f = r.getCell(y);
		int s1 = (int) f.getNumericCellValue();
		return String.valueOf(s1);

	}
	*/
}
