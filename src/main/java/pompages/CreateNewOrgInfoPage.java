package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class CreateNewOrgInfoPage {
      //Declaration 
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name="accountname")
	private WebElement orgNameTF;
	@FindBy (name="industry")
	private WebElement industryDropdown;
	@FindBy (name="accounttype")
	private WebElement typeDropdown;
	@FindBy (xpath = "//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	
	
      //Initialization
	public CreateNewOrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getpageHeader() {
		return pageHeader.getText();
		}
	public void setorgName(String orgName) {
		orgNameTF.sendKeys(orgName);
	}
	public void selectIndustry(WebDriverUtility web,String value) {
		web.selectFromDropdown( industryDropdown,value);
	}
	public void clickSaveButton() {
		saveButton.click();
	}
		public void selectType(WebDriverUtility web,String value) {
			web.selectFromDropdown(typeDropdown, value);
	
	}
}