package utils;

import com.avaje.ebean.Ebean;
import models.Task;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

public class InitialData{
    public static void insertInitialData(){
        if(Ebean.find(Task.class).findRowCount() == 0){
            Map<String,List<Object>> all = (Map<String,List<Object>>) Yaml.load("initial-data.yml");
            Ebean.save(all.get("tasks"));
        }
    }
}