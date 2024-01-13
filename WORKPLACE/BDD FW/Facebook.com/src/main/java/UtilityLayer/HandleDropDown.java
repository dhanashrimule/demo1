package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass{
public static void selectByVisibleText(WebElement wb,String value)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	WebElement waitWb=wait.until(ExpectedConditions.visibilityOf(wb));
	Select sel= new Select(waitWb);
	sel.selectByVisibleText(value);
}









}
