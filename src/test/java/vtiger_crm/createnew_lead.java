package vtiger_crm;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class createnew_lead {
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
		

	driver.findElement(By.xpath("//a[text()='Leads']")).click();
WebElement lead=driver.findElement(By.className("hdrLink"));
		
		if(lead.isDisplayed())
			System.out.println("leads page is displayed");
		else
			System.out.println("leads page not dispalyed");
		
		
driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
WebElement newlead=driver.findElement(By.className("hdrLink"));
				
	if(newlead.isDisplayed())
		System.out.println("create new lead page is displayed");
	else
		System.out.println(" create new lead page not dispalyed");
			
		Thread.sleep(2000);
		Random random=new Random();
		int ranNum=random.nextInt(100);
		String lastname="srca"+ranNum;
		 
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		String company="abcg"+ranNum;
		 driver.findElement(By.name("company")).sendKeys(company);
		 driver.findElement(By.name("button")).click();
		Thread.sleep(2000);
		WebElement adminstrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminstrator).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("login page is displayed");
		else
			System.out.println("login page not displayed");
		
	
		
		
		driver.quit();
	
	}
		

}
