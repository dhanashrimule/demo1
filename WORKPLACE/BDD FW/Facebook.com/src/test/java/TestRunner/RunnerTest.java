package TestRunner;

import org.junit.runner.RunWith;

import BaseLayer.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"AllFeatureFiles/register.feature"},
		glue= {"Steps"},
		dryRun=false,
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
		
public class RunnerTest {
	

}
