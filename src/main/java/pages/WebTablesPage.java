package pages;

import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BaseLibrary {
    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[text()='×']")
    private WebElement close;
    @FindBy(xpath="//a[@href='newdemo.html']")
    private WebElement practice;
    @FindBy(xpath="//button[@data-target='#elements']")
    private WebElement Element;
    @FindBy(xpath ="//*[@href='#tab_4']")
    private WebElement webtable;
    @FindBy(xpath = "//input[@pattern='^[a-zA-Z][\\sa-zA-Z]{2,32}']")
    private WebElement fullname;
    @FindBy(xpath = "//input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$']")
    private WebElement email;
    @FindBy(xpath = "//button[@class='btn btn-success save-btn']")
    private WebElement submit;
    @FindBy(xpath = "//iframe[@src='Webtable.html']")
    private WebElement iframe;

    // click on page elements
    public void clickonclose() {wait(close);}
    public void clickonpractice()
    {
        wait(practice);
    }
    public void clickonelements()
    {
        wait(Element);
    }
    public void clickonwebtables(){wait(webtable);}
    public void filldetails()
    {
        driver.switchTo().frame(iframe);
        for(int i=1 ; i<4; i++) {
            visiblewait(fullname, getReadData(0, i, 0));
            visiblewait(email, getReadData(0, i, 1));
            wait(submit);
        }

        public void validate()
        {

        }
        driver.switchTo().defaultContent();
    }
}
