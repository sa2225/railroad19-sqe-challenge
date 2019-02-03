package com.app.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;

public class ProjectDashboard extends TestBase {
	
	@FindBy(xpath="//md-toolbar[@class='sideNavHeader md-whiteframe-21dp']/h4")
	WebElement logo;
	
	@FindBy(xpath="//md-content[@class='layout-padding']/h4[1]")
	WebElement navigation_dashboard;	

	@FindBy(xpath="//md-content[@class='layout-padding']/h4[2]")
	WebElement navigation_profile;
	
	@FindBy(xpath="//p[contains(text(), 'Accounting')]")
	WebElement stats_accounting;


	// Initializing the Page Objects:
	public ProjectDashboard() {
		PageFactory.initElements(driver, this);
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
		String stats_accounting_count = "0";

		if(stats_accounting!=null && stats_accounting.getText()!=null) {
			stats_accounting_count = stats_accounting.getText().split(" ")[1];
		}
		System.out.println("The statistics show 'Accounting' count = " + stats_accounting_count);
		return stats_accounting_count;
	}
	
	/**
	 * This method counts the number of records on the webpage that have
	 * division set to 'Accounting'
	 * 
	 * This method does not count the statistics card
	 * 
	 * @return count_accounting
	 */
	public String countDivisionAccounting() {
		int count_accounting = 0; // Count of elements having 'Accounting' as their division
		
		// List of all division tags in record cards
		List<WebElement> divisions = driver.findElements(By.cssSelector("md-card.projCard > div:nth-of-type(2) > span"));

		// Iterating on the list of divisions
		for (WebElement division : divisions) {

			String division_text = "";

			// Getting the division text from each element & trimming it
			if (division.getText() != null) {
				division_text = division.getText().trim();
			}

			// Checking if the division text matches 'Accounting' 
			if (division_text.equalsIgnoreCase("Accounting")) {
				count_accounting++; // Increasing count
			}
		}

		System.out.println("The acutal count of records having divison as 'Accounting' = " + count_accounting);
		
		// Returning the count of elements having 'Accounting' as their division in string format
		return "" + count_accounting;
		
	}
}
