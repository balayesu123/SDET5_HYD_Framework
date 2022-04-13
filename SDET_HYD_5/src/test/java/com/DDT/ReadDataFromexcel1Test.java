package com.DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromexcel1Test {
   @Test
   public void readDataFromExcel() throws Exception
   {
	   File file=new File("C:\\Users\\sivaram\\eclipse-workspace\\SDET_HYD_5\\commanDataExcel.xlsx");
	   FileInputStream fis=new FileInputStream(file);
	   XSSFWorkbook workbook= new XSSFWorkbook(fis);
	   XSSFSheet sheet=workbook.getSheetAt(0);
	   
	   XSSFRow row=sheet.getRow(1);
	   XSSFCell cell= row.getCell(0);
	   String cellvalue=cell.getStringCellValue();
	   System.out.println(cellvalue);
	   
	   
	   XSSFCell cell1= row.getCell(1);
	   String cellvalue1=cell1.getStringCellValue();
	   System.out.println(cellvalue1);
	   
	   
	   XSSFCell cell2= row.getCell(2);
	   long cellvalue2=(long) cell2.getNumericCellValue();
	   System.out.println(cellvalue2);
   }
}
