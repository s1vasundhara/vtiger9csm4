package vtiger_crm;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatenewContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		WebElement home=driver.findElement(By.className("hdrLink"));
		if(home.isDisplayed())
			System.out.println("home page is displayed");
		else
			System.out.println("home page not displayed");
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(2000);
		

	driver.findElement(By.xpath("//a[contains(@href,'ndex.php?module=Contacts&action=index')]")).click();
WebElement contact=driver.findElement(By.className("hdrLink"));
		
		if(contact.isDisplayed())
			System.out.println("contact page is displayed");
		else
			System.out.println("contact page not dispalyed");
		
		
driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
WebElement createnewcontact=driver.findElement(By.className("hdrLink"));
				
	if(createnewcontact.isDisplayed())
		System.out.println("create new contact page is displayed");
	else
		System.out.println(" create new contact page not dispalyed");
			
		Thread.sleep(2000);
		
		
		driver.quit();
		
	}

}
