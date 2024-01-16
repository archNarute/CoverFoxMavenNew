package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxAddressDetailPage 
{
   // @FindBy(xpath = "(//input[@type='number'])[1]") private WebElement pinCodeField;
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement pinCodeField;
   // @FindBy(xpath="//input[@maxlength='6']") private WebElement pinCodeField1;
    @FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobNumField;
    @FindBy(className = "next-btn") private WebElement continueButton;
    @FindBy(className = "error-ui") private WebElement errorMsg;
    
    
    public CoverFoxAddressDetailPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void enterPinCode(String pinCode)
    {
    	pinCodeField.sendKeys(pinCode);
    }
    
    public void enterMobNum(String mobNum)
    {
    	mobNumField.sendKeys(mobNum);
    }
    
    public void clickOnContinueButton()
    {
    	continueButton.click();
    }
    
    public boolean checkErrorMsg()
    {
      boolean status = errorMsg.isDisplayed();
    	return status;
    }
}
