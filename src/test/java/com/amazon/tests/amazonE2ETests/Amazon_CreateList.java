package com.amazon.tests.amazonE2ETests;

import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class Amazon_CreateList extends TestBase {
    /** Amazon E2E Task
     *  go to https://www.amazon.com.tr/ web page
     *  if there are cookies accept cookies
     *  log in with your own valid credential
     *  Verify that login is successful
     *  Click a new list from Hesap ve Listeler
     *  Select any category from the section tab next to the search box (click search button)
     *  Verify that category  is selected
     *  Write any product to search box and click
     *  Verify that the result page is displayed
     */

    @Test
    public void TC001_ListTest() {
        driver.get(ConfigurationReader.get("url"));
    }
}
