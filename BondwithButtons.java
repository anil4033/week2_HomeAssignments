package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BondwithButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leafground.com/pages/Button.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		//Navigating to Home Page 
		driver.findElement(By.id("home")).click();
		String title = driver.getTitle();
		if(title.contains("TestLeaf - Selenium Playground"))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is displayed");
		}
		//Getting the positon of button
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		WebElement findElement = driver.findElement(By.id("position"));
		Point location = findElement.getLocation();
		int x = location.getX();
		System.out.println(x);
		int y = location.getY();
		System.out.println(y);
		
		//Geting the color of button
		String cssValue = driver.findElement(By.id("color")).getCssValue("color");
		System.out.println("The Button Color is"+cssValue);
		
		//Getting Size of button
		Dimension size = driver.findElement(By.id("color")).getSize();
		System.out.println("The Button size is"+size);
	}

}
