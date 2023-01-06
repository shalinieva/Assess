package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//font[normalize-space()='Sign In']")
	private WebElement signin;

	public WebElement getSignin() {
		return signin;
	}
	
	@FindBy(id="uid")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}
	@FindBy(id="passw")
	private WebElement pass;

	public WebElement getPass() {
		return pass;
	}
	@FindAll( {
		@FindBy(css="input[value='Login']"),
		@FindBy(xpath="//input[@name='btnSubmit']")
	})
	
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}
	

	
}
