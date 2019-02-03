package com.crm.qa.util;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.base.TestBase;

/**
 * This is the utility class for the test suite
 * 
 * @author Saniya Anand
 *
 */
public class TestUtil extends TestBase {

		public static long PAGE_LOAD_TIMEOUT = 30;
		public static long IMPLICIT_WAIT = 20;
		
		public static final String PAGE_HEADER = "Project Dashboard";
		
		public static final String RECORDS_ROW = "RECORDS_ROW";
		public static final String STATS_CONTROLS_ROW = "STATS_CONTROLS_ROW";
		
		public static final String ORIGINAL_STAT_BEFORE_UPDATE = "ORIGINAL_STAT_BEFORE_UPDATE";
		public static final String ORIGINAL_STAT_AFTER_UPDATE = "ORIGINAL_STAT_AFTER_UPDATE";
		public static final String NEW_STAT_BEFORE_UPDATE = "NEW_STAT_BEFORE_UPDATE";
		public static final String NEW_STAT_AFTER_UPDATE = "NEW_STAT_AFTER_UPDATE";
		
		public static final String PROJECT_OWNER_BEFORE_UPDATE = "PROJECT_OWNER_BEFORE_UPDATE";
		public static final String PROJECT_OWNER_AFTER_UPDATE = "PROJECT_OWNER_AFTER_UPDATE";
		
		public static final String NEW_BUDGET_VALUE = "2782782788";
		
		/**
		 * This is a util method that takes a WebElement & returns 
		 * its second half after splitting by " " (space)
		 * 
		 * @param input
		 * @return
		 */
		public static String fetchSecondHalfOfText(WebElement input) {
			if(input!=null && input.getText()!=null) {
				return input.getText().split(" ")[1];
			} else {
				return "";
			}		
		}
		
		/**
		 * This method is a util method that counts the number of 
		 * elements out of the list of WebElements whose inner text 
		 * matches the input_division
		 * 
		 * @param input_division
		 * @param elements
		 * 
		 * @return match_count
		 */
		public static int countDivision(String input_division, List<WebElement> elements) {
			int match_count = 0; // Count of elements that match the input_division string

			// Iterating on the list of divisions
			for (WebElement element : elements) {

				String division_text = "";

				// Getting the division text from each element & trimming it
				if (element.getText() != null) {
					division_text = element.getText().trim();
				}

				// Checking if the division text matches 'Accounting' 
				if (division_text.equalsIgnoreCase(input_division)) {
					match_count++; // Increasing count
				}
			}
			return match_count;
		}
		
		/** 
		 * This method defines an explicit wait until the desired element is visible
		 * 
		 * @param driver
		 * @param locator
		 * @param timeout
		 */
		public static void waitTillVisible(WebDriver driver, WebElement locator, int timeout) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
		}
}
