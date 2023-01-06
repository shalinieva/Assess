package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewRt extends BaseClass {
	public ViewRt() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='MenuHyperLink2']")
	private WebElement vrt;

	public WebElement getVrt() {
		return vrt;
	}
	

}
