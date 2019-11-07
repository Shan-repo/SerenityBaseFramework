package com.org.base.steps;

import com.org.base.pages.LoginPage;
import com.org.base.support.Utils;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class LoginSteps extends ScenarioSteps {

    @Shared
    LoginPage loginPage;

    @Shared
    Utils utils;

    @Step("Given I Launch URL")
    public LoginSteps givenILaunchURL() {
        loginPage.navigateToPage(utils.readConfigPropertiesFile("Url1"));
        return this;
    }

    @Step("Then I logout from application")
    public void Logout() {
        loginPage
                .logout();
    }

}
