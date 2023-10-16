package test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class commonMethods {



   
    public ArrayList<String> exel(String sheetname, String testcaseName) throws IOException {
        
        FileInputStream file = new FileInputStream("C:\\Users\\Hp\\Desktop\\Automation Training\\amezon.xlsx");
        
        XSSFWorkbook wbook = new XSSFWorkbook(file);
        
        ArrayList <String> testcasedata = new ArrayList<>();
        
        XSSFSheet sheet   = wbook.getSheet(sheetname);
        Iterator <Row> row    =sheet.rowIterator();
        while(row.hasNext()) {
       Row specificrow     = row.next();
   
    if (specificrow.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseName)) {
         Iterator <Cell> cell   = specificrow.cellIterator();
        
         while(cell.hasNext()) {
            Cell specificCellValue= cell.next();
        String cell2= specificCellValue.getStringCellValue();
            testcasedata.add(cell2);
         }
         System.out.println();
    }
            
        }
        return testcasedata;
    }
        
}




