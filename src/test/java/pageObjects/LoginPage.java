package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	@CacheLookup
	private WebElement txtEmailAddress;
	@FindBy(xpath = "//input[@id='input-password']")
	@CacheLookup
	private WebElement txtPassword;
	@FindBy(xpath = "//input[@value='Login']")
	@CacheLookup
	private WebElement btnLogin;

	public void setEmailAddress(String emailAddress) {
		txtEmailAddress.sendKeys(emailAddress);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
}
