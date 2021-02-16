package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pageObjects.LoginPage;
import com.pageObjects.myInfoPage;
import com.qa.Factory.DriverFactory;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class updateMyInfoSteps {
	
	private myInfoPage mip= new myInfoPage(DriverFactory.getDriver());
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	
	@Given("User is in login page")
	public void user_is_in_login_page(String uname, String passWord) {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		lp.doLogin(uname, passWord);
	}
	   
	@Given("User navigates to Personal details page")
	public void user_navigates_to_personal_details_page() {
	
	Assert.assertTrue(mip.verifyheadertext());
	   
	}

	@When("User fills data from given sheet {string} and row number {int}")
	public void user_fills_data_from_given_sheet_and_row_number(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader= new ExcelReader();
		List<Map<String,String>> testdata=
				reader.getData("C:\\Users\\Kummari Bhikshapathi\\Desktop\\Personal Details", sheetName);
		String fn=testdata.get(rowNumber).get("FirstName");
		String ln=testdata.get(rowNumber).get("LastName");
		String natio=testdata.get(rowNumber).get("Nationality");
		String ms=testdata.get(rowNumber).get("MaritalStatus");
		String birt=testdata.get(rowNumber).get("DateofBirth");
		String nick=testdata.get(rowNumber).get("NickName");
		mip.updateDetails(fn, ln, natio, ms, birt, nick);
		
	}

	@Then("User cllicks save button")
	public void user_cllicks_save_button() {
	   mip.hitOnSave();
	}

	@Then("verify for Edit button")
	public void verify_for_edit_button() {
		Assert.assertTrue(mip.verifyEdit());
	}

}
