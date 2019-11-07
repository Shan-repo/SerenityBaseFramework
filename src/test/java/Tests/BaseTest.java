package Tests;


import com.org.base.steps.LoginSteps;
import com.org.base.steps.ModuleSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    @Managed
    public WebDriver driver;

    @Steps(shared = true)
    public LoginSteps loginSteps;
    @Steps(shared = true)
    public ModuleSteps moduleSteps;
}
