package Steps;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RegisterSteps {
	WebDriver driver;

	@Given("User is on register page")
	public void user_is_on_register_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(2000);
	}

	@When("user enter {string},{string},{string} and {string}")
	public void user_enter_and(String firstname, String lastname, String phone, String email) {
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
	}

	@When("user enter {string},{string},{string}, {string} and {string}")
	public void user_enter_and(String address, String city, String state, String postalcode, String country) {
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalcode);
		driver.findElement(By.name("country")).sendKeys(country);
	}

	@When("user enter {string}, {string},{string} and click on submit button")
	public void user_enter_and_click_on_submit_button(String username, String password, String confirmpassword) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
		driver.findElement(By.name("submit")).click();
	}

	@Then("user is on register success page")
	public void user_is_on_register_success_page() {
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl.contains("register_sucess"), true);
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] f = ts.getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			scenario.attach(f, "image/png", date + scenario.getName());
		} else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] f = ts.getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			scenario.attach(f, "image/png", date + scenario.getName());
		}

	}

}
