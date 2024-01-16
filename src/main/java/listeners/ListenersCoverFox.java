package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import coverFox_Base.Base;
import coverFox_Utility.Utility;

public class ListenersCoverFox extends Base implements ITestListener
{
   @Override
public void onTestFailure(ITestResult result) 
   {
	 try {
		Utility.takesScreenshot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
   
  
}
