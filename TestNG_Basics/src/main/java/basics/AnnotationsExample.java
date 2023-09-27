package basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsExample {

	@BeforeSuite
	public void beforesuite()//Method should be given if Before Suite is given.
	{
		System.out.println("Inside @Before Suite");
	}
	@BeforeTest
	public void beforetest1()
	{
		System.out.println("Inside @Before Test");
		
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Inside @Before Class");
		
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Inside @Before Method 1");
		
	}
	@BeforeMethod
	public void beforemethod2()
	{
		System.out.println("Inside @Before Method 2");
		
	}
	@Test
	public void test1()
	{
		System.out.println("Inside @Test case 1");
		
	}
	@Test
	public void test2()
	{
		System.out.println("Inside @Test case 2");
		
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("Inside @After Method");
		
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("Inside @After Class");
		
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("Inside @After Test");
		
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("Inside @After Suite");
		
	}
	
}




/*before suite
beforetest
before class,  before method
@test
@aftermethod,  @afterclass
@aftertest @after suite*/