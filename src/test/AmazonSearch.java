package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.in");    
		
		//Maximize window
		driver.manage().window().maximize();
				
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement searchTest = driver.findElement(By.name("field-keywords"));
		searchTest.sendKeys("iphone 12");
		
		WebElement SearchItem = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		SearchItem.click();
		
		
		List<WebElement> phoneList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")) ;
		
		List<WebElement> phonePrice = driver.findElements(By.xpath("//span[@class='a-price-whole']")) ;
		
//		for(WebElement element : phoneList) {
//			  System.out.println(element.getText());
//			}
//			
//		for(WebElement element1 : phonePrice) {
//			  System.out.println(element1.getText());
//			}
		
		for(int i=0; i<phoneList.size();i++) {
			System.out.println("Phone :" + phoneList.get(i).getText() + " Price of Phone: " + phonePrice.get(i).getText() );
		}


	}

}
