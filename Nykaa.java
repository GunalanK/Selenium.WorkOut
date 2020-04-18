package sel90days.workout.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		        //Launch the URL
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
		        driver.get("http://www.nykaa.com/");
		        
		        //Maxmize the window
		        driver.manage().window().maximize();
		        
		        //Add an implicity wait
		        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		        
		        //MouseOver on Brands and MouseOver on Popular
		        Actions mouseover=new Actions(driver);
		        mouseover.moveToElement(driver.findElementByXPath("//li[@class='menu-dropdown-icon']")).build().perform();
		        mouseover.moveToElement(driver.findElementByXPath("((//div[@class='BrandsCategoryHeading'])/a)[1]")).build().perform();
		        
		        //Click L'Oreal Paris
		        driver.findElementByXPath("(//div[@id='brandCont_Popular']//img)[5]").click();
		        
		        //Go to the newly opened window and check the title contains L'Oreal Paris
		    	Set<String> winset=driver.getWindowHandles();
				List<String> winList=new ArrayList<String>(winset);
				
				//Get the Title of the New window
				Thread.sleep(6000);
				String Title1=driver.switchTo().window(winList.get(1)).getTitle();
				
				//Check the title contains L'Oreal Paris
				if (Title1.contains("L'Oreal Paris")) {
					System.out.println("Current page is L'Oreal Paris Page");
				} else {
					System.out.println("Current page is not a L'Oreal Paris Page");
				}
				
				//Click sort by and select customer top rated
				driver.findElementByXPath("(//span[text()='popularity'])[1]").click();
				driver.findElementByXPath("(//span[text()='customer top rated'])[1]").click();
				
				//Click Category and click Shampoo
				Thread.sleep(6000);
				WebElement cat=driver.findElementByXPath("(//div[@class='clearfix'])[2]");
				cat.click();
				driver.findElementByXPath("(//div[@class='control-box'])[36]").click();
				
				//Check whether the filter is appiled with shampoo
				String Text=driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']/li[1]").getText();
				if (Text.contains("Shampoo")) {
					System.out.println("All are Shampoo");
				} else {
					System.out.println("All are not shampoo");

				}
				
				//click on L'Oreal paris colour protect shampoo
				WebElement select=driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[4]");
				select.click();
				
				//Go to the new window and select size as 175ml
				Set<String> winset1=driver.getWindowHandles();
				List<String> winList1=new ArrayList<String>(winset1);
				driver.switchTo().window(winList1.get(2));
				driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
				
				//Print the MRP of the product
				System.out.println("MRP is"+driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText());
				
				//Click on ADD to BAG
				driver.findElementByXPath("(//div[@class='pull-left'])[1]").click();
				
				//Go to shopping bag
				driver.findElementByXPath("//div[@class='AddBagIcon']").click();
				
				//Print the grand total amount
				System.out.println("GRAND TOTAL IS:"+driver.findElementByXPath("(//div[@class='table-row ']/div)[2]").getText());
				
				//Click proceed
				driver.findElementByXPath("//div[@class='second-col']/button").click();
				
				//Click on Continue as Guest
				driver.findElementByXPath("((//div[@class='login-benefits-info'][2])/following::button)[3]").click();
				
				//Print the warning message(delay in shipment)
				System.out.println("Warning Message:"+driver.findElementByXPath("//div[@class='message']").getText());
				
				//Close all windows
				driver.quit();
				
	}

}
