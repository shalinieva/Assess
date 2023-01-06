package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contact extends BaseClass {
public contact() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@id='HyperLink3']")
private WebElement contactus;

public WebElement getContactus() {
	return contactus;
}
@FindBy(xpath="//a[normalize-space()='online form']")
private WebElement oform;

public WebElement getOform() {
	return oform;
}
@FindBy(xpath="//input[@name='name']")
private WebElement name;

public WebElement getName() {
	return name;
}
@FindBy(xpath="//input[@name='email_addr']")
private WebElement email;

public WebElement getEmail() {
	return email;
}
@FindBy(xpath="//input[@name='subject']")
private WebElement sub;

public WebElement getSub() {
	return sub;
}
@FindBy(xpath="//textarea[@name='comments']")
private WebElement comment;

public WebElement getComment() {
	return comment;
}
@FindBy(xpath="//input[@name='submit']")
private WebElement submit;

public WebElement getSubmit() {
	return submit;
}

}
