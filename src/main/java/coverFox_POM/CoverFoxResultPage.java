package coverFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultPage 
{
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement matchingHealthInsuranceResult;
	
    @FindBy(id = "plans-list") private List<WebElement> planList;
    
    public CoverFoxResultPage(WebDriver driver) 
    {
		PageFactory.initElements(driver, this);
	}
    
    
    public int planCountFromText() throws InterruptedException
    {
    	String totalResult = matchingHealthInsuranceResult.getText();
    	//output ---49 matching Health Insurance Plans
    	Thread.sleep(1000);
    	System.out.println(totalResult);
    	Thread.sleep(1000);
    	String[] separateResult = totalResult.split(" ");
        String numOfResultInString = separateResult[0];
        Thread.sleep(500);
        //we have to convert numOfResultInString int numOfResultInint
        //convert string to integer
        int numOfResultInint = Integer.parseInt(numOfResultInString);
        return numOfResultInint;
        
    
    }
    
    public int planCountFromBanner() throws InterruptedException
    {
    int totalNoOfActualPlan = planList.size();
    Thread.sleep(1000);
    return totalNoOfActualPlan;
    
    }
    
}
