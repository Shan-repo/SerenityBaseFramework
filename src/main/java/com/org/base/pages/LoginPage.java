package com.org.base.pages;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By userNavigationLabel = By.id("userNavigationLabel");
    private By logout = By.xpath("//*[contains(text(),'Log Out')]");

    public void navigateToPage(String url) {
        getDriver().navigate().to(url);
    }


    public void logout() {
        Serenity.takeScreenshot();
        getDriver().quit();
    }


}
