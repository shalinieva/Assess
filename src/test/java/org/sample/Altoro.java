package org.sample;

import org.base.BaseClass;
import org.junit.Assert;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pojo.LoginPojo;
import org.pojo.Signoff;
import org.pojo.Transferfund;
import org.pojo.ViewRt;
import org.pojo.Viewaccount;
import org.pojo.contact;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Altoro extends BaseClass{
	@BeforeClass
	public static void launcBrowser()
	{
		launchBrowser();
		maximizeWindow();
	}
	
	//tc1 to navigate the application and validate signin with correct credentials
	@org.testng.annotations.Parameters({"username2","password2","username1","password1"})
	@Test(enabled=false)
	public void tc1(String user, String pass, String user1, String pass1) {
		launchUrl("http://testfire.net/index.jsp");
		LoginPojo l=new LoginPojo();
		WebElement signin = l.getSignin();
		signin.click();
		WebElement username = l.getUsername();
		passsvalue(username, user);
		WebElement password= l.getPass();
		passsvalue(password, pass);
		WebElement login = l.getLogin();
		login.click();
		passsvalue(username, user1);
		
		passsvalue(password, pass1);
		login.click();
		String url = currentUrl();
		Assert.assertTrue("User is in valid login page", url.equals("http://testfire.net/bank/main.jsp"));
		System.out.println("assert pass..........");
//		Assert.assertTrue("User is in invalid login page", url.equals("htttp://testfire.net/bank/main.jsp"));
//		System.out.println("assert fail..........");
		}
	
	
	
	//tc2 to navigate account summary and asser available balance
	@org.testng.annotations.Parameters({"username1","password1"})
	@Test(enabled=false)
	public void tc2(String user, String pass) {
		launchUrl("http://testfire.net/index.jsp");
		LoginPojo l=new LoginPojo();
		WebElement signin = l.getSignin();
		signin.click();
		WebElement username = l.getUsername();
		passsvalue(username, user);
		WebElement password= l.getPass();
		passsvalue(password, pass);
		WebElement login = l.getLogin();
		login.click();
		Viewaccount v=new Viewaccount();
		WebElement accsummary = v.getAccsummary();
		accsummary.click();
		WebElement dd = driver.findElement(By.xpath("//select[@id='listAccounts']"));
		Select s=new Select(dd);
		s.selectByIndex(0);
		WebElement go = driver.findElement(By.id("btnGetAccount"));
		go.click();
		WebElement avbal = driver.findElement(By.xpath("//body[1]/table[2]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]"));
		String bal = avbal.getText();
		Assert.assertTrue(avbal.isDisplayed());
		System.out.println("assert pass..........");
		

	}
	//tc3 to validate transactio details message after fund transfer
	@org.testng.annotations.Parameters({"username1","password1"})
	@Test(enabled=false)
	public void tc3(String user, String pass) {
		launchUrl("http://testfire.net/index.jsp");
		LoginPojo l=new LoginPojo();
		WebElement signin = l.getSignin();
		signin.click();
		WebElement username = l.getUsername();
		passsvalue(username, user);
		WebElement password= l.getPass();
		passsvalue(password, pass);
		WebElement login = l.getLogin();
		login.click();
		Transferfund t=new Transferfund();
		WebElement tfund = t.getTfund();
		tfund.click();
		WebElement dd = driver.findElement(By.id("fromAccount"));
		Select s=new Select(dd);
		s.selectByIndex(0);
		WebElement dd1 = driver.findElement(By.id("toAccount"));
		Select s1=new Select(dd1);
		s1.selectByIndex(1);
		WebElement tamount = t.getTamount();
		passsvalue(tamount, "9876");
		WebElement transfer = t.getTransfer();
		transfer.click();
		WebElement message = driver.findElement(By.xpath("//span[contains(text(),'9876.0 was successfully transferred from Account 8')]"));
		String text = message.getText();
		org.testng.Assert.assertTrue(text.contains("9876"), "pass");
		System.out.println("assert pass..........");
//		org.testng.Assert.assertTrue(text.contains("Success"), "fail");
//		System.out.println("assert fail..........");

	}
	//tc4 to validate recent transactions
	@org.testng.annotations.Parameters({"username1","password1"})
	@Test(enabled=false)
	public void tc4(String user, String pass) {
		launchUrl("http://testfire.net/index.jsp");
		LoginPojo l=new LoginPojo();
		WebElement signin = l.getSignin();
		signin.click();
		WebElement username = l.getUsername();
		passsvalue(username, user);
		WebElement password= l.getPass();
		passsvalue(password, pass);
		WebElement login = l.getLogin();
		login.click();
		ViewRt v=new ViewRt();
		WebElement vrt = v.getVrt();
		vrt.click();
		WebElement firstrow = driver.findElement(By.xpath("//body[1]/table[2]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[2]/tbody[1]/tr[2]"));
		org.testng.Assert.assertTrue(firstrow.isDisplayed());
		System.out.println("assert pass..........");
}
	
	//tc5 to validate thank you message after submitting online form
	@Test(enabled=false)
	public void tc5() {
		launchUrl("http://testfire.net/index.jsp");
		contact c=new contact();
		c.getContactus().click();
		c.getOform().click();
		passsvalue(c.getName(), "test");
		passsvalue(c.getEmail(), "abc@gmail.com");
		passsvalue(c.getSub(), "test");
		c.getSubmit().click();
		WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'Thank')]"));
String text = msg.getText();
Assert.assertTrue("user in thankyou page", text.contains("Thank")); 
System.out.println("assert pass..........");

//Assert.assertTrue("user in thankyou page", text.contains("Thnk")); 
//System.out.println("assert fail..........");
	}
	
	
	//tc6 to validate user signed off
	@org.testng.annotations.Parameters({"username1","password1"})
	@Test
	public void tc6(String user, String pass) {
		launchUrl("http://testfire.net/index.jsp");
		LoginPojo l=new LoginPojo();
		WebElement signin = l.getSignin();
		signin.click();
		WebElement username = l.getUsername();
		passsvalue(username, user);
		WebElement password= l.getPass();
		passsvalue(password, pass);
		WebElement login = l.getLogin();
		login.click();
		Signoff s=new Signoff();
		s.getSignoff().click();
		String currentUrl = currentUrl();
		org.testng.Assert.assertTrue(currentUrl.contains("index"), "pass");
		System.out.println("assert pass..........");
//		org.testng.Assert.assertTrue(currentUrl.contains("Index"), "fail");
//		System.out.println("assert fail..........");
		
	}
}
