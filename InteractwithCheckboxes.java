package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractwithCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leafground.com/pages/checkbox.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		//Selecting multiple check boxes
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		
		//To check whether checkbox is enabled
		boolean enabled = driver.findElement(By.xpath("(//div[@class='example'])[2]/input")).isSelected();
		if(enabled == true)
		{
			System.out.println("The Checkbox is enabled");
		}
		else 
		{
			System.out.println("The Checkbox is disabled");
		}
		//To Uncheck
		driver.findElement(By.xpath("(//div[@class='example'])[3]/input[2]")).click();
		boolean selected = driver.findElement(By.xpath("(//div[@class='example'])[3]/input[2]")).isSelected();
		if(selected == true)
		{
			System.out.println("The Checkbox is enabled");
		}
		else 
		{
			System.out.println("The Checkbox is disabled");
		}
		
		//selecting all checkboxes
		
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[2]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[3]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[4]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[5]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[6]")).click();
	}

}
