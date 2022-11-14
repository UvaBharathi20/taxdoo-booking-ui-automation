package taxdoo.pageobject;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import taxdoo.commonUtils.Utils;

public class Cookies {
    public static void acceptCookies() throws InterruptedException {
        Utils.getDriver().findElement(By.cssSelector(CookiesConstants.getAcceptCookies())).click();
        Utils.getDriver().switchTo().defaultContent();
        Thread.sleep(3000);
    }
}
