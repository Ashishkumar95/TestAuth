package baselibrary;

import excelutility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import waitutility.WaitUtility;

import java.io.FileInputStream;
import java.time.Duration;

public class BaseLibrary implements ExcelUtility, WaitUtility {
    public static WebDriver driver = null;

    public void launchurl(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.get("http:testingbaba.com/old");
    }


    @Override
    public String getReadData(int sht, int row, int col) {
        String path = "C:\\Users\\ASHISH\\IdeaProjects\\TestingBABAmvn\\src\\main\\resources\\nameaddress.xlsx";
        String val = "";
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(sht);
            val = sheet.getRow(row).getCell(col).getStringCellValue();
        } catch (Exception e) {
            System.out.println(e);
        }
      return val;

    }


    @Override
    public void visiblewait(WebElement ele, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.sendKeys(value);
    }

    @Override
    public void wait(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();

    }

    @DataProvider(name = "userdetails")
    public Object[][] userdata() {

        Object[][] user = {{"user1", "passwfdsord"}, {"user2", "password"}, {"user3", "password"}};
        return user;

    }
}

