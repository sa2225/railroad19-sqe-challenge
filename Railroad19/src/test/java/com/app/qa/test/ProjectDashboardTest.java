package com.app.qa.test;

import java.text.NumberFormat;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.ProjectDashboard;
import com.crm.qa.util.TestUtil;

/**
 * This class is responsible for the testing of project dashboard page
 * 
 * @author Saniya Anand
 *
 */
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
	
	/** TESTING DIVISION STATISTICS **/
	
	@Test(priority=1)
	public void validateAccountingStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionAccounting(), projectDashboard.countAccounting(), 
				"Test Failed - The 'accounting' division count did not match the statistic!");
	}
	
	@Test(priority=2)
	public void validateAdministrationStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionAdministration(), projectDashboard.countAdministration(), 
				"Test Failed - The 'administration' division count did not match the statistic!");
	}
	
	@Test(priority=3)
	public void validateMarketingStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionMarketing(), projectDashboard.countMarketing(), 
				"Test Failed - The 'marketing' division count did not match the statistic!");
	}
	
	@Test(priority=4)
	public void validateSalesStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionSales(), projectDashboard.countSales(), 
				"Test Failed - The 'sales' division count did not match the statistic!");
	}
	
	@Test(priority=5)
	public void validateProductionStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionProduction(), projectDashboard.countProduction(), 
				"Test Failed - The 'production' division count did not match the statistic!");
	}
	
	/** TESTING STATUS STATISTICS **/
	
	@Test(priority=6)
	public void validateArchivedStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusArchived(), projectDashboard.countArchived(), 
				"Test Failed - The 'archived' status count did not match the statistic!");
	}
	
	@Test(priority=7)
	public void validateNewStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusNew(), projectDashboard.countNew(), 
				"Test Failed - The 'new' status count did not match the statistic!");
	}
	
	@Test(priority=8)
	public void validateWorkingStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusWorking(), projectDashboard.countWorking(), 
				"Test Failed - The 'working' status count did not match the statistic!");
	}
	
	@Test(priority=9)
	public void validateDeliveredStatistics() {
		Assert.assertEquals(projectDashboard.statsStatusDelivered(), projectDashboard.countDelivered(), 
				"Test Failed - The 'delivered' status count did not match the statistic!");
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
	
	@Test(priority=12)
	public void validateFeedbackOnUpdate() {
		Assert.assertEquals(projectDashboard.isShowingFeedbackForRecordUpdate(), true, "Test Failed - Feedback message was not displayed!");
	}
	
	@Test(priority=13)
	public void validateBudgetFormatOnUpdate() {
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String newBudget = formatter.format(Long.parseLong(TestUtil.NEW_BUDGET_VALUE));
		System.out.println("The expected budget value is :: " + newBudget);
		
		Assert.assertEquals(newBudget, projectDashboard.getCurrencyFormattingOnUpdate(), 
				"Test Failed - The budget currency is not getting formatted!");
	}
	
	@Test
	public void validateRowAlignment() {
		Map<String, Integer> positionValues = projectDashboard.getRowAlignment();
		Assert.assertEquals(positionValues.get(TestUtil.RECORDS_ROW), positionValues.get(TestUtil.STATS_CONTROLS_ROW),
				"Test Failed - The page rows are not aligned to the left (Horizontally) as their x-axis values do not match");
	}
	
	@Test
	public void validatePageHeaderText() {
		Assert.assertEquals(projectDashboard.getHeader(), TestUtil.PAGE_HEADER, 
				"Test Failed - The page header did not match the expected value");
	}
	
	@Test
	public void validatePageHTMLTitle() {
		Assert.assertEquals(driver.getTitle(), TestUtil.PAGE_HEADER,
				"Test Failed - The page HTML title did not match the expected value");
	}
	
	@Test
	public void checkExportButtonVisibility() {
		Assert.assertEquals(projectDashboard.isExportButtonVisible(), true, 
				"Test Failed - Export button is not visible");
	}
	
	@Test
	public void checkExportButtonDisabled() {
		Assert.assertEquals(projectDashboard.isExportButtonEnabled(), false, 
				"Test Failed - Export button is not disabled");
	}
	
	@Test
	public void checkAddRecordButtonVisibility() {
		Assert.assertEquals(projectDashboard.isAddRecordButtonVisible(), true, 
				"Test Failed - Add Record button is not visible");
	}
	
	@Test
	public void checkAddRecordButtonDisabled() {
		Assert.assertEquals(projectDashboard.isAddRecordButtonEnabled(), false, 
				"Test Failed - Add Record button is not disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
