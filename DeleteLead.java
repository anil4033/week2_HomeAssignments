package week2.weeklyassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	/*Delete Lead:
			1	Launch the browser
			2	Enter the username
			3	Enter the password
			4	Click Login
			5	Click crm/sfa link
			6	Click Leads link
			7	Click Find leads
			8	Click on Phone
			9	Enter phone number
			10	Click find leads button
			11	Capture lead ID of First Resulting lead
			12	Click First Resulting lead
			13	Click Delete
			14	Click Find leads
			15	Enter captured lead ID
			16	Click find leads button
			17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
			18	Close the browser (Do not log out)*/
		
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leaftaps.com/opentaps/control/main");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager"); //sending username
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");// sending password
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//Finding a link with steps 5 to 7
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		//providing Phone number
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("99");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234");
		Thread.sleep(1000);
		
		//Finding the leads related to phone number given and capturing the lead ID and deleting the lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement Lead = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String text = Lead.getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//Finding the Deleted key by using captured Lead ID
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Checking whether the Lead is still available or deleted successfully
		WebElement findElement = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		String text2 = findElement.getText();
		
		if(text2.equalsIgnoreCase("No records to display")) 
		{
			System.out.println("Deleted successfully");
		}
		else
		{
			System.out.println("Delete is not successfully");
		}
		
		//Closing the Browser
		driver.close();
	}

}
