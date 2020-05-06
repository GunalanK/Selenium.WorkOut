package sel90days.workout.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Pepperfry {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		    //Launch the URL //Go to PEPPERFRY.COM
	        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      System.setProperty("webdriver.chrome.silentOutput","true");
	        ChromeDriver driver=new ChromeDriver();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
		    driver.get("https://www.pepperfry.com/");
		    
		    //Maxmize the window
		    driver.manage().window().maximize();
		    
		    //Add an implicity wait
		    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		    
		    Thread.sleep(10000);
		    try {
		    	driver.findElementByXPath("(//span[@class='wewidgeticon we_close icon-large'])").click();
		    }catch(Exception e){}
		    try
		    {
		    	driver.findElementByXPath("(//a[@class='popup-close'])[5]").click();
		    }
		    catch(Exception e)
		    {
		    	
		    }
		    
		    //Mouseover on Furniture and click Office Chairs under Chairs
		    Thread.sleep(10000);
		    Actions mouseover=new Actions(driver);
		    mouseover.moveToElement(driver.findElementByXPath("(//a[text()='Furniture'])[1]")).perform();
		    driver.findElementByXPath("(//a[text()='Office Chairs'])").click();
		    
		    //Click Exceutive Chairs
		    driver.findElementByXPath("(//h5[text()='Executive Chairs'])").click();
		    
		    //Change the minimum height as 50 in under dimensions
		    Thread.sleep(10000);
		    WebElement height=driver.findElementByXPath("(//input[@type='number'])[1]");
		    height.clear();
		    height.sendKeys("50",Keys.ENTER);
		    
		    //Add "Poise executive Chair in Black Colour" chair to WishList
		    Thread.sleep(10000);
		    WebElement addToWl=driver.findElementByXPath("(//a[@id='clip_wishlist_'])[2]");
		    addToWl.click();
		    		    
		    //Mouseover on Houseware and Click pressure Cookers under CookWare
		    mouseover.moveToElement(driver.findElementByXPath("(//a[text()='Homeware'])[1]")).perform();
		    driver.findElementByXPath("(//a[text()='Pressure Cookers'])").click();
		    
		    //Select Prestige as Brand
		    driver.findElementByXPath("//label[@for='brandsnamePrestige']").click();
		    
		    //Select Capacity as 1-3 Ltr
		    Thread.sleep(10000);
		    WebElement capacity=driver.findElementByXPath("//label[@for='capacity_db1_Ltr_-_3_Ltr']");
		    capacity.click();
		    
		    //Add "Nakshatra Cute Mettalic Red Aluminium Cooker 2 Ltr" to WishList
		    Thread.sleep(10000);
		    driver.findElementByXPath("//a[@data-productname='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']").click();
		   
		    
		    //Verify the number of items in WIshlist 
		    Thread.sleep(10000);
			if((driver.findElementByXPath("//a[@data-tooltip='Wishlist']/following::span[@class='count_alert'][1]").getText()).equalsIgnoreCase("2")) { 

				System.out.println("All the items which are selected is added to Wishlist"); 

			} else { 

				System.out.println("All the items which are selected is not added to Wishlist");

			}


			

			// Navigating to Wishlist 

			driver.findElementByXPath("//a[@data-tooltip='Wishlist']").click(); 

			Thread.sleep(3000); 


	
			// Move Pressure Cooker only to Cart from Wishlist

			driver.findElementByXPath("//a[@data-tooltip='Compact view']").click();
			Thread.sleep(10000);
			driver.findElementByXPath("//a[text()='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr By...']/following::a[@class='addtocart_icon']").click(); 
			Thread.sleep(2000); 
			driver.findElementById("mini-usercart-tab").click(); 
			
			//Check for the availability for PinCode 600128
			Thread.sleep(6000);
			driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600128");
			driver.findElementByXPath("//a[@class='check_available']").click();
			
			//Click Proceed to Pay Securely
			Thread.sleep(6000);
			driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
			
			//Click Proceed to Pay
			driver.findElementByXPath("(//a[text()='PLACE ORDER'])[1]").click();
			
			//Capture the Screenshot of the item under Order item
			Thread.sleep(6000);
			driver.findElementByXPath("//span[text()='ORDER SUMMARY']").click();
			File screenshotAs =driver.getScreenshotAs(OutputType.FILE);
			File dst=new File("./snaps/pepperfry.png");
			FileUtils.copyFile(screenshotAs, dst);
			
			//Close the Browser
			driver.close();
			}}
			
