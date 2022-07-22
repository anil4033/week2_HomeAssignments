package week2.weeklyassignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://www.leafground.com/pages/table.html");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		
		//Number of columns

		//Number of rows
		
		//Get the progress value of 'Learn to interact with Elements'
		String text = driver.findElement(By.xpath("//font[contains(text(),'interact ')]/following::font")).getText();
        System.out.println(text);
        
        //Check the vital task for the least completed progres
        driver.findElement(By.xpath("//font[contains(text(),'Handle')]/following::font/following::input")).click();
        
     }
	
}
