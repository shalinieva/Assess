package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transferfund extends BaseClass{
public Transferfund() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="MenuHyperLink3")
private WebElement tfund;

public WebElement getTfund() {
	return tfund;
}
@FindBy(id="transferAmount")
private WebElement tamount;

public WebElement getTamount() {
	return tamount;
}
@FindBy(id="transfer")
private WebElement transfer;

public WebElement getTransfer() {
	return transfer;
}

}
