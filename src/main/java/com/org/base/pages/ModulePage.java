package com.org.base.pages;

import com.org.base.steps.LoginSteps;
import com.org.base.steps.ModuleSteps;
import com.org.base.support.Utils;
import net.thucydides.core.annotations.Shared;
import org.openqa.selenium.By;


public class ModulePage extends BasePage {

    @Shared
    Utils utils;

    @Shared
    LoginSteps loginSteps;

    @Shared
    ModuleSteps moduleSteps;

    //*******************Element Properties*******************//
    private By firstname = By.name("firstname");
    private By lastname = By.name("lastname");


    public void createNewUser(String name, boolean flag) {

    }


}
