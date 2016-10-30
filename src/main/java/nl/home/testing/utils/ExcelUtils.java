package nl.home.testing.utils;

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Splitter;
import nl.home.testing.data.Search;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class ExcelUtils {
    public static final int LOCATION_CELL_INDEX = 0;
    public static final int DISTANCE_CELL_INDEX = 1;
    public static final int MIN_PRICE_CELL_INDEX = 2;
    public static final int MAX_PRICE_CELL_INDEX = 3;
    public static final int PAGE_TITLE_CELL_INDEX = 4;
    private static HSSFSheet excelWSheet;
    private static HSSFWorkbook excelWBook;

    public static List<Search> getSearchOptions(String FilePath, String sheetName)    throws Exception
    {
        List<Search> list = Lists.newArrayList();
        try(FileInputStream excelFile = new FileInputStream(FilePath)){
            excelWBook = new HSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            //leving header.
            for (Integer i=1 ; i<=excelWSheet.getLastRowNum(); i++){
                list.add(covert(excelWSheet.getRow(i)));
            }
        }
        catch (Exception e)
        {
            System.out.println("Could not read the Excel sheet"+e.getStackTrace());
            e.printStackTrace();
            throw e;
        }

        return list;
    }

   private static Search covert(HSSFRow row){
       Search search = new Search();
       search.setLocation(row.getCell(LOCATION_CELL_INDEX).getStringCellValue());
       search.setDistance(row.getCell(DISTANCE_CELL_INDEX).getStringCellValue());
       search.setMinPrice(row.getCell(MIN_PRICE_CELL_INDEX).getStringCellValue());
       search.setTotPrice(row.getCell(MAX_PRICE_CELL_INDEX).getStringCellValue());
       search.setPageTitle(row.getCell(PAGE_TITLE_CELL_INDEX).getStringCellValue());
       return search;
   }

}