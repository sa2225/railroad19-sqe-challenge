package com.app.qa.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.ProjectDashboard;
import com.crm.qa.util.TestUtil;

public class ProjectDashboardTest extends TestBase {
ProjectDashboard projectDashboard;
	public ProjectDashboardTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		projectDashboard= new ProjectDashboard();
		
	}
	
	@Test
	public void validateLogo() {
		String logo = projectDashboard.verifyLogo();
		Assert.assertEquals(logo, "Project Dashboard");
	}
	
	@Test
	public void validatePageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Project Dashboard");
	}
	
	/** TESTING DIVISION STATISTICS **/
	
	@Test(priority=1)
	public void validateAccountingStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionAccounting(), projectDashboard.countAccounting());
	}
	
	@Test(priority=2)
	public void validateAdministrationStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionAdministration(), projectDashboard.countAdministration());
	}
	
	@Test(priority=3)
	public void validateMarketingStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionMarketing(), projectDashboard.countMarketing());
	}
	
	@Test(priority=4)
	public void validateSalesStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionSales(), projectDashboard.countSales());
	}
	
	@Test(priority=5)
	public void validateProductionStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionProduction(), projectDashboard.countProduction());
	}
	
	/** TESTING STATUS STATISTICS **/
	
	@Test(priority=6)
	public void validateArchivedStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusArchived(), projectDashboard.countArchived());
	}
	
	@Test(priority=7)
	public void validateNewStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusNew(), projectDashboard.countNew());
	}
	
	@Test(priority=8)
	public void validateWorkingStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusWorking(), projectDashboard.countWorking());
	}
	
	@Test(priority=9)
	public void validateDeliveredStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusDelivered(), projectDashboard.countDelivered());
	}
	
	@Test(priority=10)
	public void validateStatusUpdateStatistics() {
		
		Map<String, String> originalAndUpdatedStatistics = projectDashboard.updateStatusAndStatistics();
		
		// ORIGINAL STATUS STATISTICS BEFORE AND AFTER UPDATE
		int originalStatBeforeUpdate = Integer.parseInt(originalAndUpdatedStatistics.get(TestUtil.ORIGINAL_STAT_BEFORE_UPDATE));
		int originalStatAfterUpdate = Integer.parseInt(originalAndUpdatedStatistics.get(TestUtil.ORIGINAL_STAT_AFTER_UPDATE));
		
		// NEW STATUS STATISTICS BEFORE AND AFTER UPDATE
		int newStatBeforeUpdate = Integer.parseInt(originalAndUpdatedStatistics.get(TestUtil.NEW_STAT_BEFORE_UPDATE));
		int newStatAfterUpdate = Integer.parseInt(originalAndUpdatedStatistics.get(TestUtil.NEW_STAT_AFTER_UPDATE));
			
		Assert.assertTrue((originalStatBeforeUpdate == originalStatAfterUpdate + 1) && (newStatBeforeUpdate == newStatAfterUpdate - 1), 
				"Test Failed - Statistics are not getting updated on updating the status of a record!");
	}
	
	@Test(priority=11)
	public void validateRecordUpdateSaveOnRefresh() {
		Map<String, String> originalAndUpdatedField = projectDashboard.checkRecordUpdateSaveOnRefresh();
		Assert.assertNotEquals(originalAndUpdatedField.get(TestUtil.PROJECT_OWNER_BEFORE_UPDATE), 
				originalAndUpdatedField.get(TestUtil.PROJECT_OWNER_AFTER_UPDATE), 
				"Test Failed - The updates made to the record were not refelected after page refresh!");	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
