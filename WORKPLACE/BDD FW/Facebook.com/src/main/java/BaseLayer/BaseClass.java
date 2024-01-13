package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass()
	{
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\ConfigurationLayer\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop= new Properties();
			prop.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void initialization(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("incognito")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognoto");
			 driver= new ChromeDriver(opt);
		}
		else if(browsername.equalsIgnoreCase("headless")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			 driver= new ChromeDriver(opt);
	}
		else {
			System.out.println("please enter valid browsername");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		String a=prop.getProperty("url");
		driver.get(a);
	}
	
	
	
	
	
	
	
	
	
	
}
