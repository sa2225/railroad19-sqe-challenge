package com.app.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ProjectDashboard extends TestBase {
	
	@FindBy(xpath="//md-toolbar[@class='sideNavHeader md-whiteframe-21dp']/h4")
	WebElement logo;
	
	@FindBy(xpath="//md-content[@class='layout-padding']/h4[1]")
	WebElement navigation_dashboard;	

	@FindBy(xpath="//md-content[@class='layout-padding']/h4[2]")
	WebElement navigation_profile;
	
	/** Finding Statistics **/
	
	@FindBy(xpath="//p[contains(text(), 'Accounting')]")
	WebElement stats_accounting;

	@FindBy(xpath="//p[contains(text(), 'Administration')]")
	WebElement stats_administration;
	
	@FindBy(xpath="//p[contains(text(), 'Marketing')]")
	WebElement stats_marketing;
	
	@FindBy(xpath="//p[contains(text(), 'Sales')]")
	WebElement stats_sales;

	@FindBy(xpath="//p[contains(text(), 'Production')]")
	WebElement stats_production;
	
	@FindBy(xpath="//p[contains(text(), 'archived')]")
	WebElement stats_archived;
	
	@FindBy(xpath="//p[contains(text(), 'new')]")
	WebElement stats_new;
	
	@FindBy(xpath="//p[contains(text(), 'working')]")
	WebElement stats_working;

	@FindBy(xpath="//p[contains(text(), 'delivered')]")
	WebElement stats_delivered;
	
	List<WebElement> divisions;
	List<WebElement> statuses; 

	// Initializing the Page Objects:
	public ProjectDashboard() {
		PageFactory.initElements(driver, this);

		// List of all division tags in record cards
		divisions = driver.findElements(By.cssSelector("md-card.projCard > div:nth-of-type(2) > span"));
		
		// List of all status tags in record cards
		statuses = driver.findElements(By.cssSelector("md-card.projCard > div:nth-of-type(5) > span"));
	}

	public String verifyLogo() {
		String logoText	= logo.getText();
		System.out.println(logoText);
		return logoText;
	}
	
	/**
	 * This method fetches the statistics value for Accounting
	 * that is displayed on the statistics card
	 * 
	 * @return stats_accounting_count
	 */
	public String statsDivisionAccounting() {
		String stats_accounting_count = TestUtil.fetchSecondHalfofText(stats_accounting);
		System.out.println("The statistics show 'Accounting' count = " + stats_accounting_count);
		return stats_accounting_count;
	}
	
	/**
	 * This method fetches the statistics value for Administration
	 * that is displayed on the statistics card
	 * 
	 * @return stats_administration_count
	 */
	public String statsDivisionAdministration() {
		String stats_administration_count = TestUtil.fetchSecondHalfofText(stats_administration);
		System.out.println("The statistics show 'Administration' count = " + stats_administration_count);
		return stats_administration_count;
	}
	
	/**
	 * This method fetches the statistics value for Marketing
	 * that is displayed on the statistics card
	 * 
	 * @return stats_marketing_count
	 */
	public String statsDivisionMarketing() {
		String stats_marketing_count = TestUtil.fetchSecondHalfofText(stats_marketing);
		System.out.println("The statistics show 'Marketing' count = " + stats_marketing_count);
		return stats_marketing_count;
	}
	
	/**
	 * This method fetches the statistics value for Sales
	 * that is displayed on the statistics card
	 * 
	 * @return stats_sales_count
	 */
	public String statsDivisionSales() {
		String stats_sales_count = TestUtil.fetchSecondHalfofText(stats_sales);
		System.out.println("The statistics show 'Sales' count = " + stats_sales_count);
		return stats_sales_count;
	}
	
	/**
	 * This method fetches the statistics value for Production
	 * that is displayed on the statistics card
	 * 
	 * @return stats_production_count
	 */
	public String statsDivisionProduction() {
		String stats_production_count = TestUtil.fetchSecondHalfofText(stats_sales);
		System.out.println("The statistics show 'Production' count = " + stats_production_count);
		return stats_production_count;
	}
	
	/**
	 * This method fetches the statistics value for Archived
	 * that is displayed on the statistics card
	 * 
	 * @return stats_production_count
	 */
	public String statsStatusArchived() {
		String stats_archived_count = TestUtil.fetchSecondHalfofText(stats_archived);
		System.out.println("The statistics show 'Archived' count = " + stats_archived_count);
		return stats_archived_count;
	}
	
	/**
	 * This method fetches the statistics value for New
	 * that is displayed on the statistics card
	 * 
	 * @return stats_new_count
	 */
	public String statsStatusNew() {
		String stats_new_count = TestUtil.fetchSecondHalfofText(stats_new);
		System.out.println("The statistics show 'New' count = " + stats_new_count);
		return stats_new_count;
	}
	
	/**
	 * This method fetches the statistics value for Working
	 * that is displayed on the statistics card
	 * 
	 * @return stats_working_count
	 */
	public String statsStatusWorking() {
		String stats_working_count = TestUtil.fetchSecondHalfofText(stats_working);
		System.out.println("The statistics show 'Working' count = " + stats_working_count);
		return stats_working_count;
	}
	
	/**
	 * This method fetches the statistics value for Delivered
	 * that is displayed on the statistics card
	 * 
	 * @return stats_working_count
	 */
	public String statsStatusDelivered() {
		String stats_delivered_count = TestUtil.fetchSecondHalfofText(stats_delivered);
		System.out.println("The statistics show 'Delivered' count = " + stats_delivered_count);
		return stats_delivered_count;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * division set to 'Accounting'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_accounting
	 */
	public String countAccounting() {
		int count_accounting = TestUtil.countDivision("Accounting", divisions);

		System.out.println("The acutal count of records having divison as 'Accounting' = " + count_accounting);
		
		// Returning the count of elements having 'Accounting' as their division in string format
		return "" + count_accounting;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * division set to 'Administration'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_administration
	 */
	public String countAdministration() {
		int count_administration = TestUtil.countDivision("Administration", divisions);

		System.out.println("The acutal count of records having divison as 'Administration' = " + count_administration);
		
		// Returning the count of elements having 'Administration' as their division in string format
		return "" + count_administration;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * division set to 'Marketing'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_marketing
	 */
	public String countMarketing() {
		int count_marketing = TestUtil.countDivision("Marketing", divisions);

		System.out.println("The acutal count of records having divison as 'Marketing' = " + count_marketing);
		
		// Returning the count of elements having 'Marketing' as their division in string format
		return "" + count_marketing;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * division set to 'Sales'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_sales
	 */
	public String countSales() {
		int count_sales = TestUtil.countDivision("Sales", divisions);

		System.out.println("The acutal count of records having divison as 'Sales' = " + count_sales);
		
		// Returning the count of elements having 'Sales' as their division in string format
		return "" + count_sales;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * division set to 'Production'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_production
	 */
	public String countProduction() {
		int count_production = TestUtil.countDivision("Production", divisions);

		System.out.println("The acutal count of records having divison as 'Production' = " + count_production);
		
		// Returning the count of elements having 'Production' as their division in string format
		return "" + count_production;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * status set to 'Archived'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_archived
	 */
	public String countArchived() {
		int count_archived = TestUtil.countDivision("Archived", statuses);

		System.out.println("The acutal count of records having status as 'Archived' = " + count_archived);
		
		// Returning the count of elements having 'Archived' as their status in string format
		return "" + count_archived;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * status set to 'New'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_new
	 */
	public String countNew() {
		int count_new = TestUtil.countDivision("New", statuses);

		System.out.println("The acutal count of records having status as 'New' = " + count_new);
		
		// Returning the count of elements having 'New' as their status in string format
		return "" + count_new;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * status set to 'Working'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_working
	 */
	public String countWorking() {
		int count_working = TestUtil.countDivision("Working", statuses);

		System.out.println("The acutal count of records having status as 'Working' = " + count_working);
		
		// Returning the count of elements having 'Working' as their status in string format
		return "" + count_working;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * status set to 'Delivered'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_delivered 
	 */
	public String countDelivered() {
		int count_delivered = TestUtil.countDivision("Delivered", statuses);

		System.out.println("The acutal count of records having status as 'Delivered' = " + count_delivered);
		
		// Returning the count of elements having 'Delivered' as their status in string format
		return "" + count_delivered ;
	}
	
	/**
	 * This method performs the task of updating the status of the first record
	 * and returns the original and updated statistics of both the original status
	 * and the updated status
	 * 
	 * 
	 * @return originalAndUpdatedStatistics
	 */
	public Map<String, String> updateStatusAndStatistics() {
		
		// Creating a HashMap to return the original statistics values of the original status and new status & the original and new status names
		Map<String, String> originalAndUpdatedStatistics = new HashMap<String, String>();
		
		
		System.out.println("Fetching the original status of the first record");
		// Extracting the original status text of the first record's status container element
		String originalStatusText = statuses.get(0).getText().trim();
		String newStatusText; // Will hold the updated status text
		
		// Getting the statistics for the original status (BEFORE UDPATE)
		WebElement originalStatusStat = driver.findElement(By.xpath("//p[contains(text(),'" + originalStatusText.toLowerCase() + "')]"));
		originalAndUpdatedStatistics.put(TestUtil.ORIGINAL_STAT_BEFORE_UPDATE, TestUtil.fetchSecondHalfofText(originalStatusStat));
		WebElement newStatusStat; // Will hold the statistic for the new status (BEFORE UPDATE)
		
		// Getting the edit button element for the first record
		WebElement editButton = driver.findElement(By.cssSelector("md-card.projCard:first-child > div:nth-of-type(5) > span + img"));
		
		// Getting the hidden input field element for editing the status
		WebElement statusInputField = driver.findElement(By.cssSelector("md-card.projCard:first-child > div:nth-of-type(5) > span + img + md-input-container > input"));
				
		// Clicking the edit button & clearing the input field
		System.out.println("Going to click edit button for status...");
		editButton.click();
		System.out.println("Clearing status input field...");
		statusInputField.clear();
		
		// Filling a new value into the input field which is different from the original value
		System.out.println("Filling new value into status field...");
		if(!originalStatusText.equalsIgnoreCase("new")) { // Arbitrarily checking if we can set the new value as - "New" status, if its not already "New"
			
			// Typing text 'new' into the input field
			statusInputField.sendKeys("new");
			newStatusText = "new"; // (STATUS AFTER EDIT SET TO - "new")
			
			// Getting the corresponding statistic for the newly set status (BEFORE UPDATE/SAVE)
			newStatusStat = driver.findElement(By.xpath("//p[contains(text(),'new')]"));
			
		
		} else { // Arbitrarily setting new value as "Archived" status since "New" was the same as original
			
			statusInputField.sendKeys("archived"); // (STATUS AFTER EDIT SET TO - "archived")
			newStatusText = "archived";
			
			// Getting the corresponding statistic for the newly set status
			newStatusStat = driver.findElement(By.xpath("//p[contains(text(),'archived')]"));
			
		}
		originalAndUpdatedStatistics.put(TestUtil.NEW_STAT_BEFORE_UPDATE, TestUtil.fetchSecondHalfofText(newStatusStat));
		
		/*** NOW UPDATING RECORD ***/
		System.out.println("Saving changes to status field...");
		editButton.click();
		
		// Fetching status statistics again after the update was made
		originalStatusStat = driver.findElement(By.xpath("//p[contains(text(),'" + originalStatusText.toLowerCase() + "')]")); // AFTER UPDATE
		newStatusStat = driver.findElement(By.xpath("//p[contains(text(),'" + newStatusText.toLowerCase() + "')]")); // AFTER UPDATE
		
		// Adding updated statistics into the map
		originalAndUpdatedStatistics.put(TestUtil.NEW_STAT_AFTER_UPDATE, TestUtil.fetchSecondHalfofText(newStatusStat)); // AFTER UPDATE
		originalAndUpdatedStatistics.put(TestUtil.ORIGINAL_STAT_AFTER_UPDATE, TestUtil.fetchSecondHalfofText(originalStatusStat)); // AFTER UPDATE
		 
		System.out.println("The original & updated statistics are :: " + originalAndUpdatedStatistics);
		
		return originalAndUpdatedStatistics;
	}
	
	/**
	 * This method checks if updating and saving a record is maintained after
	 * refreshing the page
	 * 
	 * @return originalAndUpdatedProjectOwner
	 */
	public Map<String, String> checkRecordUpdateSaveOnRefresh() {
		// Creating a HashMap to return the original statistics values of the original status and new status & the original and new status names
		Map<String, String> originalAndUpdatedProjectOwner = new HashMap<String, String>();
		
		System.out.println("Fetching the project owner elements of the first record");
		// Extracting the original status text of the first record's status container element
		WebElement projectOwner = driver.findElement(By.cssSelector("md-card.projCard:first-child > div:nth-of-type(3) > span"));
		WebElement editButton = driver.findElement(By.cssSelector("md-card.projCard:first-child > div:nth-of-type(3) > span + img"));
		WebElement projectOwnerInputField = driver.findElement(By.cssSelector("md-card.projCard:first-child > div:nth-of-type(3) > span + img + md-input-container > input"));
		
		
		originalAndUpdatedProjectOwner.put(TestUtil.PROJECT_OWNER_BEFORE_UPDATE, projectOwner.getText());
		
		// Clicking the edit button & clearing the input field
		System.out.println("Going to click edit button for project owner...");
		editButton.click();
		System.out.println("Clearing project owner input field...");
		projectOwnerInputField.clear();
		
		System.out.println("Sending new value of project owner to input field...");
		projectOwnerInputField.sendKeys("Carlos Spaventa");
		
		System.out.println("Saving the new value...");
		editButton.click();
		
		System.out.println("Refreshing the page to check if update was successful...");
		driver.navigate().refresh();
		
		projectOwner = driver.findElement(By.cssSelector("md-card.projCard:first-child > div:nth-of-type(3) > span"));
		originalAndUpdatedProjectOwner.put(TestUtil.PROJECT_OWNER_AFTER_UPDATE, projectOwner.getText());

		return originalAndUpdatedProjectOwner;
		
	}
	
}
