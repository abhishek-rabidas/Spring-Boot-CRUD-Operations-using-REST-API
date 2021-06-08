package com.newproject;

import com.newproject.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class controller {

    @Autowired
    private todoRepository todoRepositoryData;


    @RequestMapping("/")
    public ArrayList<TodoList> getAllTasks(){
        ArrayList<TodoList> todolist = new ArrayList<>();
        todoRepositoryData.findAll().forEach(todolist::add);
        return todolist;
    }


    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public void addTask(@RequestBody TodoList todo){
            todoRepositoryData.save(todo);
    }


    @RequestMapping("/show/{id}")
    public TodoList showOne(@PathVariable Integer id){
        return todoRepositoryData.findById(id).get();
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteTask(@PathVariable Integer id){
        todoRepositoryData.deleteById(id);
    }


    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public void updateTask(@RequestBody TodoList todo, @PathVariable Integer id){
        todoRepositoryData.save(todo);
    }
}
