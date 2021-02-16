package com.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPagequicklaunchLinks {
	
	private WebDriver driver;
	//1 Create By locators
	private By quickLaunchLink=By.cssSelector("div#dashboard-quick-launch-panel-container span");
	/*private By assignLeave=By.xpath("//a/span[text()='Assign Leave']");
	private By leaveList=By.xpath("//a/span[text()='Leave List']");
	private By timeSheets=By.xpath("//a/span[text()='Timesheets']");
	private By applyLeave=By.xpath("//a/span[text()='Apply Leave']");
	private By myLeave=By.xpath("//a/span[text()='My Leave']");
	private By myTimesheet=By.xpath("//a/span[text()='My Timesheet']");*/
	
	//2 maintain constrctor
	public DashBoardPagequicklaunchLinks(WebDriver driver)
	{
		this.driver=driver;
	}
   //3. Create Action classes
	public String  getDashboardTitle()
	{
		return driver.getTitle();
	}
	
	public int getQuickLaunchLinksCount()
	{
		return driver.findElements(quickLaunchLink).size();
	}
	public List<String> getQuickLaunchLinkstext()
	{
		List<String> quickLaunchLists=new ArrayList<>();
		List<WebElement>qlList=driver.findElements(quickLaunchLink);
		
		for(WebElement e:qlList)
		{
			String txt=e.getText();
			System.out.println("Links text is:"+txt);
			quickLaunchLists.add(txt);
		}
		return quickLaunchLists;
	}
}
