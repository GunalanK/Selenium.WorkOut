package sel90days.workout.day1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Honda {

	public static void main(String[] args) throws InterruptedException {
		//Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.honda2wheelersindia.com/");
		    
		//Maxmize the window
        driver.manage().window().maximize();
		    
        //Add an implicity wait
	    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		    
		try
		{
			driver.findElementByXPath("(//button[@class='close'])").click();
		}
		catch(Exception e)
		{
			
		}

		//Click on scooters and click dio
		driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();
		Thread.sleep(6000);
		WebElement clickDio=driver.findElementByXPath("(//img[@src='/assets/images/thumb/dioBS6-icon.png'])");
		clickDio.click();
		
		//Click on specifications and mouseover on ENGINE
		driver.findElementByXPath("(//a[text()='Specifications'])").click();
		Thread.sleep(10000);
		Actions mouseover=new Actions(driver);
		WebElement engine=driver.findElementByXPath("//a[text()='ENGINE']");
		mouseover.moveToElement(engine).perform();
		
		//Get Displacement value
		Thread.sleep(10000);
		String dioDisplacementValue=driver.findElementByXPath("((//span[text()='Engine'])//following::span)[4]").getText();
		String dioDp=dioDisplacementValue.replaceAll("[A-Za-z]","");
		double dio=Double.parseDouble(dioDp);
		System.out.println("Displacement value of Dio is:"+dio);
		
		//Go to Scooters and click Activa 125
		driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();
		driver.findElementByXPath("//img[@src='/assets/images/thumb/activa-125new-icon.png']").click();
		
		//Click on Specifications and Mouseover on Engine
		Thread.sleep(10000);
		WebElement spf=driver.findElementByXPath("(//a[text()='Specifications'])");
		spf.click();
		mouseover.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).perform();
		
		//Get Displacement value
		String activaDisplacementValue=driver.findElementByXPath("((//ul[@class='tab_content'])[2]//span)[5]").getText();
		String activaDp=activaDisplacementValue.replaceAll("[A-Za-z]","");
		Double activa=Double.parseDouble(activaDp);
		System.out.println("Displacement value of activa is:"+activa);
		
		//Compare Displacement of Dio and Activa 125 and Print the scooter name
		if (dio > activa) {
			System.out.println("Dio having better displacement value than Activa");
		}
		else
		{
			System.out.println("Activa having better displacement value than Dio");
		}
		
		//Click FAQ from menu
		driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();
		
		//Click Activa 125 BS-VI under Browse By Product
		driver.findElementByXPath("(//a[text()='Activa 125 BS-VI'])").click();
		
		//Click Vehicle Price
		driver.findElementByXPath("(//a[@href='#6a'])/i").click();
		
		//Make sure Activa125 Bs-VI selected and click Submit
		String activa125BsVi=driver.findElementById("ModelID6").getText();
		if (activa125BsVi.equalsIgnoreCase("Activa 125 BS-VI")) {
			System.out.println("Activa 125 BS-VI is selected");
		}
		driver.findElementByXPath("(//button[text()='Submit'])[6]").click();
		
		//Click the Price Link
		driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
		
		//Go to the New Window and Select the state as TamilNadu and city as Chennai
		Set<String> winset=driver.getWindowHandles();
		List<String> winList=new ArrayList<String>(winset);
		driver.switchTo().window(winList.get(1));
		WebElement state=driver.findElementByXPath("//select[@id='StateID']");
		Select st=new Select(state);
		st.selectByVisibleText("Tamil Nadu");
		WebElement city=driver.findElementByXPath("//select[@id='CityID']");
		Select ct=new Select(city);
		ct.selectByVisibleText("Chennai");
		
		//Click Search
		driver.findElementByXPath("//button[text()='Search']").click();
		
		//Print all the 3 models and their prices
		Thread.sleep(6000);
		Map<String,String> modelMap=new LinkedHashMap<String,String>();
		List<WebElement> modelsPrice=driver.findElementsByXPath("((//table[@id='gvshow'])//td[contains(text(),'ACTIVA 125')])");
		for (int i = 0; i < modelsPrice.size(); i++) {
			String m=modelsPrice.get(i).getText();
			String mp=driver.findElementByXPath("((//table[@id='gvshow'])//td[contains(text(),'ACTIVA 125')]/following-sibling::td)['"+i+"']").getText();
		    modelMap.put(m,mp) ;
		}
		for (Entry<String,String> i : modelMap.entrySet()) {
			System.out.println("Product Name:"+i.getKey()+ "Product price"+i.getValue());
		}
		
		//Close the Browser
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}

}
