package com.ea;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Excel_Reader {

    public String path;
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    public Excel_Reader(String path){
        this.path = path;
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getCellData(String sheetName, String colName, int rowNum){
        try {
            int col_Num = 0;
            int index = workbook.getSheetIndex(sheetName); //this will give us the index
            sheet = workbook.getSheetAt(index); //this will give us the sheet
            row = sheet.getRow(0); //reading the 1st row of the sheet

            //running a forloop on above sheet
            for (int i = 0; i < row.getLastCellNum(); i++) { //reading how many columns the sheet has
                if (row.getCell(i).getStringCellValue().equals(colName)) {
                    col_Num = i;           //this will give us column name
                }
            }

            row = sheet.getRow(rowNum - 1);     //eliminating the first row of sheet and fixing the row number
            cell = row.getCell(col_Num);

            if(cell.getCellTypeEnum() == CellType.STRING){
                return cell.getStringCellValue();
            } else if(cell.getCellTypeEnum() == CellType.NUMERIC){
                return String.valueOf(cell.getNumericCellValue());
            } else if(cell.getCellTypeEnum() == CellType.BOOLEAN){
                return String.valueOf(cell.getBooleanCellValue());
            } else if(cell.getCellTypeEnum() == CellType.BLANK){
                return "";
            }
        }


        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getRowCount(String sheetName){
        try {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return 0;
            }
            else {
                sheet = workbook.getSheetAt(index);
                int number = sheet.getLastRowNum() + 1;
                return number;
            }
            }
            catch(Exception e){
                e.printStackTrace();
        }
        return 0;

    }
    public int getColumnCount(String sheetName) {
        try {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return 0;
            } else {
                sheet = workbook.getSheet(sheetName);
                row = sheet.getRow(0);
                return row.getLastCellNum();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args){
        String path = System.getProperty("user.dir")+"//src//test//resources//TestData.xlsx";
        Excel_Reader obj = new Excel_Reader(path);
        System.out.println(obj.getCellData("Cars", "Make",1)); //prints value of targeted column and row
        System.out.println(obj.getRowCount("Cars")); //prints total rows of Cars sheet
    }
}