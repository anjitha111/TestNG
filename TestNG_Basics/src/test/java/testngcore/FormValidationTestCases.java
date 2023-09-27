package testngcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormValidationTestCases {
	WebDriver driver;

	@BeforeMethod
	public void launchsite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();

	}

	@Test(dependsOnMethods = "verifyLogo")
	public void averifySubmitText() { // Method name starts with a.
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		String actual_text = submit.getText();
		String expected_text = "Submit form";
		Assert.assertEquals(actual_text, expected_text, "Button text is not matching: Failed");

	}

	@Test(priority = -2, invocationCount = 3) // It won't execute the test cases given as enabled=false.We can give the execution priority order by setting priority.

	public void verifyText() {
		WebElement terms = driver.findElement(By.xpath("//label[@for='invalidCheck']"));
		String actual_text = terms.getText();
		String expected_text = "Agreee to terms and conditions";
		Assert.assertEquals(actual_text, expected_text, "Checkbox text is not matching: Failed");//Hard assert : It will throw an exception when it is failed.
		System.out.println("Print statement");
//We can give only one hard assert in a test case.
	}

	@Test(priority = 1, enabled = true) // To set the execution.We can give 
	// invocationCount is to repeat the same test case.
	public void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//a[@href='index.php']//img[@alt='logo']"));
		boolean b = logo.isDisplayed();
		// Assert.assertTrue(logo);
		Assert.assertTrue(b, "Logo is not displayed.");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
