package Steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import PageLayer.RegisterPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterPageSteps extends BaseClass {
	RegisterPage registerPage;

	@Given("user open {string} browser")
	public void user_open_browser(String browsername) {
		BaseClass.initialization(browsername);
	}

	@When("user is on register page")
	public void user_is_on_register_page() {
		String URl = prop.getProperty("url");
		driver.get(URl);
	}

	@When("user enter valid {string}, {string}, {string} and {string}")
	public void user_enter_valid_and(String Fname, String Lname, String Email, String Pass) {
		registerPage = new RegisterPage();
		registerPage.enterFunctionality(Fname, Lname, Email, Pass);
	}

	@When("user select DOB as {string} ,{string},{string} and user select gender as {string}")
	public void user_select_dob_as_and_user_select_gender_as(String Date, String Month, String Year, String Gender) {
		registerPage.selectFunctionality(Date, Month, Year, Gender);
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			scenario.attach(f, "image/png", date + scenario.getName());

		} else {
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			scenario.attach(f, "image/png", date + scenario.getName());
		}

	}


}
