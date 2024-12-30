package pages;

import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class TextBoxPage extends BaseLibrary {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[text()='×']")
    private WebElement close;
    @FindBy(xpath="//a[@href='newdemo.html']")
    private WebElement practice;
    @FindBy(xpath="//button[@data-target='#elements']")
    private WebElement Element;

    @FindBy(xpath="//a[text()='text box']")
    private WebElement textbox;
    @FindBy(xpath="//input[@id='fullname1']")
    private WebElement fullname;
    @FindBy(xpath="//input[@id = 'fullemail1']")
    private WebElement email;
    @FindBy(xpath="//textarea[@id = 'fulladdresh1']")
    private WebElement caddress;

    @FindBy(xpath="//textarea[@id = 'paddresh1']")
    private WebElement paddress;

    @FindBy(xpath="//div[@class='col-md-6 mt-5']//label")
    private List<WebElement> list;

    @FindBy(xpath="//input[@value = 'Submit']")
    private WebElement submit;





    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void clickonclose()
    {
        wait(close);
    }
    public void clickonpractice()
    {
        wait(practice);
    }
    public void clickonelements()
    {
        wait(Element);
    }
    public void clickontextbox()
    {
        wait(textbox);
    }
    public void setFullname()
    {
        visiblewait(fullname,getReadData(0,1,0));
    }
    public void setFullemail()
    {
        visiblewait(email, getReadData(0,1,1));
    }
    public void setcaddres()
    {
        visiblewait(caddress,getReadData(0,1,2));
    }

    public void setpaddres()
    {
        visiblewait(paddress,getReadData(0,1,3));
    }
    public void setSubmit()
    {
        wait(submit);
    }
    public void validate()
    {
        ArrayList<String> actual = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();
        SoftAssert softassert = new SoftAssert();
        for(int i=1;i<list.size();i=i+2)
        {
            actual.add(list.get(i).getText());
        }
        for (int i=0;i<4;i++)
        {
            expected.add(getReadData(0,1, i));
        }
        for (int i=0;i<actual.size();i++) {
            softassert.assertEquals(actual.get(i).trim(), expected.get(i).trim());
            //System.out.println("test: " + actual.get(i) + " " + expected.get(i) + softassert.assertEquals(););

        }
        softassert.assertAll();
        System.out.println("success");

    }
}
