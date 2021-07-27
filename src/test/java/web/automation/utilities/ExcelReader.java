package web.automation.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReader {

    FileInputStream file;
    FileOutputStream fout;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    Row row;
    int count = 0;
    Cell cell;

    ExcelReader(String sheetName, String workbook) throws IOException {
        file = new FileInputStream(getPath()+"/src/test/resources/data/"+workbook+".xlsx");
        fout = new FileOutputStream(getPath()+"/src/test/resources/data/"+workbook+".xlsx");
        wb= new XSSFWorkbook(file);
        sheet = wb.getSheet(sheetName);
    }
    /*
        this method will be used to read given excel file with row, col index
     */
    public String readExcelByIndex(int row, int col){
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    /*
        this method will be used to read given excel file by row value
     */
    public String readExcelByRowValue(String rowValue){
        count = sheet.getLastRowNum();
        String str = "";
        for(int i=0;i<=count;i++){
            if(rowValue.equals(sheet.getRow(i).getCell(0).getStringCellValue())){
                str = sheet.getRow(i).getCell(1).getStringCellValue();
                break;
            }
        }
        return str;
    }

    public String getPath()
    {
        String path ="";
        File file = new File("");
        String absolutePathOfFirstFile = file.getAbsolutePath();
        path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
        return path;
    }
}
