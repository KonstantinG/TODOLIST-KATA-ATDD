package functional;

import org.junit.Ignore;
import org.junit.Test;
import play.libs.F;
import play.test.TestBrowser;


import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

/**
 * As a user I want to get list of tasks So that I can get understanding of my todolist of tasks.
 * 1. Given I have 3 tasks in DB "Clean appartment", "Wash the dishes", "Buy some food"
 *    When I land at home page
 *    Then I should see list of 3 tasks with labels as they stored in DB.
 *
 *    TDD includes 4 steps:
 *    1. Write test            (done)
 *    2. Make sure it fails    (done)
 *    3. Make it green/pass    (?)
 *    4. Refactor it           (WIP)
 */
public class GetListOfTasksFunctionalTest {

    private static final int PORT = 3333;

    @Test public void given3TasksInDB_WhenILandAtHomePage_ThenISeeListOf3Tasks(){
        running(testServer(PORT), HTMLUNIT, new F.Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) throws Throwable {
                browser.goTo("http://localhost:"+PORT+"/");
                String pageSource = browser.pageSource();
                assertThat(pageSource).contains("You have 3 tasks!");
                assertThat(pageSource).contains("Clean appartment").contains("Wash the dishes").contains("Buy some food");
            }
        });
    }
}
