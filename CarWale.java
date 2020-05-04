package sel90days.workout.day1;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CarWale {
	public static void main(String[] args) throws InterruptedException {
		//Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.get("https://www.carwale.com/");
		    
		//Maxmize the window
	    driver.manage().window().maximize();
		    
	    //Add an implicity wait
	    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    
	    
	    //Click on used
	    driver.findElementByXPath("//li[contains(@data-tabs,'usedCars')]").click();
	    
	    //Select City as Chennai
	    Thread.sleep(10000);
	    driver.findElementById("usedCarsList").sendKeys("Chennai");
	    driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
	    
	    //Select budget min(8L) and max(12L) and Click Search
	    driver.findElementByXPath("(//li[text()='8 Lakh'])[1]").click();
	    driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
	    driver.findElementByXPath("//button[@id='btnFindCar']").click();
	    
	    //Select cars with photos under only show Cars with
	    Thread.sleep(10000);
	    driver.findElementByXPath("//span[text()='Cars with Photos']").click();
	    
	    //Select Manufacture as "Hyndai" --> Creta
	    Thread.sleep(10000);
	    js.executeScript("window.scrollBy(0,250)");
	    driver.findElementByXPath("(//li[@data-manufacture-en='Hyundai']//span)[1]").click();
	    WebElement creta=driver.findElementByXPath("//span[text()='Creta']");
	    creta.click();
	    
	    //Select Fuel Type as Petrol
	    Thread.sleep(10000);
	    js.executeScript("window.scrollBy(0,250)");
	    driver.findElementByXPath("(//h3[@class='sub-values'])[6]").click();
	    driver.findElementByXPath("(//span[text()='Petrol'])[1]").click();
	    
	    //Select Best Matches as "KM:LOW TO HIGH"
	    Thread.sleep(10000);
	    WebElement bestMatches=driver.findElementByXPath("//select[@id='sort']");
	    Select lowTOHigh=new Select(bestMatches);
	    lowTOHigh.selectByVisibleText("KM: Low to High");
	    
	     //Validate the Cars are listed with KM:Low to High
	    List<WebElement> list=driver.findElementsByXPath("//tr[@data-role='click-tracking']/td[1]/span");
	    List<Integer> lowToHighList=new ArrayList<Integer>();
	    for (int i = 0; i < list.size(); i++) {
			int km=Integer.parseInt((list.get(i).getText()).replaceAll("\\D",""));
	    	System.out.println(km);
	    	lowToHighList.add(km);
	    	
		}
	    
	    List<Integer> lowToHighListSorted=new ArrayList<Integer>();
	    lowToHighListSorted.addAll(lowToHighList);
	    Collections.sort(lowToHighListSorted);
	     
	    if (lowToHighList.equals(lowToHighListSorted)) {
			System.out.println("Sorted successfully");
		} else {
			System.out.println("Sorted is not happened");
		}
	    System.out.println("Least Km ran Car's kms:"+lowToHighListSorted.get(0));
	    
	    
	    //Add the Least KM ran car to wishlist
	    Thread.sleep(10000);
	    for (int i = 0; i < lowToHighList.size(); i++) {
			if (lowToHighListSorted.get(0)==lowToHighList.get(i)) {
				
				WebElement wishList=driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])["+(i+1)+"]");
				js.executeScript("arguments[0].click();",wishList);
				break;
			}
		}
	    	
	    
	  //Go to WishListand Click on More Details
	    Thread.sleep(10000);
	    driver.findElementByXPath("//li[@data-role='click-tracking']").click();
	    Thread.sleep(10000);
	    driver.findElementByXPath("//a[text()='More details »']").click();
	    Set<String> windowSet=driver.getWindowHandles();
        List<String> windowList=new ArrayList<String>(windowSet);
        driver.switchTo().window(windowList.get(1));
	    
	    //Print all the details under overview in the same way as displayed in application
        Map<String,String> overview=new LinkedHashMap<String,String>();
        List<WebElement> key=driver.findElementsByXPath("//div[@id='overview']//div[@class='equal-width text-light-grey']");
        List<WebElement> value=driver.findElementsByXPath("//div[@id='overview']//div[@class='equal-width dark-text']");
        for (int i = 0; i < key.size(); i++) {
        	String keys=key.get(i).getText();
        	String values=value.get(i).getText();
        	overview.put(keys, values);
        	}
        for (Entry<String,String> i : overview.entrySet()) {
			System.out.println(i.getKey()+"---------"+i.getValue());
		}
	    
	    //Close the browser
        driver.quit();
	}
}
