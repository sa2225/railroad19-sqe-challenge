package com.crm.qa.util;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.qa.base.TestBase;

public class TestUtil extends TestBase {

		public static long PAGE_LOAD_TIMEOUT = 30;
		public static long IMPLICIT_WAIT = 20;
		
		/**
		 * This is a util method that takes a WebElement & returns 
		 * its second half after splitting by " " (space)
		 * 
		 * @param input
		 * @return
		 */
		public static String fetchSecondHalfofText(WebElement input) {
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
}
