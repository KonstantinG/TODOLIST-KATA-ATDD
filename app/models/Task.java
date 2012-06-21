package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Task extends Model{

    @Id
    public Long id;
    public String label;
    
    public static Model.Finder<Long, Task> find = new Model.Finder<Long, Task>(Long.class, Task.class);

    public Task(String label) {
        this.label = label;
    }

    public static List<Task> all() {
        return find.all();
    }
}
