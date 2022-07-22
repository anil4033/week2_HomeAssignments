package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlaywithHyperlinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leafground.com/pages/Link.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		//Navigating to Home Page 
		driver.findElement(By.linkText("Go to Home Page")).click();
		String title = driver.getTitle();
		if(title.contains("TestLeaf - Selenium Playground"))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is displayed");
		}
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		Thread.sleep(2000);
		
		//Checking the link without clicking
		String attribute = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']")).getAttribute("href");
		System.out.println(attribute);
		
		//Navigating to Home Page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		String title1 = driver.getTitle();
		
		if(title1.contains("TestLeaf - Selenium Playground"))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is displayed");
		}
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		
		//Verifying broken link	
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String title2 = driver.getTitle();
	
		
		if(title2.contains("404 Not Found"))
		{
			System.out.println("It is a Broken Link");
		}
		else
		{
			System.out.println("It is working link");
		}
		
	driver.close();
	}

}
