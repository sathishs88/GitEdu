package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P003_IRCTC_Registration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		//open URL
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

		//maximize
		driver.manage().window().maximize();

		//implicitwait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement dropdown = driver.findElementById("userRegistrationForm:securityQ");
		Select securityQ = new Select(dropdown);
		securityQ.selectByIndex(1);
		securityQ.selectByValue("1");
		securityQ.selectByVisibleText("What is your favorite past-time?");
		
		List<WebElement> allOptions = securityQ.getOptions();
		for (WebElement eachoption : allOptions) {
			System.out.println(eachoption.getText());
			
		}

	}

}
