package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signoff extends BaseClass{
public Signoff() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//font[contains(text(),'Sign')]")
private WebElement signoff;
public WebElement getSignoff() {
	return signoff;
}

}
