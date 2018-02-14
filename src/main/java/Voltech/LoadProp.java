package Voltech;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadProp extends BasePage {

    static String excelFileName = "TestDataConfig.xlsx";
    static String filelocation = "src\\test\\Resources\\Properties\\";
    static FileInputStream input;
    static String data;

    //Fetching data from TestDataConfig.xls file
    public String getExcelProperty(int sheetNumber, int row, int column){

        try
        {
            File src = new File(filelocation + excelFileName);
            input = new FileInputStream(src);

            XSSFWorkbook wb= new XSSFWorkbook(input);

            XSSFSheet sheet1 = wb.getSheetAt(sheetNumber);

            DataFormatter formatter = new DataFormatter();

            data = formatter.formatCellValue(sheet1.getRow(row).getCell(column));

        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

}
