package testngassignmentsnew;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTextAssignment {

	WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod

	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
	}

	@Test

	public void submit() {
		WebElement text_field = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		text_field.sendKeys("Hello Everyone");
		String input_text = "Hello Everyone";

		WebElement show_msg_button = driver.findElement(By.xpath("//button[@id='button-one']"));

		String expected_text = "Show Message";
		String actual_text = show_msg_button.getText();
		softassert.assertEquals(actual_text, expected_text, "Actual text is different from expected text.");

		show_msg_button.click();
		WebElement result_text = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actual_result_msg = result_text.getText();
		//boolean b = actual_result_msg.contains(text_field.getText());// First way to do the result message verification.
		//softassert.assertTrue(b, "Displayed text is different from the expected one.");

		String result_msg = actual_result_msg.substring(15);//2nd way
		System.out.println(result_msg);

		softassert.assertEquals(input_text, result_msg, "Both texts are not matching.");

		softassert.assertAll();
	}
}