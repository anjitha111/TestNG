package testngassignmentsnew;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertAssignment {

	WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod

	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();
	}

	@Test

	public void submit() {
		WebElement submit_button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit_button.click();

		List<String> expected_list = new ArrayList<String>();
		expected_list.add("Please enter First name.");
		expected_list.add("Please enter Last name.");
		expected_list.add("Please choose a username.");
		expected_list.add("Please provide a valid city.");
		expected_list.add("Please provide a valid state.");
		expected_list.add("Please provide a valid zip.");
		expected_list.add("You must agree before submitting.");

		List<WebElement> error_messages = driver.findElements(By.xpath("//div[@class='invalid-feedback']"));
		List<String> actual_list = new ArrayList<String>();
		for (WebElement element : error_messages) {
			actual_list.add(element.getText());
		}

		for (int i = 0; i < actual_list.size(); i++) {
			softassert.assertEquals(actual_list.get(i), expected_list.get(i),
					"Actual and expected error messages are different.");
		}
		softassert.assertAll();
	}

}
