package waitutility;

import org.openqa.selenium.WebElement;

public interface WaitUtility {
    public void visiblewait(WebElement ele, String value);
    public void wait(WebElement ele);
}
