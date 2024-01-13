package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass{
	public static void sendKeys(WebElement wb,String value)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
      	wait.until(ExpectedConditions.visibilityOf(wb)).sendKeys(value);
	}
      public static void selectGender(List<WebElement>ls,String value) {
    	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
    	 List<WebElement>waitWb= wait.until(ExpectedConditions.visibilityOfAllElements(ls));
    	 for(WebElement abc:waitWb)
    	 {
    		 String a=abc.getText();
    		 if(a.equalsIgnoreCase(value)) {
    			 abc.click();
    		 }
    	 }
    	 
      }
}
