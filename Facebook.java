package week2.weeklyassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to call WDM for driver
		WebDriverManager.chromedriver().setup();
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		driver.get("https://en-gb.facebook.com/");
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//Add implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Create New Account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Anil");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kumar");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
		
		// Step 10: Enterthe password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Welcome@1");
		
		// Step 11: Handle all the three drop downs
		WebElement drop1 = driver.findElement(By.xpath("//select[@id='day']"));
		Select select = new Select(drop1);
		select.selectByIndex(7); //Using Index
		
		WebElement drop2 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select select1 = new Select(drop2);
		select1.selectByValue("3");//Using Value
		
		WebElement drop3 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select select2 = new Select(drop3);
		select2.selectByVisibleText("1985");//Using Visible Text
		
		// Step 12: Select the radio button "Female" 
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
		System.out.print("Successfully entered details in FB SignUP Page");
		
	}

}
