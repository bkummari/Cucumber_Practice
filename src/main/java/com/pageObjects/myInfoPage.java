package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.Factory.DriverFactory;

public class myInfoPage {
	
	private WebDriver driver;
	//1  maintain By locator
	private By fname=By.id("personal_txtEmpFirstName");
	private By lname=By.id("personal_txtEmpLastName");
	private By nation=By.id("personal_cmbNation");
	private By marital=By.id("personal_cmbMarital");
	private By dob=By.id("personal_DOB");
	private By nickNmae=By.id("personal_txtEmpNickName");
	private By headerTxt=By.xpath("//div[@class='head']/h1[text()='Personal Details']");
	private By save=By.id("btnSave");
	private By edit=By.xpath("//p/input[@id='btnSave'][@value='Edit']");
	
	
	
	//2 maintain constrctor
		public myInfoPage(WebDriver driver)
		{
			this.driver=driver;
		}
	// 3. create page actions
		public boolean verifyheadertext()
		{   
			return driver.findElement(headerTxt).isDisplayed();
		}
		public void updateDetails(String firstname,String lastname,String nat,String marsta,String dtob,String nname)
		{
			driver.findElement(edit).click();
			driver.findElement(fname).sendKeys(firstname);
			driver.findElement(lname).sendKeys(lastname);
			Select select1 = new Select(driver.findElement(nation));
			select1.selectByVisibleText(nat);
			Select select2 = new Select(driver.findElement(marital));
			select2.selectByVisibleText(marsta);
			driver.findElement(dob).sendKeys(dtob);
			driver.findElement(nickNmae).sendKeys(nname);
		}
		public void hitOnSave()
		{
			driver.findElement(save).click();
		}
		public boolean verifyEdit()
		{
			return driver.findElement(edit).isDisplayed();
		}
		
}
