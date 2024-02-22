package com.makemytrip.util.pages;

import com.makemytrip.util.MMTPageObject;
import com.makemytrip.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DashBoardPage extends MMTPageObject {

    WebDriver driver;

    public static final By DASHBOARD_LOCATOR = By.id("top-banner");

    @FindBy(xpath = "//span[contains(text(),'Departure')]")
    WebElement departure;

    public DashBoardPage(WebDriver driver) {
        super(driver, DASHBOARD_LOCATOR);
    }

    public void selectDeparture() {
        departure.click();
    }

    public void selectDate(String dateOfBooking) {

        WebElement webElement = driver.findElement(By.className("DayPicker-Months"));
        List<WebElement> list = webElement.findElements(By.className("DayPicker-Month"));

        for(WebElement element : list) {
            List<WebElement> dateElementList = element.findElements(By.xpath("//div[@class='DayPicker-Day']"));
            for(WebElement element1 :  dateElementList) {
                element.findElement(By.cssSelector("div[aria-label*='" + dateOfBooking + "']"));
            }

        }

    }

    @Override
    public void waitForPageToLoad() {
        super.waitForPageToLoad();
        waitForElementToBePresent(getPageRoot(), DASHBOARD_LOCATOR);
    }
}
