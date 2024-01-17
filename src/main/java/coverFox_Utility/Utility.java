 package coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility
{// commonly used methods are present
	
	public static void takesScreenshot(WebDriver driver, String TCID) throws IOException 
	{   
	    Reporter.log("taking ss", true);
	     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Dell\\Desktop\\velocity\\ss_coverfox_"+TCID+"_"+timeStamp+".png");
		Reporter.log("saving ss at"+dest, true);
		FileHandler.copy(source, dest);
	}
	
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("reading data from excel", true);
		//FileInputStream myfile=new FileInputStream("C:\\Users\\Dell\\Desktop\\velocity\\Book1.xlsx");
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Book1.xlsx");
       Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet2");
       String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
       return data;
	}
	
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties prop=new Properties();
		
		//FileInputStream myfile=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Selenium_study\\CoverFox.properties");
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\CoverFox.properties");
		
	  
		prop.load(myfile);
		
		String value = prop.getProperty(key);
		return value;
	
	}
	

}
