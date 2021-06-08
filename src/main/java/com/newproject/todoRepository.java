package com.newproject;

import com.newproject.model.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface todoRepository extends CrudRepository<TodoList, Integer> {

}
