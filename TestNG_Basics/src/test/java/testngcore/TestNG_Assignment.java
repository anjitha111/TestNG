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

public class TestNG_Assignment {

	WebDriver driver;

	@BeforeMethod

	public void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
	}

	@Test

	public void header() {
		WebElement name_header = driver.findElement(By.xpath("//table[@id='dtBasicExample']//thead//tr//th[1]"));
		String actual_text = name_header.getText();
		String expected_text = "Name";
		Assert.assertEquals(actual_text, expected_text, "Name header is not present in webtable.");

	}

	@Test
	public void header_pagination() {
		WebElement pagination_header = driver
				.findElement(By.xpath("//div[contains(text(),'Table with Pagination Example')]"));
		String actual_text = pagination_header.getText();
		String expected_text = "Table with Pagination Example";
		Assert.assertEquals(actual_text, expected_text,
				"Mentioned heading message is different from the expected one.");
	}

	@Test

	public void cedric_office() {
		WebElement cedric_kelley = driver.findElement(By.xpath("//table[@id='dtBasicExample']//tbody//tr[4]//td[3]"));
		String expected_text = "Edinburgh";
		String actual_text = cedric_kelley.getText();
		Assert.assertEquals(actual_text, expected_text, "Cedric Kelley's office is not Edinburgh.");

	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
