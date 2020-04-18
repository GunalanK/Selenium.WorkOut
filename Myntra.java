package sel90days.workout.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.myntra.com/");
        
        //Maxmize the window
        driver.manage().window().maximize();
        
        //Add an implicity wait
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        //Mouse over on WOMEN (Actions -> moveToElement) 
        Actions mouseover=new Actions(driver);
        WebElement targetwomen=driver.findElementByXPath("(//a[@class='desktop-main'])[2]");
        mouseover.moveToElement(targetwomen).perform();
        
        //Click Jackets & Coats
        driver.findElementByLinkText("Jackets & Coats").click();
        
        //Find the total count of item(top) -> getText -> String
        String str=driver.findElementByClassName("title-count").getText();
        String text=str.replaceAll("\\D","");
        int Total=Integer.parseInt(text);
        System.out.println(Total);
        
        
        //Validate the sum of categories count matches
        List<WebElement> categoryCount=driver.findElementsByClassName("categories-num");
         int categoriesTotal=0;
         for (int i = 0; i < categoryCount.size(); i++) {
        	 String str1=categoryCount.get(i).getText();
        	 categoriesTotal=categoriesTotal+Integer.parseInt(str1.replaceAll("\\D",""));
        	 
		} 
    	   if (Total==categoriesTotal) {
    		   System.out.println("Total count is"+Total+"\n"+  "Categories count is"+categoriesTotal+"\n"+
    	   " categories Count and total count is matched");
			
		} else {
                   System.out.println("Total count is"+Total+ "\n"+ "Categories count is"+categoriesTotal+ "\n" +
		"categories Count and total count is not matched");
		}
    	   
    	 //Check Coats
    	  WebElement checkCoats=driver.findElementByXPath("(//div[@class=\"common-checkboxIndicator\"])[2]");
    	  checkCoats.click();
    	  
    	  //Click +more option under brand
    	  driver.findElementByClassName("brand-more").click();
    	  
    	  //Type MANGO and click checkbox
    	  driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
    	  driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div").click();
    	  
    	  //Close the pop-up x
          driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']/span").click();
          
          //Confirm all the Coats are of brand MANGO
    	  Thread.sleep(5000);
		  List<WebElement> MangoCoats=driver.findElementsByXPath("//h3[@class='product-brand']");
		  int count = 0;
	      for (WebElement i : MangoCoats) {
	
	    	if (i.getText().equalsIgnoreCase("MANGO")) {
	    		count++;
			}
			}
	      if (count==MangoCoats.size()) {
	    	
			System.out.println("All are Mango Brands");
		  }else
		  {
			System.out.println("All are not Mango Brands");
		  }
	      
	      //Sort by Better Discounnt
	      mouseover.moveToElement(driver.findElementByClassName("sort-sortBy")).build().perform();
	      mouseover.moveToElement(driver.findElementByXPath("(//ul[@class='sort-list']//label)[3]")).click().perform();
	      
	      //Find the price of first displayed item
	      Thread.sleep(5000);
	      List<WebElement> itemprice=driver.findElementsByClassName("product-discountedPrice");
	      String firstitemprice=itemprice.get(0).getText();
	      System.out.println("firstitemprice is :RS."+firstitemprice);
	    
	      //Mouseover on size of the first item
	      mouseover.moveToElement(driver.findElementByXPath("//li[@class='product-base']")).build().perform();
	    
	      //Click on WishList Now
	      driver.findElementByXPath("((//li[@class='product-base'])[1]//span)[12]").click();
	    
	      //Close the Browser
	      driver.close();
	    
	}
	}


