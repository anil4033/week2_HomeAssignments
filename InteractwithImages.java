package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractwithImages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leafground.com/pages/Image.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		//Navigating to Home Page 
		driver.findElement(By.xpath("//label[@for='home']/following-sibling::img")).click();
		String title = driver.getTitle();
		if(title.contains("TestLeaf - Selenium Playground"))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is displayed");
		}
		
		driver.findElement(By.xpath("//img[@alt='Images']")).click();// jsut to return to Images page
		
		//Am I broken image
		
		WebElement img = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
		String width = img.getAttribute("width");
		
		if(width.equals("0")) 
		{
			System.out.println("Yes. I'm broken image");
		}
		else 
		{
			System.out.println("No. I'm not broken image");			
		}
		
		//Clicking using key board/mouse
		
		//driver.findElement(By.xpath("(//label[@for='position'])[2]/following-sibling::img")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//label[@for='position'])[2]/following-sibling::img")).click();
		String title1 = driver.getTitle();
		if(title1.contains("TestLeaf - Selenium Playground"))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is displayed");
		}
		
		driver.close();
	}
	

}
