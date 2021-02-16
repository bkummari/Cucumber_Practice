package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	// here we need  to do three things 1. maintain By locator 2. maintain constrctor 3. create page actions
	
	private WebDriver driver;
	
	//1  maintain By locator
	private By username=By.id("txtUsername");
	private By password=By.id("txtPassword");
	private By loginbutton=By.id("btnLogin");
	private By forgotpasswordLink=By.linkText("Forgot your password?");
	private By dashboard=By.id("menu_dashboard_index");
	private By dashboardtxt=By.xpath("//div[@class='head']/h1");
	
	//2 maintain constrctor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	// 3. create page actions
	public String  getTitle()
	{
		return driver.getTitle();
	}
    public boolean isForgotPasswordLinkExist() {
	 return driver.findElement(forgotpasswordLink).isDisplayed();
 }
    public void enterUserName(String uname)
    {
    	driver.findElement(username).sendKeys("uname");
    }
    public void enterPassword(String passWord)
    {
    	driver.findElement(password).sendKeys("passWord");
    }
    public void hitOnLogin()
    {
    	driver.findElement(loginbutton).click();
    	
    
    }
    public DashBoardPagequicklaunchLinks doLogin(String uname, String passWord)
    {
    	driver.findElement(username).sendKeys("uname");
    	driver.findElement(password).sendKeys("passWord");
    	driver.findElement(loginbutton).click();
    	 return new DashBoardPagequicklaunchLinks(driver);
    }
    
    public boolean isDashBoardisDispaly()
    {
    	return driver.findElement(dashboard).isDisplayed();
    }
    public String dashBoardText() {
    	String txt=driver.findElement(dashboardtxt).getText();
		return txt;
    	
    }
}
