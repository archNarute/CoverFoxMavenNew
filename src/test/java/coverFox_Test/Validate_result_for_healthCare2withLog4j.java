package coverFox_Test;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFox_Base.Base;
import coverFox_POM.CoverFoxAddressDetailPage;
import coverFox_POM.CoverFoxHealthPlan;
import coverFox_POM.CoverFoxHomePage;
import coverFox_POM.CoverFoxMemberDetailsPage;
import coverFox_POM.CoverFoxResultPage;
import coverFox_Utility.Utility;


public class Validate_result_for_healthCare2withLog4j extends Base{
 
	public static Logger logger;
	CoverFoxHealthPlan healthPlan;
	CoverFoxAddressDetailPage addressDetail;
	CoverFoxHomePage home;
	CoverFoxMemberDetailsPage memberDetail;
	CoverFoxResultPage result;
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{   
		logger=logger.getLogger("CoverFoxLog");
		//PropertyConfigurator.configure("Log4j.properties");
		
		PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "Log4j.properties");
		logger.info("launching CoverFox");
		launchCoverfox();
		home=new CoverFoxHomePage(driver);
		healthPlan=new CoverFoxHealthPlan(driver);
		memberDetail=new CoverFoxMemberDetailsPage(driver);
		addressDetail=new CoverFoxAddressDetailPage(driver);
		result=new CoverFoxResultPage(driver);
		
		
		
	}
	
	@BeforeMethod
	public void enterRequiredDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		logger.info("clicking on female button");
		home.selectFemaleGender();
		Thread.sleep(2000);
		
		//Reporter.log("clicking on next button", true);
		logger.warn("clicking on next button");
		healthPlan.clickOnNextButton();
		Thread.sleep(2000);
		
		//Reporter.log("selecting age from dropDown", true);
		logger.info("selecting age from dropDown");
		//memberDetail.selectAgeFromDropDown(Utility.readDataFromExcel(1, 0));
		memberDetail.selectAgeFromDropDown(Utility.readDataFromPropertiesFile("age"));
		//Reporter.log("clicking on next button", true);
		logger.info("clicking on next button");
		memberDetail.clickOnNextButton();
		Thread.sleep(2000);
		
		//Reporter.log("entering zipcode", true);
		logger.error("entering zipcode");
		//addressDetail.enterPinCode(Utility.readDataFromExcel(1, 1));
		memberDetail.selectAgeFromDropDown(Utility.readDataFromPropertiesFile("pincode"));
		//Reporter.log("entering mobNum", true);
		logger.fatal("entering mobNum");
		//addressDetail.enterMobNum(Utility.readDataFromExcel(1, 2));
		memberDetail.selectAgeFromDropDown(Utility.readDataFromPropertiesFile("mobnum"));
		//Reporter.log("clicking on continue button", true);
		logger.info("clicking on continue button");
		addressDetail.clickOnContinueButton();
		Thread.sleep(2000);
	
	}
	
	@Test
  public void validateResultFromTextAndBanner() throws InterruptedException, IOException
	{   Thread.sleep(6000);
		//Reporter.log("fetching result from text", true);
		logger.info("fetching result from text");
		int textResult = result.planCountFromText();
		Thread.sleep(6000);
		
		//Reporter.log("fetching result from banner", true);
		logger.info("fetching result from banner");
	     int bannerResult = result.planCountFromBanner();
	     Thread.sleep(6000);
	     Assert.assertEquals(textResult, bannerResult,"textResult & bannerResult are not matched, TC is failed");
  
	     
	     logger.info("TC is passed");
	     Utility.takesScreenshot(driver, "TC_555");
	}
	
	@AfterMethod
	public void closeTheBrowser() throws InterruptedException
	{
		logger.info("closing browser");
		Thread.sleep(5000);
		driver.close();
		
	}
}
