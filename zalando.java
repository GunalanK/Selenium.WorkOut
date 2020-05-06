package sel90days.workout.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class zalando {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions mouseOver=new Actions(driver);
		driver.get("https://www.zalando.com/");
		//Get the Alert text and print it
		Thread.sleep(10000);
	    Alert alert=driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
		    
		//Maxmize the window
	    driver.manage().window().maximize();
		    
	    //Add an implicity wait
	    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
	    
	    //Close the Alert box and click on Zalando.uk
	    
	    driver.findElementByXPath("//a[text()='Zalando.uk']").click();
	    
	    
	   Thread.sleep(10000);
	    try
	    {
	    	Thread.sleep(10000);
	    driver.findElementByXPath("//button[@id='uc-btn-accept-banner']").click();
	    }
	    catch(Exception e) {}
	    //Click Women--> Clothing and click Coat
	    Thread.sleep(10000);
	    driver.findElementByXPath("(//span[text()='Women'])[2]").click();
	    Thread.sleep(10000);
	    mouseOver.moveToElement(driver.findElementByXPath("(//span[text()='Clothing'])")).perform();
	    driver.findElementByXPath("(//span[text()='Coats'])").click();
		
	    // Choose Material as cotton (100%) and Length as thigh-length
	    Thread.sleep(10000);
		driver.findElementByXPath("(//span[text()='Material'])").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//span[text()='cotton (100%)']").click();
		driver.findElementByXPath("(//button[text()='Save'])").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//span[text()='Length']").click();
		driver.findElementByXPath("//span[text()='thigh-length']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
	    
	    // Click on Q/S designed by MANTEL - Parka coat
		WebElement coat=driver.findElementByXPath("//div[text()='MANTEL - Parka - navy']");
		js.executeScript("arguments[0].click();",coat);
		
		// Check the availability for Color as Olive and Size as 'M'
		driver.findElementByXPath("(//img[@alt='olive'])[2]").click();
		
		
	   // If the previous preference is not available, check availability for Color Navy and Size 'M'
		if ((driver.findElementByXPath("//h2[text()='Out of stock']").getText()).equalsIgnoreCase("Out of stock")) {
			Thread.sleep(10000);
			driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
			driver.findElementByXPath("//span[text()='Choose your size']").click();
			driver.findElementByXPath("//span[text()='M']").click();
		}
		else
		{
			driver.findElementByXPath("//span[text()='Choose your size']").click();
			driver.findElementByXPath("//span[text()='M']").click();
		}
		
		// Add to bag only if Standard Delivery is free
		if ((driver.findElementByXPath("(//span[text()='Free'])[1]").getText()).equalsIgnoreCase("Free")) {
			driver.findElementByXPath("//span[text()='Add to bag']").click();
		}
		
		// Mouse over on Your Bag and Click on "Go to Bag"
		mouseOver.moveToElement(driver.findElementByXPath("//span[text()='Your bag']")).perform();
		driver.findElementByXPath("//div[text()='Go to bag']").click();
		
		// Capture the Estimated Deliver Date and print
		System.out.println("Estimated Deliver Date:"+driver.findElementByXPath("//div[@data-id='delivery-estimation']/span").getText());
		
		// Mouse over on FREE DELIVERY & RETURNS*, get the tool tip text and print
		Thread.sleep(10000);
		mouseOver.moveToElement(driver.findElementByXPath("//a[text()='Free delivery & returns*']")).perform();
		System.out.println(driver.findElementByXPath("//a[text()='Free delivery & returns*']/parent::span").getAttribute("title"));
		driver.findElementByXPath("//a[text()='Free delivery & returns*']").click();
		
		// Click on Start chat in the Start chat and go to the new window
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElementByXPath("//span[text()='Start chat']").click();
		Set<String> windowSet=driver.getWindowHandles();
        List<String> windowList=new ArrayList<String>(windowSet);
        driver.switchTo().window(windowList.get(1));
		
		// Enter you first name and a dummy email and click Start Chat
        driver.findElementByXPath("//input[@id='prechat_customer_name_id']").sendKeys("Gunalan");
        driver.findElementByXPath("//input[@id='prechat_customer_email_id']").sendKeys("guguud@gmail.com");
        driver.findElementByXPath("//span[text()='Start Chat']").click();
        
		// Type Hi, click Send and print thr reply message and close the chat window
        driver.findElementByXPath("//textarea[@id='liveAgentChatTextArea']").sendKeys("Hi");
        driver.findElementByXPath("//button[text()='Send']").click();
        js.executeScript("window.scrollBy(0,250)");
        System.out.println("Reply Message:"+driver.findElementByXPath("//span[text()='Hi there! How can I help you?']").getText());
        driver.close();
        
	}

}
