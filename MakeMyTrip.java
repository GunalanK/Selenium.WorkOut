package sel90days.workout.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
				//Launch the URL
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
			        driver.get("http://www.makemytrip.com/");
			        
			        //Maxmize the window
			        driver.manage().window().maximize();
			        
			        //Add an implicity wait
			        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			        
			        //Click Hotels
			        driver.findElementByXPath("(//li[@class='menu_Hotels']//span)[2]").click();
			        driver.findElementByXPath("//input[@id='city']").click();
			        
			        //Enter city as Goa
			        Thread.sleep(6000);
			        WebElement cityname=driver.findElementByXPath("(//input[contains(@type,'text')])[2]");
			        cityname.sendKeys("Goa");
			        //Choose Goa,India
			        Thread.sleep(6000);
			        WebElement goa=driver.findElementByXPath("//div[@class='flexOne']");
			        goa.click();
			        
			        //Enter Check in date as Next Month 15th(May 15)
			        driver.findElementByXPath("//input[@id='checkin']").click();
			        driver.findElementByXPath("(//div[@class='DayPicker-Day'])[26]").click();
			        
			        //Check out as Start day+5
			        driver.findElementByXPath("(//div[@class='DayPicker-Week'])[9]/div[3]").click();
			        
			        //Click on Rooms and Guests and click 2 Adults and 1 Children(age 12),Click Apply button
			        driver.findElementByXPath("//input[@id='guest']").click();
			        driver.findElementByXPath("//ul[contains(@data-cy,'adultCount')]/li[2]").click();
			        driver.findElementByXPath("//li[contains(@data-cy,'children-1')]").click();
			        driver.findElementByXPath("//button[contains(@data-cy,'submitGuest')]").click();
			        
			        //Click search button
			        driver.findElementByXPath("//button[contains(@data-cy,'submit')]").click();
			        
			        //Close the Map
			        driver.findElementByXPath("//a[@class='mapCont']").click();
			        driver.findElementByXPath("//span[@class='mapClose']").click();
			        
			        //Select Locality as Baga
			        driver.findElementByXPath("(//span[@class='checkmarkOuter'])[9]").click();
			        
			        //Select 5 Stars in star category under select filters
			        Thread.sleep(6000);
			        WebElement Fivestar=driver.findElementByXPath("(//span[@class='checkmarkOuter'])[13]");
			        Fivestar.click();
			        
			        //Click on the first resulting hotel and go to the new Window
			        driver.findElementByXPath("(//div[@class='listingRowOuter']//div)[6]").click();
			        Set<String> windowSet=driver.getWindowHandles();
			        List<String> windowList=new ArrayList<String>(windowSet);
			        driver.switchTo().window(windowList.get(1));
			        
			        //Print the Hotel Name
			        System.out.println("HOTEL NAME IS:"+driver.findElementByXPath("//div[@class='flexOne']//h1").getText());
			        
			        //Click the more options Link and select 9 month plan and close
			        driver.findElementByXPath("(//div[@class='hotelHeaderRight']//span)[8]").click();
			        driver.findElementByXPath("(//td[@class='textRight']//span)[3]").click();
			        driver.findElementByXPath("(//span[@class='close'])").click();
			        
			        //CLick on BOOK THIS NOW
			        driver.findElementById("detpg_book_combo_btn").click();
			      
			        //Print the TOTAL PAYMENT WINDOW
			        driver.findElementByXPath("//span[@class='close']").click();
			        System.out.println(driver.findElementById("revpg_total_payable_amt").getText());
			        
			        //Close the browser
			        driver.quit();
	}

}
