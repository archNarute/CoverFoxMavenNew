package coverFox_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Base 
{
//used for only browser handling
	
	static protected  WebDriver driver;
	
	public void launchCoverfox() throws InterruptedException
	{   ChromeOptions opt=new ChromeOptions();
	    opt.addArguments("-disable-notifications");
		Reporter.log("browser is launching", true);
		driver=new ChromeDriver(opt);
		driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	public void closeCoverfox() throws InterruptedException
	{
		Reporter.log("closing browser", true);
		driver.close();
		Thread.sleep(1000);
	}
	
}
