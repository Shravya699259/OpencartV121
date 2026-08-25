package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {


	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class,groups="Datadriven") //getting data provider from different class
	public void verifyLoginDDT(String email,String password,String exp_res) {
		
		logger.info("*******starting TC003_LoginDDT*********");
		//Home page
		try {
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	logger.info("Entering login details");
	
	//login page
	LoginPage lp=new LoginPage(driver);
	lp.setEmailAddress(email);
	lp.setPassword(password);
	lp.clickLogin();
	
	logger.info("verifying My account page");
	
	//MyAccount page
	MyAccountPage macc=new MyAccountPage(driver);
	boolean act_res=macc.isMyAccountPageExists();
	
	//Data is valid - login success- test pass - logout
	//data is valid - login unsuccess- test failed 
	
	if(exp_res.equalsIgnoreCase("valid")) {
		if(act_res==true) {
			
			macc.clickLogout();
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		    
		
	}
	//Data is invalid - login is success- test failed - logout
	//data is invalid - login unsucess - test passed
	
	if(exp_res.equalsIgnoreCase("invalid")) {
		if(act_res==true) {
			
			
			macc.clickLogout();
			
			Assert.assertTrue(false);
		}
		else
			Assert.assertTrue(true);
	}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		finally {
		logger.info("******ending test*******");
		}
		
	
	}
}
