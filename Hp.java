package sel90days.workout.day1;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Hp {
public static void main(String[] args) throws InterruptedException {
		    //Launch the URL
	            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    ChromeDriver driver=new ChromeDriver();
		
		    driver.get("https://store.hp.com/in-en/default");
		    
		    //Maxmize the window
		    driver.manage().window().maximize();
		    
		    //Add an implicity wait
		    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		    
		    try
		    {
		    	driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
		    }
		    catch(Exception e)
		    {
		    	System.out.println("no popup appers");
		    }
		    
		    
		    //Mouseover on Laptops menu and click on Pavilion
		    Thread.sleep(6000);
		    Actions mouseover=new Actions(driver);
		    WebElement Laptops=driver.findElementByXPath("(//span[text()='Laptops'])[1]");
		 
		    mouseover.moveToElement(Laptops).build().perform();
		    
		    Thread.sleep(10000);
		    WebElement pavilion=driver.findElementByXPath("(//span[text()='Pavilion'])[1]");
		    pavilion.click();
		    
		    Thread.sleep(10000);
		    try
		    {
		    	driver.findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']").click();
		    }
		    catch(Exception e){
		    	
		    }
		    
		    //Under SHOPPING OPTIONS -> Processor -> Select Intel Core i7
	       
		    Thread.sleep(10000);
		    WebElement processor=driver.findElementByXPath("(//span[text()='Processor'])[2]");
		    processor.click();
		   
		    driver.findElementByXPath("(//span[text()='Intel Core i7'])").click();
		    
		    
		    try
		    {
		    	driver.findElementByXPath("(//button[@title='Close'])[1]").click();
		    }
		    catch(Exception e)
		    {
		    	
		    }
		    
		    //Hard Drive Capacity -> More than 1TB
		    Thread.sleep(10000);
		    WebElement cb1=driver.findElementByXPath("(//span[text()='More than 1 TB'])");
		    cb1.click();
		    
		    //Select Sort By:Price:Low to High

		    Thread.sleep(6000);
		    WebElement sortby=driver.findElementByXPath("(//select[@id='sorter'])[1]");
		    Select sb=new Select(sortby);
		    sb.selectByValue("price_asc");
	
		    //Print the First resulting Product Name and Price
		    System.out.println("First Resulting Product Name:"+driver.findElementByXPath("(//a[@class='product-item-link'])[1]").getText());
		    String firstprice=driver.findElementByXPath("(//span[@class='price'])[2]").getText();
		    String fp=firstprice.replaceAll("\\D","");
		    int ftPrice=Integer.parseInt(fp);
		    System.out.println("First Resulting MRP is:"+ftPrice);

		    //Click On Add To Cart
		    Thread.sleep(10000);
		    WebElement addToCart=driver.findElementByXPath("(//button[@type='submit'])[2]");
		    addToCart.click();
		    
		    //Click On Shoppong Cart Icon -> Click On View and Edit Cart
		    Thread.sleep(10000);
		    WebElement cartIcon=driver.findElementByXPath("(//a[@title='Shopping Cart'])");
		    cartIcon.click();
		    Thread.sleep(10000);
		    WebElement viewEdit=driver.findElementByXPath("(//span[text()='View and edit cart'])");
		    viewEdit.click();
		    
		    //Check the Shipping Option-> check availabilty at PinCode
		    driver.findElementByXPath("(//input[@name='pincode'])").sendKeys("610001");
		    Thread.sleep(6000);
		    WebElement check=driver.findElementByXPath("(//button[text()='check'])");
		    check.click();
		    
		    //Validate the order Total against the productprice
		    String productPrice=driver.findElementByXPath("(//span[@class='price'])[5]").getText();
		    String pp=productPrice.replaceAll("\\D","");
		    int pdtPrice=Integer.parseInt(pp);
		    System.out.println("ProductPrice:"+pdtPrice);
		    
		    String totalPrice=driver.findElementByXPath("(//span[@class='price'])[7]").getText();
		    String tp=productPrice.replaceAll("\\D","");
		    int totPrice=Integer.parseInt(tp);
		    System.out.println("TotalProductPrice:"+totPrice);
		    
		    if (pdtPrice == totPrice) {
		    	System.out.println("Product Price and Total Price are Same");
		    //click Checkout if order total and product price matches
		    	Thread.sleep(10000);
		    	WebElement checkOut=driver.findElementByXPath("(//span[text()='Proceed to Checkout'])[1]");
		    	checkOut.click();
				}
		    else
		    {
		    	System.out.println("Product Price and Total Price are not Same");
		    }
		    
		    //Click on Place order
		    Thread.sleep(10000);
		    WebElement placeOrder=driver.findElementByXPath("(//span[text()='Place Order'])[3]");
		    placeOrder.click();
		    
		    //Capture the error Message and print
		    Thread.sleep(6000);
		    String errorMessage=driver.findElementByXPath("(//div[@id='customer-email-error'])").getText();
		    System.out.println(errorMessage);
		    
		    //Close the browser
		    driver.close();











}
}
