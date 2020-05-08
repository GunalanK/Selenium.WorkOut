package sel90days.workout.day1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class azure {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions mouseover=new Actions(driver);
		driver.get("https://azure.microsoft.com/en-in/");
		
		    
		//Maxmize the window
	    driver.manage().window().maximize();
		    
	    //Add an implicity wait
	    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    
		//Click on Pricing
		driver.findElementByXPath("//a[text()='Pricing']").click();
		
	    // Click on Pricing Calculator
		driver.findElementByXPath("(//ul[@class='linkList initial-list']//a[@data-bi-area='undefined'])[2]").click();
		
		// Click on Containers
		js.executeScript("window.scrollBy(0,250)");
		driver.findElementByXPath("//button[text()='Containers']").click();
		
		// Select Container Instances
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		
		// Click on Container Instance Added View
		driver.findElementByXPath("(//a[text()='View'])").click();
		
		// Select Region as "South India"
		WebElement region=driver.findElementByXPath("(//select[@name='region' and @class='select'])");
		Select reg=new Select(region);
		reg.selectByValue("south-india");
		
		// Set the Duration as 180000 seconds
		WebElement duration=driver.findElementByXPath("//input[@name='seconds']");
		duration.sendKeys(Keys.CONTROL,Keys.chord("a"));
		duration.sendKeys(Keys.BACK_SPACE);
		duration.sendKeys("180000");
		
		// Select the Memory as 4GB
		WebElement memory=driver.findElementByXPath("//div[@class='calculator-dropdown ']//select[@name='memory']");
		Select mem=new Select(memory);
		mem.selectByVisibleText("4 GB");
		
		// Enable SHOW DEV/TEST PRICING
		js.executeScript("window.scrollBy(0,750)");
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		
		// Select Indian Rupee  as currency
		WebElement currency=driver.findElementByXPath("(//select[@aria-label='Currency'])[1]");
		Select rs=new Select(currency);
		rs.selectByValue("INR");
		
		// Print the Estimated monthly price
		System.out.println("Estimated Monthly Price:"+driver.findElementByXPath("(//div[@class='column large-3 text-right total']//span[@class='numeric'])[2]").getText());
		
		// Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@data-event='area-pricing-calculator-clicked-exportestimate']").click();
		
		// Verify the downloded file in the local folder
		File fileLocation1=new File("C:\\Users\\Gunalan\\Downloads");
		File[] totalFiles=fileLocation1.listFiles();
		for (File i: totalFiles) {
		
			if (i.getName().equals("ExportedEstimate.xlsx")) {
				System.out.println("File is downloaded Successfully");
				break;
			}}
		
		// Navigate to Example Scenarios and Select CI/CD for Containers
		WebElement example=driver.findElementByXPath("//a[text()='Example Scenarios']");
		mouseover.moveToElement(example).click().perform();
		driver.findElementByXPath("//span[text()='CI/CD for Containers']").click();
			
		// Click Add to Estimate
		driver.findElementByXPath("//button[text()='Add to estimate']").click();
		Thread.sleep(6000);
		
		// Change the Currency as Indian Rupee
		js.executeScript("window.scrollBy(0,750)");
		WebElement currency2=driver.findElementByXPath("(//select[@aria-label='Currency'])[1]");
		Select rs1=new Select(currency2);
		rs1.selectByValue("INR");
		
		
		// Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		
		// Export the Estimate
		driver.findElementByXPath("//button[@data-event='area-pricing-calculator-clicked-exportestimate']").click();
		
		// Verify the downloded file in the local folder
		Thread.sleep(6000);
		File fileLocation2=new File("C:\\Users\\Gunalan\\Downloads");
		File[] totalFiles2=fileLocation2.listFiles();
		for (File i: totalFiles2) {
		
			if (i.getName().equals("ExportedEstimate (1).xlsx")) {
				System.out.println("File is downloaded Successfully");
				break;
			}
		}
	}

}
