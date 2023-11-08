package com.sandeepkaur.groupPracticeWork;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grouppractice.base.BaseClass;
import com.grouppractice.pages.LoginPage;

public class DummyTestWork extends BaseClass{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserCanLoginWithValidCredentials() {
//		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		Assert.assertEquals("My Account", "User not logged in");
		
	}
	
	@Test
	public void dummyTest1() {
		Assert.assertTrue(true);
		Assert.assertEquals("My Account", "User not logged in");
	}
	@Test
	public void testDummy1() {
		Assert.assertEquals("Account", "User not logged in");
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
