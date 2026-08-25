package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	@CacheLookup
	private WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@id='input-email']")
	@CacheLookup
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	@CacheLookup
	private WebElement txtTelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	@CacheLookup
	private WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	@CacheLookup
	private WebElement txtPasswordConfirm;
	@FindBy(xpath = "//input[@name='agree']")
	@CacheLookup
	private WebElement chkAgree;
	@FindBy(xpath = "//input[@value='Continue']")
	@CacheLookup
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	@CacheLookup
	private WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setPasswordconfirm(String passwordConfirm) {
		txtPasswordConfirm.sendKeys(passwordConfirm);
	}

	public void clickAgree() {
		chkAgree.click();
	}

	public void clickContinue() {
		btnContinue.click();
		
		//sol2
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver)
		//act.moveToElement(btnContinue).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btnContinue);
		
		//sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		
		
	}
	public String getConfirmationMessage() {
		try {
		return msgConfirmation.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
		
	}
}
