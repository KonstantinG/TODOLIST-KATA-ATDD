package models;

import org.junit.Test;
import utils.InitialData;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

public class TaskTest {
    @Test public void getAllTasksFromDatabase(){
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                InitialData.insertInitialData();
                List<Task> tasks = Task.all();
                assertThat(tasks.size()).isEqualTo(3);
                assertThat(tasks.get(0).label).isEqualTo("Clean appartment");
                assertThat(tasks.get(1).label).isEqualTo("Wash the dishes");
                assertThat(tasks.get(2).label).isEqualTo("Buy some food");
            }
        });
    }
}
