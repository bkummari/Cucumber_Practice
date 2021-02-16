package myhooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooksTest {

	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order= 0)
	public void  getProperty()
	{
		configReader= new ConfigReader();
		prop=configReader.init_prop();
	}
	@Before(order= 1)
	public void  launchBrowser()
	{
		String brwoserName=prop.getProperty("browser");
		driverfactory= new DriverFactory();
		driver=driverfactory.init_driver(brwoserName);
		
	}
	
	@After(order=0)
	public void quitBrowser(){
		driver.quit();
	}
	@After(order=1)
	public void tearDown(Scenario sc){
		if(sc.isFailed()) {
			//Take screen shot
			
			String  screenShotName=sc.getName().replaceAll(" ", "-");
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcepath, "image/png", screenShotName);
		}
	}
}
