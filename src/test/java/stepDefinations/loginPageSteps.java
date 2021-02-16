package stepDefinations;

import org.junit.Assert;

import com.pageObjects.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// adding comments
public class loginPageSteps {
	
	private LoginPage lp= new LoginPage(DriverFactory.getDriver());
	
	@Given("User is in login oage")
	public void user_is_in_login_oage() {
	    DriverFactory.getDriver().get("URL: https://opensource-demo.orangehrmlive.com/");
	}

	@When("Users gets the login page title")
	public void users_gets_the_login_page_title() {
	    String acttitle=lp.getTitle();
	    System.out.println("The title of the page is:"+acttitle);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		String acttitle=lp.getTitle();
	    System.out.println("The title of the page is:"+acttitle);
	    Assert.assertEquals(acttitle, title);
	}


	@Then("Forgot password link should display")
	public void forgot_password_link_should_display() {
		Assert.assertTrue(lp.isForgotPasswordLinkExist());
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String uname) {
	    lp.enterUserName(uname);
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String pwd) {
		lp.enterPassword(pwd);
	    
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   lp.hitOnLogin();
	}

	@Then("User Navigate to Dash board page")
	public void user_navigate_to_dash_board_page() {
		Assert.assertTrue(lp.isDashBoardisDispaly());
	}

	@Then("Dashboard Header text will be dispaly")
	public void dashboard_header_text_will_be_dispaly() {
	   
      String txtValue=lp.dashBoardText();
      System.out.println("Dashboard Header text is: "+txtValue);
		
	}
	

	
	
	
}
