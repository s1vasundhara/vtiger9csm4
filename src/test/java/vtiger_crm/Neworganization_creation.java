package vtiger_crm;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Neworganization_creation {
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
		
		
		WebElement organization=driver.findElement(By.className("hdrLink"));
		
		if(organization.isDisplayed())
			System.out.println("organization page is displayed");
		else
			System.out.println("organization page not dispalyed");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
WebElement createorganization=driver.findElement(By.xpath("//span[text()='Creating New Organization']"));
		
		if(createorganization.isDisplayed())
			System.out.println("createorganization page is displayed");
		else
			System.out.println("createorganization page not dispalyed");
		Thread.sleep(2000);
		Random random=new Random();
		int ranNum=random.nextInt(100);
		String orgname="src"+ranNum;
		
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();
WebElement orgname1=driver.findElement(By.className("dvHeaderText"));
		
		if(orgname1.isDisplayed())
			System.out.println("orgname page is displayed");
		else
			System.out.println("orgname  page not dispalyed");
		Thread.sleep(3000);
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
