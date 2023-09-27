package testngcore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basics.DataProviderClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();// Globally declared soft assert.
	
@BeforeMethod
	public void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();
	}
/*@Test

/*public void verifyCheckbox()
{
	WebElement checkbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
	checkbox.click();
	WebElement checkbox_text=driver.findElement(By.xpath("//label[contains(text(),'Click on this check box')]"));
	String expected_text="Click on this checkbox";
	softassert.assertFalse(checkbox.isSelected(),"Checkbox is not selected by default.");
	softassert.assertEquals(checkbox_text.getText(), expected_text, "Checkbox text is not matching.");
	softassert.assertAll();//It will throw the exception.Mandatory
	System.out.println("Print statement");//It won't execute since it is given after assertAll.
}*/
//Hard assert : Asserts given after one failed result assert won't execute if it is a hard assert.
@Test(dataProvider="Meesho Products",dataProviderClass=DataProviderClass.class)
public void verifyProductSearch(String product)

{
	System.out.println(product);
	driver.get("https://www.meesho.com");
	WebElement search_box=driver.findElement(By.xpath("//input[@type='text']"));
	//search_box.sendKeys("iPhone 15");
	search_box.sendKeys(product);
	search_box.sendKeys(Keys.ENTER);
}

@Test(dataProvider="FB Credentials",dataProviderClass=DataProviderClass.class)

public void fblogin(String emailid,String pass_word,String expected_profile)
{
	driver.get("https://www.facebook.com/");
	WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
	username.sendKeys(emailid);
	password.sendKeys(pass_word);
	System.out.println("Name of the user is "+expected_profile);
	driver.close();
}
}