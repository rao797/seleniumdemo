package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pageobjects.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Steps {
 public WebDriver driver;
 public LoginPage lp;
	@Given("User Launch the Chrome browser")
	public void user_launch_the_chrome_browser() {
		//System.setProperty("WebDriver.chrome.driver", System.getProperty("C:\\Users\\krupa\\eclipse-workspace\\BDD_cucumber\\Drivers\\chromedriver.exe"));
		//driver = new ChromeDriver(); 
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	lp.setUserName(email);
	lp.setPassword(password);
	}
	

	@When("Click on Login")
	public void click_on_login() {
	    lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	 if (driver.getPageSource().contains("Login was unsuccessful.")) {  
	driver.close();
	Assert.assertTrue(false);
		 }else {
			 Assert.assertEquals(title, driver.getTitle());
		 }
	}
	@When("User click on Log out Link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}



}
