package com.makemytrip.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MMTPageObject {

    WebDriver driver;
    By pageLocator;

    public MMTPageObject(WebDriver driver, By pageLocator) {
        this.driver = driver;
        this.pageLocator = pageLocator;
    }

    public static <T extends MMTPageObject> T createPage(WebDriver driver, Class<T> type) {
        T pageObject;
        try {
            pageObject = PageFactory.initElements(driver, type);
        } catch(Exception e) {
            throw new RuntimeException("Unable to instantiate class " + type.getCanonicalName() + e);
        }
        pageObject.waitForPageToLoad();
        return pageObject;
    }

    public void waitForPageToLoad() {
        getPageRoot();
    }

    public WebElement getPageRoot() {
        return driver.findElement(pageLocator);
    }

    public void waitForElementToBePresent(WebElement baseElement, By locator) {
        WaitUtils.waitForElementToBePresent(driver, baseElement, locator);
    }
}
