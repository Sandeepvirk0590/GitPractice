package com.grouppractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grouppractice.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(css = "input[type='Submit']")
	WebElement loginBtn;

	@FindBy(css = ".alert-danger")
	WebElement alertBanner;
	
	@FindBy(xpath = "//a[text()='Forgotten Password']")
	WebElement forgotPasswordLink;

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	private void enterPassword(String password) {
		pwdInput.sendKeys(password);
	}

	public void SubmitLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		
	}

	public String getAlertText() {
		return alertBanner.getText();
	}

}
