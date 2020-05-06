package sel90days.workout.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrom.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Actions mouseover=new Actions(driver);
		WebElement shopbycategory=driver.findElementByXPath("//a[text()=' Shop by Category ']");
		mouseover.moveToElement(shopbycategory).perform();
		WebElement fgom=driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		mouseover.moveToElement(fgom).perform();
		WebElement rice=driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
		mouseover.moveToElement(rice).perform();
		driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
		Thread.sleep(10000);
	    WebElement bbroyal=driver.findElementByXPath("(//span[text()='bb Royal'])[1]");
	    		bbroyal.click();
		
		Thread.sleep(6000);
	     WebElement s1=driver.findElementByXPath("(//a[text()='Ponni Boiled Rice - Super Premium']/following::div)[2]");
	     s1.click();
		 
		driver.findElementByXPath("(((//a[text()='Ponni Boiled Rice - Super Premium']/following::div)[2])//a)[2]").click();
		
		String MRP=driver.findElementByXPath("(((//a[text()='Ponni Boiled Rice - Super Premium']/following::div)[2]/following::h4)[1]//span)[3]").getText();
		String priceofrice=MRP.replaceAll("\\D","");
        double ricemrp=Double.parseDouble(priceofrice);
        System.out.println("Rice price is:"+ricemrp);
        
        driver.findElementByXPath("(((//a[text()='Ponni Boiled Rice - Super Premium']/following::div)[2])/following::button)[1]").click();
        
/*        System.out.println(driver.findElementByLinkText("Successfully added Ponni Boiled Rice - Super Premium 5 kg to the basket").getText());*/
        driver.findElementByXPath("(//a[text()='Continue'])[1]").click();
        driver.findElementByXPath("(//div[@class='input-group'])[1]/input").sendKeys("Dal",Keys.ENTER);
        driver.findElementByXPath("((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu'])[1]/following::button)[1]").click();
        driver.findElementByXPath("(((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu'])[1]/following::button)[1]/following::a)[4]").click();
        WebElement quantity=driver.findElementByXPath("((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu'])[1]/following::input)[1]");
        quantity.clear(); 
        quantity.sendKeys("2");
        
        String MRP1=driver.findElementByXPath("(((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu'])[1]/following::h4[1])/span)[2]").getText();
    	String priceofdal=MRP1.replaceAll("\\D","");
        double dalmrp=Double.parseDouble(priceofdal);
        System.out.println("Dal price is:"+dalmrp);
        
        driver.findElementByXPath("(((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu'])[1]/following::button)[2])").click();
        driver.findElementByXPath("//button[@class='toast-close-button']").click();
        
        WebElement mybasket=driver.findElementByXPath("//span[@class='basket-content']");
		mouseover.moveToElement(mybasket).perform();
		
		Thread.sleep(6000);
		
		String riceString = driver.findElementByXPath("(//div[@qa='pcsMB'])[1]").getText(); 
		String riceQtyStr = riceString.substring(0, 1);  
		double riceQtyNumber = Double.parseDouble(riceQtyStr); 
		System.out.println("Quantity of Rice: " + riceQtyNumber);
		 
		String dalQtyStr = driver.findElementByXPath("(//div[@qa='pcsMB'])[2]").getText();
		dalQtyStr = dalQtyStr.substring(0, 1);
		double dalQtyNumber = Double.parseDouble(dalQtyStr); 
		System.out.println("Quantity of Dal: " + dalQtyNumber);

		String ricePriceCart = driver.findElementByXPath("(//span[@qa='priceMB'])[1]").getText();
		double riceTotal = Double.parseDouble(ricePriceCart); 
		riceTotal = riceTotal * riceQtyNumber;

		String dalPriceCart = driver.findElementByXPath("(//span[@qa='priceMB'])[2]").getText();
		double dalTotal = Double.parseDouble(dalPriceCart); 
		dalTotal = dalTotal * dalQtyNumber;

		String subTotalStr = driver.findElementByXPath("//span[@qa='subTotalMB']").getText();
		double subTotalNum = Double.parseDouble(subTotalStr); 
		
		Thread.sleep(3000);

		if (subTotalNum == riceTotal + dalTotal) {
			System.out.println("Sub Total is correct: " + subTotalNum);
		} else {
			System.out.println("Sub Total is wrong: " + subTotalNum);
		}
	driver.close();
		
	
		
		

	}

}
