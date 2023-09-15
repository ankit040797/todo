package com.geekster.UserTodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ManageController {

    @Autowired
    List<TodoManage>todoManageList;

    @PostMapping("addUser")
    public String add(@RequestBody TodoManage user){
        todoManageList.add(user);
        return "user added";
    }

    @GetMapping("getUser/userid/{userid}")
    public String getUser(@PathVariable TodoManage userid){
        return String.valueOf(todoManageList.get(userid.getUserId()));
    }

    @GetMapping("getAllUser")
    public List<TodoManage> getAllTodos(){
        return todoManageList;
    }


    @PutMapping("updateUserInfo/userId{userId}")
    public String updateUserInfo(@PathVariable Integer userId, @RequestParam String updateUser){
        for(TodoManage todo:todoManageList){
            if(todo.getUserId().equals(userId)){
                todo.getUserName().equals(updateUser);
                return "todo: " + userId + " update to "+ updateUser;
            }
        }
        return "Invalid id and UserName";
    }

    @DeleteMapping("deleteUser/userId/{userId}")
    public String remove(@PathVariable Integer userId){
        for(TodoManage todo:todoManageList){
            if(todo.getUserId().equals(userId)){
                todoManageList.remove(todo);
                return "todo: "+userId+" removed";
            }
        }
        return "Invalid Id";
    }


}
