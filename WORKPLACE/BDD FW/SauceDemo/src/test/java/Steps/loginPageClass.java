package Steps;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class loginPageClass {
	public static WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://www.saucedemo.com/");
	}

	@When("user eneter valid username and password and click on login button")
	public void user_eneter_valid_username_and_password_and_click_on_login_button() {
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
	}

	@Then("user is on Home page and user validate home page by using url link")
	public void user_is_on_home_page_and_user_validate_home_page_by_using_url_link() {
		String actUrl = driver.getCurrentUrl();
		boolean a = actUrl.contains("inventory");
		Assert.assertEquals(a, true);
	}

	@Then("user add product to cart and click on card user click on checkout button")
	public void user_add_product_to_cart_and_click_on_card_user_click_on_checkout_button() throws InterruptedException {
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		Thread.sleep(2000);

	}

	@Then("user fill the information firstname,lastname and zip code and click on continue button")
	public void user_fill_the_information_firstname_lastname_and_zip_code_and_click_on_continue_button()
			throws InterruptedException {
		driver.findElement(By.name("firstName")).sendKeys("Dhanashri");
		driver.findElement(By.name("lastName")).sendKeys("mule");
		driver.findElement(By.name("postalCode")).sendKeys("413517");
		Thread.sleep(2000);
		driver.findElement(By.name("continue")).click();
		Thread.sleep(2000);
	}

	@Then("user click on finish button")
	public void user_click_on_finish_button() {
		driver.findElement(By.name("finish")).click();
	}

	@Then("user validate order placed")
	public void user_validate_order_placed() {
		WebElement text = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		String val = text.getAttribute("value");
		Assert.assertEquals(val.contains("Thank you"), true);
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] f = ts.getScreenshotAs(OutputType.BYTES);
			SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_Hhmmss");
			String date = simple.format(new Date());
			scenario.attach(f, "image/png", date + scenario.getName());
		} else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] f = ts.getScreenshotAs(OutputType.BYTES);
			SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_Hhmmss");
			String date = simple.format(new Date());
			scenario.attach(f, "image/png", date + scenario.getName());
		}
	}

}
