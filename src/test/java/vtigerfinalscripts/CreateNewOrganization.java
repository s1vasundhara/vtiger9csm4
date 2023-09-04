package vtigerfinalscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;
import pompages.HomePage;

public class CreateNewOrganization extends BaseClass{
	@Test
	
		
	public void CreateOrgTest() {
		SoftAssert soft=new SoftAssert();
		HomePage.clickOrganizatons();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getpageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFronExcel("OrganizationTestData", "Create Organization");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setorgName(orgName);
		createOrg.clickSaveButton();
		
		
		soft.assertTrue(newOrgInfo.getpageHeader().contains(orgName));
		if(newOrgInfo.getpageHeader().contains(orgName))
			excel.writeToExcel("OrganizationTestData", "Create Organization", "Pass", IconstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("OrganizationTestData", "Create Organization", "Fail", IconstantPath.EXCEL_PATH);
		soft.assertAll();
		
	}
}


