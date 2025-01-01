package pages;

import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseLibrary {
    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='×']")
    private WebElement close;
    @FindBy(xpath = "//a[@href='newdemo.html']")
    private WebElement practice;
    @FindBy(xpath = "//button[@data-target='#elements']")
    private WebElement Element;
    @FindBy(xpath = "//*[@href='#tab_4']")
    private WebElement webtable;
    @FindBy(xpath = "//input[@pattern='^[a-zA-Z][\\sa-zA-Z]{2,32}']")
    private WebElement fullname;
    @FindBy(xpath = "//input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$']")
    private WebElement email;
    @FindBy(xpath = "//button[@class='btn btn-success save-btn']")
    private WebElement submit;
    @FindBy(xpath = "//iframe[@src='Webtable.html']")
    private WebElement iframe;
    @FindBy(xpath = "class=//button[@class='btn btn-info btn-xs btn-edit']")
    private WebElement editbtn;
    @FindBy(xpath = "*//button[@class='btn btn-info btn-xs btn-update']")
    private WebElement updatebtn;
    @FindBy(xpath = "//input[@name='edit_name']")
    private WebElement editname;
    @FindBy(xpath = "//input[@name='edit_email']")
    private WebElement editemail;
    @FindBy(xpath = "*//table[@class='table table-bordered data-table']//tbody//td[1]")
    private List<WebElement> updatedname;
    @FindBy(xpath = "*//table[@class='table table-bordered data-table']//tbody//td[2]")
    private List<WebElement> updatedemail;

    // click on page elements
    public void clickonclose() {
        wait(close);
    }

    public void clickonpractice() {
        wait(practice);
    }

    public void clickonelements() {
        wait(Element);
    }

    public void clickonwebtables() {
        wait(webtable);
    }

    public void filldetails() {
        driver.switchTo().frame(iframe);
        for (int i = 1; i < 4; i++) {
            visiblewait(fullname, getReadData(0, i, 0));
            visiblewait(email, getReadData(0, i, 1));
            wait(submit);
        }


        public void validate ()
        {
            System.outprintln("asdfghjkl");
        }
        driver.switchTo().defaultContent();
        // driver.switchTo().defaultContent();
    }

    public void updatedetails() {
        for (int i = 1; i < 4; i++) {
            wait(editbtn);
            editname.clear();
            visiblewait(editname, getReadData(1, i, 0));
            editemail.clear();
            visiblewait(editemail, getReadData(1, i, 1));
            wait(updatebtn);


        }
    }
}