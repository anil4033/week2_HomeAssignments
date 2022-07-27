package week2.weeklyassignments.leafground;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
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
		List<WebElement> column = driver.findElements(By.tagName("th"));	// total column count
		int columnIndex = column.size();
		System.out.println("Total column available in the table is " + columnIndex);
		
		//Number of rows
		List<WebElement> row = driver.findElements(By.tagName("tr"));	//total row count
		int rowIndex = row.size();
		System.out.println("Total rows available in the table is " + rowIndex);
		
	
		//Get the progress value of 'Learn to interact with Elements'
		String text = driver.findElement(By.xpath("//font[contains(text(),'interact ')]/following::font")).getText();
        System.out.println(text);
        
        //Check the vital task for the least completed progres
        driver.findElement(By.xpath("//font[contains(text(),'Handle')]/following::font/following::input")).click();
        
     }
	
}
