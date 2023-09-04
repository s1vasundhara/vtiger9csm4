package vtigerfinalscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class CreateContactwithOrgTest extends BaseClass {

	@Test
	public void createContactwithOrgTest()
	{
		SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contacts.clickPlusButton();
		soft.assertEquals(createContact.getpageHeader(), "Creating New Contact");
		Map<String , String> map = excel.readFronExcel("ContactTestData", "Create Contact With Organization");
		String lastName = map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setorgName(lastName);
		createContact.selectExistingOrg(web, map.get("Organization Name"));
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getpageHeader().contains(lastName));
		if(newContactInfo.getpageHeader().contains(lastName))
			excel.writeToExcel("ContactTestData", "Create Contact With Organization", "Pass", IconstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("ContactTestData", "Create Contact With Organization", "Fail", IconstantPath.EXCEL_PATH);
		soft.assertAll();
	}
}


