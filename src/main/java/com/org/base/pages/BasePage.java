package com.org.base.pages;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageObject {


    protected void clickOnJSExecutor(By element) {
        waitForDocumentLoad(getDriver());
        WebElement elem = getElement(element);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(elem));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", elem);
        waitForDocumentLoad(getDriver());
    }

    public WebElement getElement(By ele) {
        waitForDocumentLoad(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), 360);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(ele)
        ));
        return getDriver().findElement(ele);
    }

    protected void waitForDocumentLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 360);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    protected void waitForElement(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
