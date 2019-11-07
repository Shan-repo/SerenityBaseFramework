package com.org.base.steps;

import com.org.base.pages.ModulePage;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class ModuleSteps extends ScenarioSteps {
    @Shared
    ModulePage modulePage;

    @Step("I should be abe to create new user")
    public ModuleSteps createAccount(String name, boolean flag) {
        modulePage.createNewUser(name, flag);
        return this;
    }


}
