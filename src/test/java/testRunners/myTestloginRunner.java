package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/features/LeaveRequest.feature"},
		glue= {"stepDefinations","myhooks"},
		//tags="@Smoke or @Regression",
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"json:target/MyReports/report.json",
				"junit:target/MyReports/report.xml"
				},
		publish=true,//to get the reports link in console with that link we can get reports in browser
		monochrome=true//it gives the proper alignment of console output
		//dryRun=true//it means give the information about any thing we missed in step defn
		)
public class myTestloginRunner {

}
