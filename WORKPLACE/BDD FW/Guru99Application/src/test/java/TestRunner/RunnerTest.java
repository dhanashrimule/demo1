package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"AllFeatures/Register.feature"},
		glue= {"Steps"},
				plugin=
			{
				"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
			dryRun=true
			)
public class RunnerTest {

}
