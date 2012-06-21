package views;

import models.Task;
import org.junit.Test;
import play.libs.Yaml;
import views.html.index;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class IndexTest {
    @Test public void renderIndex(){
        List<Task> tasks = new LinkedList<Task>();
        tasks.add(new Task("Clean appartment"));
        tasks.add(new Task("Wash the dishes"));
        tasks.add(new Task("Buy some food"));
        assertThat(index.render(tasks).body()).contains("Clean appartment").contains("Wash the dishes").contains("Buy some food");;
    }
}
