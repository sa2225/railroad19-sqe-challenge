package com.app.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.ProjectDashboard;

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
	
	@Test
	public void validateAccountingStatistics() {
		Assert.assertEquals(projectDashboard.statsDivisionAccounting(), projectDashboard.countDivisionAccounting());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
