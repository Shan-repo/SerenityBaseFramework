package Tests;


import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModuleTest extends BaseTest {

    @Rule
    public TestName name = new TestName();
    String ClassName;
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            ClassName = description.getClassName();
        }
    };

    @Test
    public void createAccount() {
        loginSteps.givenILaunchURL();
        moduleSteps
                .createAccount(ClassName + ":" + name.getMethodName(), false);
        loginSteps.Logout();
    }

}
