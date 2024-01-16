package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHomePage 
{
   @FindBy(xpath = "//div[text()='Female']") private WebElement femaleButton;
   
   public CoverFoxHomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void selectFemaleGender()
   {
	   femaleButton.click();
   }
}
