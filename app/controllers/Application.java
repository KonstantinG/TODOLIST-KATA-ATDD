package controllers;

import models.Task;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.LinkedList;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        List<Task> tasks = Task.all();
        return ok(index.render(tasks));
    }

}