package controllers;

import com.avaje.ebean.Ebean;
import models.Task;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;
import org.junit.Test;
import play.libs.Yaml;
import play.mvc.Result;
import utils.InitialData;

import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

public class ApplicationTest {

    //THIS SHOULD BE REFACTORED
    @Test public void callIndexAction(){
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                InitialData.insertInitialData();
                Result result = callAction(routes.ref.Application.index());
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentAsString(result)).contains("Clean appartment").contains("Wash the dishes").contains("Buy some food");
            }
        });
    }
}
