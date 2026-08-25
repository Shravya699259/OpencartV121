package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void verifyLogin() {
		
		logger.info("*********starting TC002_LoginTest*******");
		try {
			
			//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("Entering login details");
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("verifying My account page");
		
		//MyAccount page
		MyAccountPage macc=new MyAccountPage(driver);
		if(macc.isMyAccountPageExists()) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			Assert.fail();
		}
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****test ended*****");
		
	}
	
	
}
