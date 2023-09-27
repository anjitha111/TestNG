package testngcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGText_Assignment {
	WebDriver driver;

	@BeforeMethod

	public void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)

	public void show_message() {
		WebElement show_msg = driver.findElement(By.xpath("//button[@id='button-one']"));
		String expected_text = "Show Message";
		String actual_text = show_msg.getText();
		Assert.assertEquals(actual_text, expected_text, "Text of the button is not matching");
	}

	@Test(priority=2)

	public void show_click() {
		WebElement show_msg = driver.findElement(By.xpath("//button[@id='button-one']"));
		WebElement text_box = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		text_box.sendKeys("Hello");
		show_msg.click();
		WebElement show_click_msg = driver.findElement(By.xpath("//div[@id='message-one']"));

		String actual_text = show_click_msg.getText();
		String input_text = "Hello";
		String result_msg = actual_text.substring(15);
		System.out.println(result_msg);
		Assert.assertEquals(input_text, result_msg, "Both messages are not matching.");

	}

	@Test(priority=3)

	public void checkbox_click() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement click_on_checkbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		click_on_checkbox.click();
		boolean b = click_on_checkbox.isSelected();
		Assert.assertTrue(b, "The checkbox is selected.");

	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
}
}
