package tests;

import baselibrary.BaseLibrary;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.WebTablesPage;

public class WebTableTests extends BaseLibrary {
    WebTablesPage ob;

    @Parameters({"browser"})

    @BeforeTest
    public void launch(String browser) {
        launchurl(browser);
        ob = new WebTablesPage();

    }

    @Test(priority = 1)
    public void clickonclose() {
        ob.clickonclose();
    }

    @Test(priority = 2)
    public void clickonpractice() {
        ob.clickonpractice();
    }

    @Test(priority = 3)
    public void clickonelements() {
        ob.clickonelements();
    }

    @Test(priority = 4)
    public void clickonwebtables() {
        ob.clickonwebtables();
    }

    @Test(priority = 5)
    public void clickonfilldetails() {
        ob.filldetails();
    }

    @AfterTest
    public void flush()
    {
        driver.close();
    }
}
