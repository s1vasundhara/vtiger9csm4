package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactsPage;
import pompages.CreateNewContactPage;
import pompages.CreateNewEventPage;
import pompages.CreateNewLeadInfoPage;
import pompages.CreateNewOrgInfoPage;
import pompages.DuplicatingLeadPage;
import pompages.HomePage;
import pompages.LeadsPage;
import pompages.LoginPage;
import pompages.NewContactInfoPage;
import pompages.NewEventInfoPage;
import pompages.NewLeadInfoPage;
import pompages.OrganizationPage;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationPage org;
	protected ContactsPage contacts;
	protected LeadsPage lead;
	protected CreateNewOrgInfoPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewEventPage createEvent;
	protected CreateNewLeadInfoPage createLead;
	protected CreateNewOrgInfoPage newOrgInfo;
	protected NewContactInfoPage newContactInfo;
	protected NewLeadInfoPage newLeadInfo;
	protected NewEventInfoPage newEventInfo;
	protected DuplicatingLeadPage duplicatingLead; 
	
	public static JavaUtility sjutil;
	public static WebDriver sdriver;
	
	//@BeforeSuite;
	//@BeforeTest;
	@BeforeClass
	public void classSetup()
	{
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		property.propertiesInitialization(IconstantPath.PROPERTIES_PATH);
		driver = web.launchBrowser(property.readfromproperties("browser"));
		web.maximizeBrowser();
		web.waitTillElementFound(Long.parseLong(property.readfromproperties("time")));
		sdriver = driver;
		sjutil = jutil;
	}
	@BeforeMethod
	public void methodSetup()
	{
		excel.excelInitialization(IconstantPath.EXCEL_PATH);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		org = new OrganizationPage(driver);
		contacts = new ContactsPage(driver);
		lead = new LeadsPage(driver);
		createOrg = new CreateNewOrgInfoPage(driver);
		createContact = new CreateNewContactPage(driver);
		createEvent = new CreateNewEventPage(driver);
		createLead = new CreateNewLeadInfoPage(driver);
		newOrgInfo = new CreateNewOrgInfoPage(driver);
		newContactInfo = new NewContactInfoPage(driver);
		newLeadInfo = new NewLeadInfoPage(driver);
		newEventInfo = new NewEventInfoPage(driver);
		duplicatingLead = new DuplicatingLeadPage(driver);
		
		web.navigateToApp(property.readfromproperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
	    login.loginToApp(property.readfromproperties("username"), property.readfromproperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}
	@AfterMethod
	public void methodTearDown() {
		home.signOutOfVtiger(web);
		excel.closeExcel();
	}
	
	@AfterClass
	public void classTearDown()
	{
		web.quitAllWindows();
	}
	//@AfterTest
//	@AfterSuite

}