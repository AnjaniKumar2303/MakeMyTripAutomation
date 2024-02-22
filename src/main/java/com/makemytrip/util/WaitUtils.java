package com.makemytrip.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForElementToBePresent(WebDriver driver, WebElement baseElement, By locator) {
        waitForElementToBePresent(driver, baseElement, locator, 30);
    }

    public static void waitForElementToBePresent(WebDriver driver, WebElement baseElement, By locator, int timeout) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        ExpectedCondition condition = getExpectedConditionThatElementIsPresent(baseElement, locator);
        wait.until(condition);
    }

    private static ExpectedCondition<Boolean> getExpectedConditionThatElementIsPresent(WebElement baseElement, By locator) {

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    baseElement.findElement(locator);
                    return true;
                } catch(NoSuchElementException n) {
                    return false;
                }
            }
        };
    }
}
