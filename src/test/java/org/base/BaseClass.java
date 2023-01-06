package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String title() {
		String title = driver.getTitle();
		System.out.println("title of webpage : " + title);
		return title;
	}
	
	public static void close()
	{
		driver.close();
	}

	public static void quit()
	{
		driver.quit();
	}
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentUrl);
		return currentUrl;

	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println("Text is : " + text);

	}

	public static void getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println("The entered input is : " + attribute);
	}

	public static void passsvalue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void elementCick(WebElement element) {
		element.click();
	}

	// actions class

	static Actions a;

	public static void mouseHover(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void doubleClic(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
		
	}

	public static void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
		

	}

	public static void dragAndDrop(WebElement src, WebElement dest) {
		a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();

	}

	public static void enter() {
		a = new Actions(driver);
		a.keyDown(Keys.ENTER);
		a.keyUp(Keys.ENTER);
	}

	// Robot class

	static Robot r;

	public static void selectall() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	
	
	public static void tab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	// alert
	static Alert al;

	public static void acceptalert() {

		al = driver.switchTo().alert();
		al.accept();
	}

	public static void dismissalert() {

		al = driver.switchTo().alert();
		al.dismiss();
	}

	// Screenshot
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\image\\" + filename + ".png");
		FileUtils.copyFile(src, dest);

	}

	// javascript executor

	public static void jssendkeys(String input, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + input + "')", element);
	}

	public static void jsclick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void jsgetattribute(String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object text = js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println("The entered text is : " + text);
	}

	public static void jshighlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background : yellow')", element);
	}

	public static void jsscrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void jsscrollup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	//frames
	public static void framebyid(String id)
	{
		driver.switchTo().frame(id);
	}
	
	public static void framebyWeref(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public static void framebyindex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	//drop down
	
	public static void selectbyIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	
	}
	
	public static void selectByVisibletext(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
		
	}
	
	public static void checkMultipe(WebElement element)
	{
		Select s=new Select(element);
		System.out.println("Whether the dropown is multiple ? : " + s.isMultiple());
	}
	
	public static void getOptionsfromdd(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement> alloptions = s.getOptions();
		System.out.println("the options in dropdown are: \n");
		for(int i=0; i<alloptions.size();i++)
		{
			WebElement option = alloptions.get(i);
			String text = option.getText();
			System.out.println(text);
		}
		
	}
	
	public static void allSelectedOptions(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement> allselectedopt = s.getAllSelectedOptions();
		System.out.println("\nSelected options from dropdow: \n");
		for(WebElement opt: allselectedopt)
		{
			System.out.println(opt.getText());
		}
	}
	
	
	//Deselect
	
	public static void deselectByInd(WebElement element, int ind)
	{
		Select s=new Select(element);
		s.deselectByIndex(ind);
		
	}
	
	public static void deselectByValue(WebElement element, String value)
	{
		Select s=new Select(element);
		s.deselectByValue(value);
		
	}
	public static void deselectByVtext(WebElement element, String text)
	{
		Select s=new Select(element);
		s.deselectByVisibleText(text);;
		
	}
	public static void deselectall(WebElement element)
	{
		Select s=new Select(element);
		s.deselectAll();
		
	}
	
	
	//Excel read
	public static String excelread(String filename,String sheetname, int row, int cell) throws IOException
	{
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int ctype = c.getCellType();
		String value;
		if(ctype==1)
		{
			 value = c.getStringCellValue();
		}
		else if(DateUtil.isCellDateFormatted(c))
		{
			Date dd = c.getDateCellValue();
			SimpleDateFormat d=new SimpleDateFormat("dd-MM-yy");
			 value = d.format(dd);
		}
		else
		{
			double d = c.getNumericCellValue();
			long l=(long) d;
			 value = String.valueOf(l);
			
		}
		return value;
	}
	
	
	//create excel/workbook
	public static void createExcel(String filename, String sheetname,int row, int cell, String data ) throws IOException {
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileOutputStream fos=new FileOutputStream(f);
		Workbook w= new XSSFWorkbook();
		Sheet s = w.createSheet(sheetname);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		w.write(fos);
		System.out.println("create excel program executed...............");
	}
	
	//create cell
	
	
	public static void createCell(String filename, String sheetname,int row, int cell, String data ) throws IOException {
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		System.out.println("create cell Program executed..........................");
		
	}
	//create new sheet in workbook
	public static void createSheet(String filename, String sheetname,int row, int cell, String data ) throws IOException {
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fis);
		Sheet s = w.createSheet(sheetname);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		System.out.println("create sheet Program executed..........................");
		
	}
	
	
	//create row
	public static void createRow(String filename, String sheetname,int row, int cell, String data ) throws IOException {
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetname);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		System.out.println("cerate row Program executed..........................");
		
	}
	
	//update cell
	
	
	public static void updateCell(String filename, String sheetname,int row, int cell, String olddata, String newdata ) throws IOException {
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(row);
	    Cell c = r.getCell(cell);
	    String value = c.getStringCellValue();
	    if(value.equals(olddata))
	    {
	    	c.setCellValue(newdata);
	    }
		
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		System.out.println("Update cell program execued..........");
	}		
		
	//get num of rows and cells and all data
	
	public static void getnumofrowcell(String filename, String sheetname) throws IOException
	{
		File f=new File("C:\\Users\\Smile\\eclipse-workspace\\FrameWorksample\\excel\\"+filename+".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s1 = w.getSheet("Sheet1");
	    int rowcount = s1.getPhysicalNumberOfRows();
		System.out.println("The toatal number of rows: " + rowcount);
		System.out.println("All datas present in excel file : \n");
		int numofclls=0;
		for(int i=0; i<rowcount; i++)
		{
			Row r = s1.getRow(i);
			int cellcount = r.getPhysicalNumberOfCells();
			numofclls=numofclls+cellcount;
			
			for(int j=0; j<cellcount;j++)
			{
				Cell c = r.getCell(j);
				System.out.println(c);
			}
		}
		System.out.println("Total number of cells are : " + numofclls);
	}
	// windows handling

	public static void windowUrl(String url)
	{
		driver.switchTo().window(url);
	}

	
	public static void windowTitle(String title)
	{
		driver.switchTo().window(title);
	}

	public static void windowId(String wid)
	{
		driver.switchTo().window(wid);
	}

	public static void getWindowHandle()
	{
		String parentid = driver.getWindowHandle();
		System.out.println("Parent id :" + parentid);
		Set<String> allwinid = driver.getWindowHandles();
		System.out.println("All window ids are :" + allwinid);
		for(String id: allwinid)
		{
			if(parentid!=id)
			{
				driver.switchTo().window(id);
			}
		}
	}
	
	
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void webdriverwait(WebElement element)
{
	WebDriverWait w= new WebDriverWait(driver, 10);
	w.until(ExpectedConditions.elementToBeClickable(element));
}
	
	public static void fluentwait(WebElement element)
	{
		FluentWait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).
				pollingEvery(Duration.ofMillis(150)).ignoring(TimeoutException.class);
		
		w.until(ExpectedConditions.elementToBeClickable(element));
	}

}



























