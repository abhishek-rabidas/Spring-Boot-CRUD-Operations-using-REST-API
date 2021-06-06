package com.newproject;

import com.newproject.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class controller {

    //ArrayList to store the data (mutable)
    ArrayList<TodoList> todolist = new ArrayList<>();

    //To show all the tasks by responding to the GET request from '/'
    //It is a type of ArrayList<TodoList> and returns the objects of todolist (JSON Format)
    @RequestMapping("/")
    public ArrayList<TodoList> getAllTasks(){
        return todolist;
    }

    //To add task using POST
    //Adds the incoming request body to the ArrayList using add method
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public void addTask(@RequestBody TodoList todo){
            todolist.add(todo);
    }

    //To show single resource (GET request)
    //It is a type of TodoList.class and returns object of the same class out of the ArrayList
    @RequestMapping("/show/{id}")
    public TodoList showOne(@PathVariable Integer id){
        for(int i=0; i<todolist.size();i++){
            if(todolist.get(i).getId()==id){
                return todolist.get(i);
            }
        }
        return null;
    }


    //Deletes an object from the ArrayList using DELETE request
    //Filtering the ArrayList according to the id passed on
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteTask(@PathVariable Integer id){
        for(int i=0; i<todolist.size();i++){
            if(todolist.get(i).getId()==id){
                 todolist.remove(i); //(index_to_delete)
            }
        }
    }

    //Updates an object from the ArrayList using UPDATE request
    //Filtering the ArrayList according to the id passed on and updating the new object of the TodoList.class
    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public void updateTask(@RequestBody TodoList todo, @PathVariable Integer id){
        for(int i=0; i<todolist.size();i++){
            if(todolist.get(i).getId()==id){
                todolist.set(i, todo); //(index_to_update, new_object)
            }
        }
    }
}
