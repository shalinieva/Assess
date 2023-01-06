package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Viewaccount extends BaseClass {
public Viewaccount() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="MenuHyperLink1")
private WebElement accsummary;

public WebElement getAccsummary() {
	return accsummary;
}

}
