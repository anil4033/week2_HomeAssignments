package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://www.leafground.com/pages/Dropdown.html"); // Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		//Select Training program using Index
		WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(1);
		
		//Select Training program using Text
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select select2 = new Select(dropdown2);
		select2.selectByVisibleText("Selenium");
		
		//Select Training program using Value
		WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
		Select select3 = new Select(dropdown3);
		select3.selectByValue("1");
		
		//To get Number of drop down options
		WebElement dropdown4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select select4 = new Select(dropdown4);
		int count = select4.getOptions().size();
		System.out.println("Number of drop down options are" +count);
		
		//Select option using keys
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("Selenium"+Keys.ENTER);
		
		//Select the training option
		driver.findElement(By.xpath("//option[text()='Select your programs']/following::option[1]")).click();
						
	}

}
