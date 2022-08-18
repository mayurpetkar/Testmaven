package CrossBrowserTest.CrossBrowserTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class CrossBrowser
{
	

		WebDriver driver;

		/**
		 * This function will execute before each Test tag in testng.xml
		 * @param browser
		 * @throws Exception
		 */
		
		
		@BeforeTest
		
		@Parameters("browser")
		
		public void setup(String browser) throws Exception{
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				DriverManagerType FIREFOX = DriverManagerType.FIREFOX;
				WebDriverManager.getInstance(FIREFOX).setup();

				//System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
			//	System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
				//create chrome instance
				DriverManagerType Chrome = DriverManagerType.CHROME;
				WebDriverManager.getInstance(Chrome).setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){
						//set path to Edge.exe
					//	System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
						//create Edge instance
						DriverManagerType edge = DriverManagerType.EDGE;
						WebDriverManager.getInstance(edge).setup();
						driver = new EdgeDriver();
						driver.manage().window().maximize();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void testParameterWithXML() throws InterruptedException{
			
			driver.get("http://demo.guru99.com/V4/");
			
			//Find user name
			WebElement userName = driver.findElement(By.name("uid"));
			//Fill user name
			userName.sendKeys("guru99");
			//Find password
			WebElement password = driver.findElement(By.name("password"));
			//Fill password
			password.sendKeys("guru99");
		}
	}

