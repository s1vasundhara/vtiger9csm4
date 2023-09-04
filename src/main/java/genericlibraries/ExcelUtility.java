package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	 private Workbook workbook;
	 private DataFormatter df;
	  
	 public void excelInitialization(String excelpath)
	 {
		 FileInputStream fis=null;
			try {
			fis=new FileInputStream(excelpath);
		    }catch (FileNotFoundException e) {
				e.printStackTrace();}
			
		 Workbook workbook=null;
			try {
				workbook=WorkbookFactory.create(fis);
			}catch(IOException e){
				e.printStackTrace();}
	 }
	 
	 /**This method is use read data of specified test script at a time
	  * @parameter sheetName
	  * @parameter expected TestName
	  * @return
	  */
	 public Map<String, String> readFronExcel(String sheetName, String expectedTestName)
	 {
		 Map<String, String> map= new HashMap<String, String>();
		 df=new DataFormatter();
		 Sheet sheet= workbook.getSheet(sheetName);
		 
		 for(int i=0;i<=sheet.getLastRowNum();i++)
		 {
			 if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName))
			 {
				for(int j=0;j<=sheet.getLastRowNum();j++) 
				{
					map.put(df.formatCellValue(sheet.getRow(j).getCell(2)),
							df.formatCellValue(sheet.getRow(j).getCell(3)));
					if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"));
					break;
				}
				break;
			 }
	     }
		 return map;
	 }
	 
	 public void writeToExcel(String sheetName, String expectedTestName, String status, String excelpath) {
			Sheet sheet = workbook.getSheet(sheetName);

			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				if (df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName)) {
					Cell cell = sheet.getRow(i).createCell(4);
					cell.setCellValue(status);
					break;
				}
			}
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(excelpath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				workbook.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/**
		 * This method is used to close excel
		 */
		public void excelClose()
		{
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void closeExcel() {
			// TODO Auto-generated method stub
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	
		 
		 
	 }