package sel90days.workout.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {
	
public static void main(String[] args) throws InterruptedException {
	//Launch the URL
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput","true");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.snapdeal.com/");
	    
	//Maxmize the window
    driver.manage().window().maximize();
	    
    //Add an implicity wait
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    
    Actions mouseover=new Actions(driver);
    
    //Mouse Over on Toys,Kids'Fashion & More and click on Toys 
    mouseover.moveToElement(driver.findElementByLinkText("Toys, Kids' Fashion & more")).perform();
    Thread.sleep(6000);
    WebElement toys=driver.findElementByXPath("//span[text()='Toys']");
    toys.click();
    
    //Click Educational Toys in toys & Games
    driver.findElementByXPath("//div[text()='Educational Toys']").click();
    
    //Click Customer Rating 4 Star and up 
    Thread.sleep(10000);
    WebElement star=driver.findElementByXPath("//label[@for='avgRating-4.0']");
    star.click();
    
    //Click the offer as 40-50
    Thread.sleep(6000);
    WebElement discount=driver.findElementByXPath("(//div[contains(@class,'sdCheckbox filters-list ')])[8]");
    discount.click();
    
    //Check the availability for the Pincode
    driver.findElementByXPath("(//input[@class='sd-input'])[2]").sendKeys("600119");
    Thread.sleep(10000);
    WebElement pinCode=driver.findElementByXPath("//button[@class='pincode-check']");
    pinCode.click();
    
    //Click the quickview of the first product
    mouseover.moveToElement(driver.findElementByXPath("((//section[@data-dpwlbl='Product Grid'])[1]/div)[1]")).perform();
    Thread.sleep(10000);
    WebElement click=driver.findElementByXPath("(//div[@class='clearfix row-disc']/div)[1]");
    click.click();
    
    //Click on view details
    driver.findElementByXPath("//a[@class=' btn btn-theme-secondary prodDetailBtn']").click();
    
    //Capture the price of the product and delivery price
    driver.findElementByXPath("//span[text()='add to cart']").click();
    Thread.sleep(10000);
    WebElement cart=driver.findElementByXPath("//div[text()='View Cart']");
    cart.click();
    Thread.sleep(10000);
    String price=driver.findElementByXPath("//span[@class='item-price']").getText();
    int toyPrice=Integer.parseInt(price.replaceAll("\\D",""));
    System.out.println("Price Of the toy:"+toyPrice);
    
    Thread.sleep(10000);
    String delivery=driver.findElementByXPath("//span[@class='avail-charges']").getText();
    int deliveryPrice=Integer.parseInt(delivery.replaceAll("\\D",""));
    System.out.println("Delivery Price of Toy:"+deliveryPrice);
    

    String total=driver.findElementByXPath("(//span[@class='item-subtotal-black'])[1]").getText();
    int totalPrice=Integer.parseInt(total.replaceAll("\\D",""));
    System.out.println("Pay Amount of Toy:"+totalPrice);
    
    if ((toyPrice+deliveryPrice)==totalPrice) {
    	System.out.println("Sum of Subtotal price and Delivery Price is equal to Pay Amount ");
		
	} else {
		System.out.println("Sum of Subtotal price and Delivery Price is not equal to Pay Amount ");
	}
    
    driver.findElementByXPath("(//i[@class='sd-icon sd-icon-delete-sign'])[2]").click();
    
    //Search for Sanitizer
    driver.findElementByXPath("//input[@id='inputValEnter']").sendKeys("Sanitizer",Keys.ENTER);
    /*driver.findElementByXPath("(//span[@class='search-text'])[1]").click();*/
    
    //Click on Product "Bio Ayurveda Neem Power Hand Sanitizer"
    Thread.sleep(10000);
    WebElement select=driver.findElementByXPath("//p[text()='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']");
    select.click();
    
    Set<String> windowSet=driver.getWindowHandles();
    List<String> windowList=new ArrayList<String>(windowSet);
    driver.switchTo().window(windowList.get(1));
    
    //Capture the price and Delivery Charge
    String priceOfSanitizer=driver.findElementByXPath("//span[@class='payBlkBig']").getText();
    int price1=Integer.parseInt(priceOfSanitizer.replaceAll("\\D",""));
    System.out.println("Pay Amount of Sanitizer:"+price1);
    
    String deliveryPriceOfSanitizer=driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
    int deliveryprice1=Integer.parseInt(deliveryPriceOfSanitizer.replaceAll("\\D",""));
    System.out.println("Delivery Charge of Sanitizer:"+deliveryprice1);
    
    //Click on Cart
    Thread.sleep(10000);
    WebElement addtocart=driver.findElementByXPath("(//span[text()='ADD TO CART'])[1]");
    addtocart.click();
    
    //Click on Cart
    Thread.sleep(10000);
    WebElement select2=driver.findElementByClassName("cartQuantity");
    select2.click();
    
    //Validate the Proceed To Pay matches the total amount of both the products
    Thread.sleep(10000);
    String toy=driver.findElementByXPath("(//span[@class='item-subtotal-black'])[1]").getText();
    int toySubtotal=Integer.parseInt(toy.replaceAll("\\D",""));
    System.out.println("total Amount of Toy:"+toySubtotal);
    
    String sanitizer=driver.findElementByXPath("(//span[@class='item-subtotal-black'])[4]").getText();
    int sanitizerSubtotal=Integer.parseInt(sanitizer.replaceAll("\\D",""));
    System.out.println("Total Amount of Sanitizer:"+sanitizerSubtotal);
    
    String st=driver.findElementByXPath("(//span[@class='rfloat'])").getText();
    int subTotal=Integer.parseInt(st.replaceAll("\\D",""));
    System.out.println("Proceed To Pay:"+subTotal);
    
    String dc=driver.findElementByXPath("(//span[@class='rfloat '])").getText();
    int deiveryCharge=Integer.parseInt(dc.replaceAll("\\D",""));
    System.out.println("Total Delivery Charge :"+deiveryCharge);
    
    if ((toySubtotal+sanitizerSubtotal)==(subTotal+deiveryCharge)) {
    	System.out.println("Proceed to pay  is equal to total amount of both the products");	
		
	} else {
		System.out.println("Proceed to pay is not equal to total amount of both the products");

	}
    
    //Close all the Windows
    driver.quit();
    
    
    
    
}
}
