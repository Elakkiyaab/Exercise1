package nl.home.testing.utils;

import com.beust.jcommander.internal.Lists;
import nl.home.testing.properties.Search;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.List;


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
    public static Object[][] getOptions(List<Search> searches)
    {
        Object [][] objArray = new Object[searches.size()][];
        int index =0;
        for(Search data:searches) {
            objArray[index] = new Object[1];
            objArray[index++][0] = data;
        }
        return objArray;
    }



}