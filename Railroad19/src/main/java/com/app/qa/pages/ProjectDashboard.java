package com.app.qa.pages;

import java.util.ArrayList;
import java.util.List;

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
	
}
