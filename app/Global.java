import com.avaje.ebean.Ebean;
import models.Task;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;
import utils.InitialData;

import java.util.List;
import java.util.Map;

public class Global extends GlobalSettings {
    public void onStart(Application app){
        InitialData.insertInitialData();
    }
}
