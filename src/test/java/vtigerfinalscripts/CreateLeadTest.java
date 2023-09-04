package vtigerfinalscripts;


import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;


public class CreateLeadTest extends BaseClass{
	 public static String lastName;
	@Test
	
	public void createLeadTest() {
		  
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getpageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFronExcel("LeadTestData", "Create lead");
		lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setCompanyName(lastName);
		
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveButton();
		soft.assertTrue(newContactInfo.getpageHeader().contains(lastName));
		if(newContactInfo.getpageHeader().contains(lastName))
			excel.writeToExcel("LeadTestData", "Create Lead", "pass", IconstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("LeadTestData", "Create Lead", "fail", IconstantPath.EXCEL_PATH);


	soft.assertAll();
	}

	}