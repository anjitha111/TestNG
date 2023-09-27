package basics;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="Meesho Products")
	public Object[][] dataProviderMeesho() 
	{
		return new Object [][] {{"shoe"},{"watch"},{"phone"}};//It returns object arrays.[][] indicates 2 dimensional (Eg: Login and password).Here array is single dimesnional,but we have declared it as 2 dimensional.
	}

	@DataProvider(name="FB Credentials")
	public Object[][] dataProviderFacebook() 
	{
		return new Object[][]{{"neha123@gmail.com","nehaa123","Neha"},{"ayaansh@gmail.com","abcde123","Ayaansh"},{"manu321","abcde3214","Manu"}};//We are giving login for each user.
	}

}
