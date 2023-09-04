package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactInfoPage {
	
	//Declaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		private WebElement pageHeader;
		  
		//Initialization
			public  NewContactInfoPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//Utilization
			public String getpageHeader() {
				return pageHeader.getText();
}
}