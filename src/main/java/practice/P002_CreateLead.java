package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class P002_CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();*/
		
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		//dc.setCapability("IGNORE_ZOOM_SETTING", true);
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		dc.setCapability("EnableNativeEvents", true);
		
		InternetExplorerDriver driver = new InternetExplorerDriver(dc);
		
		
		
		driver.get("http://leaftaps.com/control/main");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByLinkText("createLeadForm_companyName").sendKeys("Test");
		driver.findElementByLinkText("createLeadForm_firstName").sendKeys("Firstname");
		driver.findElementById("createLeadForm_lastName").sendKeys("LastName");
		driver.findElementByClassName("smallSubmit").click();
		driver.close();
		
	}

}
