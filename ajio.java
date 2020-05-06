package sel90days.workout.day1;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ajio {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.get("https://www.ajio.com/shop/sale");
		    
		//Maxmize the window
	    driver.manage().window().maximize();
		    
	    //Add an implicity wait
	    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	    // Enter Bags in the Search field and Select Bags in Women Handbags
		driver.findElementByXPath("//input[@name='searchVal']").sendKeys("Bags");
		driver.findElementByXPath("//span[text()='Bags in ']//following-sibling::span[text()='Women Handbags']").click();
		
	   // Click on five grid and Select SORT BY as "What's New"
		driver.findElementByXPath("//div[@class='five-grid']").click();
		Thread.sleep(6000);
		WebElement sort=driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		Select sortby=new Select(sort);
		sortby.selectByVisibleText("What's New");
		
	   // Enter Price Range Min as 2500 and Max as 5000
		Thread.sleep(6000);
		driver.findElementByXPath("//span[text()='price']").click();
		js.executeScript("window.scrollBy(0,250)");
		driver.findElementByXPath("//input[@id='minPrice']").sendKeys("2500");
		driver.findElementByXPath("//input[@id='maxPrice']").sendKeys("5000");
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		
		// Click on the product "Puma Ferrari LS Shoulder Bag"
		WebElement product=driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']");
		js.executeScript("arguments[0].click();",product);
		Set<String> windowSet=driver.getWindowHandles();
        List<String> windowList=new ArrayList<String>(windowSet);
        driver.switchTo().window(windowList.get(1));
        
		// Verify the Coupon code for the price above 2690 is applicable for your product,
        //if applicable the get the Coupon Code and Calculate the discount price for the coupon
        Thread.sleep(6000);
        String price=driver.findElementByXPath("//div[@class='prod-sp']").getText();
        int productPrice=Integer.parseInt(price.replaceAll("\\D",""));
        System.out.println("Product price:"+productPrice);
        if (productPrice>2690) {
        	
			System.out.println("Coupen is applicable for Your selected product");
			String couponCode=driver.findElementByXPath("//div[@class='promo-title']/br").getText();	
		}
        else
        {
        	System.out.println("Coupen is not applicable for your selected product");
        }
        String discountedPrice=driver.findElementByXPath("//div[@class='promo-discounted-price']/span").getText();
        int  disPrice=Integer.parseInt(discountedPrice.replaceAll("\\D",""));
        System.out.println("Discounted price of the Product:"+disPrice);
        int couponDiscount=productPrice-disPrice;
        System.out.println("The amount Saved by counpon code is:"+couponDiscount);
        
        // Check the availability of the product for pincode 635001, print the expected delivery date if it is available
		driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']").click();
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("635001");
		driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
		String ed=driver.findElementByXPath("(//ul[@class='edd-message-success-details']/li)[1]").getText();
		if (ed.contains("Expected Delivery")) {
			System.out.println("Estimated delivery:"+driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']").getText());
		} else {
			System.out.println("PIN Code is unavailable");
		}
		
        // Click on Other Informations under Product Details and Print the Customer Care address, phone and email
		driver.findElementByXPath("//div[text()='Other information']").click();
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Customer care address:"+driver.findElementByXPath("(//span[@class='other-info'])[6]").getText());
		
		// Click on ADD TO BAG and then GO TO BAG
		js.executeScript("window.scrollBy(0,-1000)");
		driver.findElementByXPath("(//span[text()='ADD TO BAG'])").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//div[@class='btn-cart']").click();
		
		// Check the Order Total before apply coupon
		String t=driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
		System.out.println("Order Total before Apply coupon:"+t);
		
		// Enter Coupon Code and Click Apply
		driver.findElementByXPath(" //input[@id='couponCodeInput']").sendKeys("EPIC");
		driver.findElementByXPath("//button[text()='Apply']").click();
		
		// Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated in Product details
		String disAmount=driver.findElementByXPath("(//section[@id='couponDiscount']/span)[2]").getText();
		String da=disAmount.replaceAll("[^0-9.]","");
		String da1=da.substring(1);
		double priceSaving=Double.parseDouble(da1);
		int priceSaving1=(int)Math.round(priceSaving);
	    System.out.println(priceSaving1);
	    if (priceSaving1==couponDiscount) {
			System.out.println("Discount prices are mathed");
		}
	    else
	    {
	    	System.out.println("Discount prices are not mathed");
	    }
	    
		// Click on Delete and Delete the item from Bag
	    Thread.sleep(6000);
	    driver.findElementByXPath("//div[text()='Delete']").click();
	    driver.findElementByXPath("//div[text()='DELETE']").click();
	    
	    //Close all the browsers
	    driver.quit();
	}

}
