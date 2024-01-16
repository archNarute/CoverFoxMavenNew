package coverFox_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class Validate_errorMsg_for_Pincode_Field extends Base
{ 
	CoverFoxHomePage home;
	CoverFoxHealthPlan healthPlan;
	CoverFoxMemberDetailsPage memberDetails;
	CoverFoxAddressDetailPage addressDetail;
	CoverFoxResultPage resultPage;
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
		launchCoverfox();
		home=new CoverFoxHomePage(driver);
		healthPlan=new CoverFoxHealthPlan(driver);
		memberDetails=new CoverFoxMemberDetailsPage(driver);
		addressDetail=new CoverFoxAddressDetailPage(driver);
		resultPage=new CoverFoxResultPage(driver);
		 
	}
	
	
	@BeforeMethod
	public void addingDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("selecting gender", true);
		home.selectFemaleGender();
		Thread.sleep(1000);
		 
		Reporter.log("clicking on next button", true);
		healthPlan.clickOnNextButton();
		Thread.sleep(1000);
		
		Reporter.log("selecting age from dropdown", true);
		memberDetails.selectAgeFromDropDown(Utility.readDataFromExcel(1, 0));
		Thread.sleep(2000);
		
		Reporter.log("click on next button", true);
		memberDetails.clickOnNextButton();
		Thread.sleep(2000);
		
		
		Reporter.log("entering zipcode", true);
		addressDetail.enterPinCode(Utility.readDataFromExcel(0, 0));
		Thread.sleep(1000);
		
		Reporter.log("entering mobNumber", true);
		addressDetail.enterMobNum(Utility.readDataFromExcel(1, 2));
		Thread.sleep(1000);
		
		Reporter.log("clicking on continue button", true);
		addressDetail.clickOnContinueButton();
		Thread.sleep(1000);
	
	}
	
	@Test
  public void validateErrorMsgForPincodeIsDisplayed() throws InterruptedException 
	{  
		Thread.sleep(5000);
		Reporter.log("displaying error msg", true);
		//Boolean status=addressDetail.checkErrorMsg();
		Assert.assertTrue(addressDetail.checkErrorMsg(), "error msg not displayed, tc is failed");
    }
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{Thread.sleep(2000);
	 closeCoverfox();
	}
}
