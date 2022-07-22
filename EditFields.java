package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leafground.com/pages/Edit.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("anilkumar4033@gmail.com");// Entering Email
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("- Appending text to validate",Keys.TAB);// Appending text
		WebElement findElement = driver.findElement(By.xpath("//input[@value='TestLeaf']"));// getting the deafult value
		String text = findElement.getAttribute("value");
		System.out.print(text);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();// Clear the text
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();// To check field id enabled
		
		if(enabled==true) 
		{
		System.out.println("Field is enabled");
		}else
			
		{
			System.out.println("Field is disabled");
		}
	}

}

