package tests;

import baselibrary.BaseLibrary;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TextBoxTests extends BaseLibrary {
    TextBoxPage ob;
    @Parameters({"browser"})
    @BeforeTest
    public void launchApp(String browser) {
        launchurl(browser);
        ob= new TextBoxPage();
    }

    @Test(priority =1)
    public void clickonclose()
    {
        ob.clickonclose();
    }

    @Test(priority =2)
    public void clickonPractice()
    {
        ob.clickonpractice();
    }
    @Test(priority = 3)
    public void clickonElements()
    {
        ob.clickonelements();
    }
    @Test(priority = 4)
    public void clickontext()
    {
        ob.clickontextbox();
    }
    @Test(priority = 5)
    public void setname()
    {
        ob.setFullname();
    }
    @Test(priority = 6)
    public void setemail()
    {
        ob.setFullemail();
    }
    @Test(priority = 7)
    public void setcurrentadress()
    {
        ob.setcaddres();
    }
    @Test(priority = 8)
    public void setpermaddress()
    {
        ob.setpaddres();
    }
    @Test(priority = 9)
    public void  clickonsubmit()
    {
        ob.setSubmit();
    }
    @Test(priority = 10)
    public void validate()
    {
        ob.validate();
    }

    @Test(priority = 11, dataProvider = "userdetails")
    public void getdata(String user, String pass)
    {
        System.out.println(user + " "+pass);
    }
    @AfterTest
    public void flush()
    {
        driver.close();
    }
}
