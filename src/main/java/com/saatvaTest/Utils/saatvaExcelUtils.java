package com.saatvaTest.Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class saatvaExcelUtils {

	public String fileName;
	org.apache.poi.ss.usermodel.Sheet sh;
	File testDataFile;
	
	public saatvaExcelUtils(String sheetName)  {

		// get the file path for the data file from config.properties
		try {
			fileName = System.getProperty("user.dir") + parsePropertyfile.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			e.printStackTrace();
		}

		testDataFile = new File(fileName);

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public HashMap<String,String> getTestDataFromFile(int rowNum) throws Exception {
		
		HashMap<String,String> hm = new HashMap<String,String>();
		
		for (int i =0; i<sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		
		
		
		return hm;
		
	}
	
	public int getRowCnt() {
		
		return(sh.getLastRowNum());
	
	}
	
	public int getColCnt() {
		
		return(sh.getRow(0).getLastCellNum());
		
	}

//	public String[][] getTestDataFromFileOld() throws Exception {
//
//		//String fileName = System.getProperty("user.dir") + parsePropertyfile.getPropertyValueByKey("testDataLocation");
//		// using apache Poi to extract data
//		
//
//		int rowcount = sh.getLastRowNum();
//		int cellcount = sh.getRow(0).getLastCellNum();
//
//		String data[][] = new String[rowcount][cellcount];
//
//		for (int i = 1; i <= rowcount; i++) {
//			XSSFRow r = sh.getRow(i);
//			for (int j = 0; j < cellcount; j++) {
//				XSSFCell c = r.getCell(j);
//
//				switch (c.getCellType()) {
//
//				case STRING:
//					data[i - 1][j] = c.getStringCellValue();
//					break;
//
//				case NUMERIC:
//					data[i - 1][j] = String.valueOf(c.getNumericCellValue());
//					break;
//					
//				case BOOLEAN:
//					data[i - 1][j] = String.valueOf(c.getBooleanCellValue());
//					break;
//					
//				default:
//					data[i - 1][j] = " ";
//				}
//			}
//		}
//
//		return data;
//	}
//


//	public static void main(String[] args) throws Exception {
//
//		saatvaExcelUtils datafile = new saatvaExcelUtils();
//
//		String[][] testData = datafile.getTestDataFromFile("SaatvaCreateAccount");
//		for (int i = 0; i < testData.length; i++) {
//			for (int j = 0; j <= testData.length; j++)
//				System.out.println(testData[i][j]);
//				System.out.println("\n------------------\n");
//		}
//		
//	
//
//	}

}
