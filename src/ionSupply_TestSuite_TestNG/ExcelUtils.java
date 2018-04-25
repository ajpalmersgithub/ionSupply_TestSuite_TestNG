package ionSupply_TestSuite_TestNG;

import ionSupply_TestSuite_TestNG.Constant;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;


public class ExcelUtils {
	
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell sCell;

	private static XSSFRow sRow;

   
	//This method will set the File path and open the Excel file.
    // The Excel Path and Sheetname are passed to this method in the getCellData method below

public static void setFilePath(String Path,String SheetName) throws Exception {
	
		try {

		FileInputStream ExcelFile = new FileInputStream(Path);

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception {
	        
			
	      setFilePath(Constant.Path_TestData + Constant.File_TestData, "SHEET1");
	        
			sCell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = sCell.getStringCellValue();
			
			return CellData;			
             }

//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			sRow  = ExcelWSheet.getRow(RowNum);

		sCell = sRow.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

		if (sCell == null) {

			sCell = sRow.createCell(ColNum);

			sCell.setCellValue(Result);

			} else {

				sCell.setCellValue(Result);

			}

// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			}catch(Exception e){

				throw (e);

		}

	}

}
