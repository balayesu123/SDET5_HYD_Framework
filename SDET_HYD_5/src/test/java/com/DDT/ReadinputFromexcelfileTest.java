package com.DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadinputFromexcelfileTest {
   @Test
   public void readinputfromexcelfile() throws Throwable
   {
	   File file=new File("C:\\Users\\sivaram\\eclipse-workspace\\SDET_HYD_5\\commanDataExcel.xlsx");
	   FileInputStream fis=new FileInputStream(file);
	   XSSFWorkbook workbook= new XSSFWorkbook(fis);
	   XSSFSheet sheet=workbook.getSheetAt(0);
	   
	   String cellvalue00=sheet.getRow(0).getCell(0).getStringCellValue();
	   System.out.print(cellvalue00+"  ");
	   String cellvalue10=sheet.getRow(1).getCell(0).getStringCellValue();
	   System.out.println(cellvalue10);
	   
	   String cellvalue01=sheet.getRow(0).getCell(1).getStringCellValue();
	   System.out.print(cellvalue01+"  ");
	   String cellvalue11=sheet.getRow(1).getCell(1).getStringCellValue();
	   System.out.println(cellvalue11);
	   
	   String cellvalue02=sheet.getRow(0).getCell(2).getStringCellValue();
	   System.out.print(cellvalue02+"  ");
	   long cellvalue12=(long) sheet.getRow(1).getCell(2).getNumericCellValue();
	   System.out.println(cellvalue12);
	   workbook.close();
	   fis.close();
   }
}
