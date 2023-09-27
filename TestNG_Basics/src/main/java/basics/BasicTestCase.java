	package basics;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class BasicTestCase {
		WebDriver driver;
	
		@BeforeMethod
		public void launchmeesho() {
			WebDriverManager.chromedriver().setup();
			// WebDriverManager.edgedriver().setup();
			// WebDriver driver=new EdgeDriver();
			driver = new ChromeDriver();
			driver.get("https://www.meesho.com/");
			driver.manage().window().maximize();
		}
	
		@Test
		public void verifyTitle() {
			String actual_title = driver.getTitle();
			System.out.println(actual_title);
			String expected_title = "Online Shopping Site for Fashion, Electronics, Home & More | Meesho";
			// String expected_title="Anjitha";
			//Assert.assertEquals(actual_title, expected_title); // For validation
			// Assert.assertEquals(expected_title,actual_title); actual,expected is the correct order.Otherwise,the output message will be wrong.
			Assert.assertEquals(actual_title, expected_title,"This test case is failed");//This message will display with exceptions if the scenario got failed.
		}
	
		@Test
		public void verifyURL() {
			String actual_url = driver.getCurrentUrl();
			String expected_url = "https://www.meesho.com/";
			Assert.assertEquals(actual_url, expected_url);
		}
	
		@Test
		public void verifyCartOption() {
			WebElement cart_icon = driver.findElement(By.xpath("//span[contains(text(),'Cart')]"));
			boolean status = cart_icon.isDisplayed();
			// Assert.assertEquals(status,true);
			Assert.assertTrue(status, "Cart icon is displayed");// Check if the status is true or not.Same as above line
		}
		// Test cases execute based on the alphabetical order of the method names.
	}
