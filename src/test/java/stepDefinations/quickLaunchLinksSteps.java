package stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pageObjects.DashBoardPagequicklaunchLinks;
import com.pageObjects.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class quickLaunchLinksSteps {
	
	private LoginPage lp= new LoginPage(DriverFactory.getDriver());
	private DashBoardPagequicklaunchLinks dashBoardpage;
	
	@Given("User has already logged in")
	public void user_has_already_logged_in(DataTable dataTable) {
		List<Map<String,String>> credList=dataTable.asMaps();
		String un=credList.get(0).get("username");
		String pw=credList.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		dashBoardpage=lp.doLogin(un, pw);
	}

	@When("User gets page title")
	public void user_gets_page_title() {
		String acttitle=dashBoardpage.getDashboardTitle();
		System.out.println("This is the title:"+ acttitle);
	}

	@Then("The Page Title should Be {string}")
	public void the_page_title_should_be(String title) {
		String acttitle=dashBoardpage.getDashboardTitle();
		Assert.assertEquals(acttitle, title);
	}

	@Then("User gets  Quick Launch links")
	public void user_gets_quick_launch_links(DataTable qLlist) {
		List<String> expli=qLlist.asList();
		System.out.println("This is the expected list:"+ expli);
		List<String> actli=dashBoardpage.getQuickLaunchLinkstext();
		System.out.println("This is the actual list:"+ actli);
		
		Assert.assertTrue(actli.containsAll(expli));
		
	    
	}

	@Then("The links count should be {int}")
	public void the_links_count_should_be(Integer count) {
		
		Assert.assertTrue(dashBoardpage.getQuickLaunchLinksCount()==count);
	}

}
