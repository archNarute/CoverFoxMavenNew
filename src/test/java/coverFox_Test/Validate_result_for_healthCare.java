package coverFox_Test;


import java.io.IOException;

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


public class Validate_result_for_healthCare extends Base{
 
	
	CoverFoxHealthPlan healthPlan;
	CoverFoxAddressDetailPage addressDetail;
	CoverFoxHomePage home;
	CoverFoxMemberDetailsPage memberDetail;
	CoverFoxResultPage result;
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
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
		Reporter.log("clicking on female button", true);
		home.selectFemaleGender();
		Thread.sleep(2000);
		
		Reporter.log("clicking on next button", true);
		healthPlan.clickOnNextButton();
		Thread.sleep(2000);
		
		Reporter.log("selecting age from dropDown", true);
		memberDetail.selectAgeFromDropDown(Utility.readDataFromExcel(1, 0));
		Reporter.log("clicking on next button", true);
		memberDetail.clickOnNextButton();
		Thread.sleep(2000);
		
		Reporter.log("entering zipcode", true);
		addressDetail.enterPinCode(Utility.readDataFromExcel(1, 1));
		Reporter.log("entering mobNum", true);
		addressDetail.enterMobNum(Utility.readDataFromExcel(1, 2));
		Reporter.log("clicking on continue button", true);
		addressDetail.clickOnContinueButton();
		Thread.sleep(2000);
	
	}
	
	@Test
  public void validateResultFromTextAndBanner() throws InterruptedException, IOException
	{   Thread.sleep(6000);
		Reporter.log("fetching result from text", true);
		int textResult = result.planCountFromText();
		Thread.sleep(6000);
		
		Reporter.log("fetching result from banner", true);
	     int bannerResult = result.planCountFromBanner();
	     Thread.sleep(6000);
	     Assert.assertEquals(textResult, bannerResult,"textResult & bannerResult are not matched, TC is failed");
  
	     Reporter.log("TC is passed", true);
	     Utility.takesScreenshot(driver, "TC_555");
	}
	
	@AfterMethod
	public void closeTheBrowser() throws InterruptedException
	{
		Reporter.log("closing browser", true);
		Thread.sleep(5000);
		driver.close();
		
	}
}
