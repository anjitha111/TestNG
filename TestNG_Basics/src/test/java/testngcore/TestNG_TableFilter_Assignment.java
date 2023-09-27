package testngcore;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_TableFilter_Assignment {

	WebDriver driver;

	@BeforeMethod

	public void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/table-filter.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void search() {

		List<String> expected_list = new ArrayList<String>();
		expected_list.add("Brenden Wagner");
		expected_list.add("Software Engineer");
		expected_list.add("San Francisco");
		expected_list.add("29");
		expected_list.add("2012/06/07");
		expected_list.add("$206,850");

		WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));
		searchbox.sendKeys("Brenden Wagner");

		List<WebElement> search_list = driver.findElements(By.xpath("//table[@id='example']//tr//td"));
		List<String> actual_list = new ArrayList<String>();
		for (WebElement element : search_list) {
			actual_list.add(element.getText());
		}
		for (int i = 0; i < actual_list.size(); i++) {
			Assert.assertEquals(actual_list.get(i), expected_list.get(i));
		}
		// Assert.assertTrue(actual_list.equals(expected_list),"Details displayed are
		// not matching with the expected result.");
	}

	@Test(priority = 3)
	public void searchlists() {
		WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));
		searchbox.sendKeys("Brenden Wagner");
		WebElement displayed_text = driver.findElement(By.xpath("//div[@class='dataTables_info']"));
		String expected_text = "Showing 1 to 1 of 1 entries (filtered from 57 total entries)";
		String actual_text = displayed_text.getText();
		Assert.assertEquals(actual_text, expected_text, "Both texts are not similar.");

	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
}
}
