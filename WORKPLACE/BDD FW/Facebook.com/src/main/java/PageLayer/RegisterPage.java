package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.Wait;

public class RegisterPage extends BaseClass{
	@FindBy(name = "firstname")
	private WebElement fname;

	@FindBy(name = "lastname")
	private WebElement lname;

	@FindBy(name = "reg_email__")
	private WebElement email;

	@FindBy(name = "reg_passwd__")
	private WebElement password;

	@FindBy(name = "birthday_day")
	private WebElement day;

	@FindBy(name = "birthday_month")
	private WebElement month;

	@FindBy(name = "birthday_year")
	private WebElement year;

	@FindBys(@FindBy(xpath = "//label[@class='_58mt']"))
	private List<WebElement> gender;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterFunctionality(String Fname,String Lname,String Email,String Pass)
	{
		Wait.sendKeys(fname, Fname);
		Wait.sendKeys(lname, Lname);
		Wait.sendKeys(email, Email);
		Wait.sendKeys(password, Pass);
	}
	public void selectFunctionality(String Day,String Month,String Year,String Gender)
	{
		HandleDropDown.selectByVisibleText(day, Day);
		HandleDropDown.selectByVisibleText(month, Month);
		HandleDropDown.selectByVisibleText(year, Year);
		Wait.selectGender(gender, Gender);
	}
	
	
	
	
	
	
	
	
	
	
	
}
