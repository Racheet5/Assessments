package SeleniumUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumPOM {

	WebDriver driver;
	
	By username=By.name("user-name");
	By password=By.name("password");
	By login=By.id("login-button");
	By item1_cart=By.id("add-to-cart-sauce-labs-backpack");
	By add_to_cart=By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By check_out=By.id("checkout");
	By firstname=By.name("firstName");
	By lastname=By.name("lastName");
	By postal_code=By.name("postalCode");
	By continue_but=By.name("continue");
	By finish=By.name("finish");
	By back_home=By.name("back-to-products");
	By menu_click=By.id("react-burger-menu-btn");
	By logout=By.id("logout_sidebar_link");
	
	public SeleniumPOM(WebDriver driver1) {
		this.driver=driver1;
	}
	
	public void login(String user,String pass) throws InterruptedException {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(login).click();
	}
	
	public void adding_to_cart() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		driver.findElement(item1_cart).click();
		Thread.sleep(2000);
		driver.findElement(add_to_cart).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(check_out).click();
		Thread.sleep(2000);
	}
	
	public void address(String fname,String lname,String pincode) throws InterruptedException {
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(postal_code).sendKeys(pincode);
		Thread.sleep(2000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(continue_but).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(finish).click();
		Thread.sleep(3000);
		driver.findElement(back_home).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000);
		driver.findElement(menu_click).click();
		Thread.sleep(3000);
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(logout)).perform();
		driver.findElement(logout).click();
		Thread.sleep(3000);
	}
	
}
