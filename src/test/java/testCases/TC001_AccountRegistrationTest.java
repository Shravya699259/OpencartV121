package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("******Starting TC001_AccountRegistrationTest.java********");
		
		try {
		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickRegister();

		logger.info("clicked on register");
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		
		logger.info("providing customer details");
		ap.setFirstName(randomString().toUpperCase());
		ap.setLastName(randomString().toUpperCase());
		ap.setEmail(randomString() + "@gmail.com");
		ap.setTelephone(randomNumber());
		String password=randomAlphaNumeric();
		ap.setPassword(password);
		ap.setPasswordconfirm(password);
		ap.clickAgree();
		ap.clickContinue();

		logger.info("validating expected message");
		String confirmMessage = ap.getConfirmationMessage();
		if(confirmMessage.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			logger.debug("debug logs....");
			Assert.fail();
		}
		
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("******Ended TC001_AccountRegistrationTest.java********");

	}

	

}
