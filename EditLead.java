package week2.weeklyassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
		
		WebDriverManager.chromedriver().setup();//to Have MDV setup Chrome
		ChromeDriver driver = new ChromeDriver();// Initiating Chrome Driver
		driver.get("http://leaftaps.com/opentaps/control/main");// Launch Browser
		driver.manage().window().maximize(); //Maximize browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //setting implicit wait
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager"); //sending username
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");// sending password
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//Finding a link with steps 6 to 10
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("RAMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		/*driver.findElement(By.xpath("//a[text()='10102']")).click();
		First used above commented command. It works but if the linkID is changed/deleted it will not work.So used below.*/
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		//Verify title of the page
		String Btitle = driver.getTitle();
		System.out.print(Btitle);
		WebElement findElement = driver.findElement(By.xpath("//title[text()='View Lead | opentaps CRM']"));
		String text = findElement.getText();
		System.out.println(text);
		if(Btitle.equals(text))
		{
			System.out.println("The Title of Page is Verified as Correct");
		}else
		{
			System.out.println("The Title of Page is Verified as Correct");
		}
		
		//To Edit and Modify Company Name
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String text2 = findElement2.getText();
		
		//Checking whether changes are updated or not
		if(text2.contains("TCS"))
		{
			System.out.println("Changes made to Company Name is updated successfully");
		}
		else 
		{
			System.out.println("Changes are not updated");
		}
		
		//Closing the Browser
		driver.close();
	}

}
