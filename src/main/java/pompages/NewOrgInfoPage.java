package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrgInfoPage {

	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private static WebElement pageHeader;
	  
	//Initialization
		public NewOrgInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public static String getpageHeader() {
			return pageHeader.getText();
}
}
