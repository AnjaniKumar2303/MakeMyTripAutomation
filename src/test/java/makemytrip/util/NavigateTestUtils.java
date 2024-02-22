package makemytrip.util;

import com.makemytrip.util.pages.DashBoardPage;
import com.makemytrip.util.PagesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class NavigateTestUtils {

    public static DashBoardPage navigateToDashBoardPage(WebDriver driver) {
        driver.get(PagesData.DASHBOARD_PAGE_URL);
        waitForPageToLoad(driver, DashBoardPage.DASHBOARD_LOCATOR);
        return new DashBoardPage(driver);
    }

    public static void waitForPageToLoad(WebDriver driver, By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
