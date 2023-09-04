package vtigerfinalscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;
import pompages.HomePage;

public class CreateOrgWithIndustryAndType extends BaseClass {
	@Test
	public void createOrgWithIndustryAndType()
	{   SoftAssert soft=new SoftAssert();
		HomePage.clickOrganizations();
		soft.assertTrue(driver.getTitle().contains("organization"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getpageHeader().equals("create new organization"));
		Map<String, String> map=excel.readFronExcel("organizationsTestData", "create organization");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setorgName(orgName);
		createOrg.selectIndustry(web,map.get("Industry"));
		createOrg.selectType(web, map.get("Type"));
		createOrg.clickSaveButton();
		soft.assertTrue(newOrgInfo.getpageHeader().contains(orgName));
		if(newOrgInfo.getpageHeader().equals(orgName))
           excel.writeToExcel("organization", "Create Organization Industry And Type", "pass", IconstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("organization", "Create Organization Industry And Type", "fail", IconstantPath.EXCEL_PATH);
		soft.assertAll();
	}

}
