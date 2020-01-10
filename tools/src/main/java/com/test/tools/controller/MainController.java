package com.test.tools.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.tools.entity.User;
import com.test.tools.service.UserService;

@Controller
@RequestMapping("/test")
public class MainController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/testController")
    public String testController(){

        return "success";
    }

    @ResponseBody
    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        List<User> lists = userService.queryAll();
        return lists;
    }

    @ResponseBody
    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById(@RequestParam int id){
        User user = userService.findUserById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("uid", user.getUid());
        result.put("uname", user.getUserName());
        result.put("pass", user.getPassWord());
        result.put("salary", user.getSalary());
        return result;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(){
        User user = new User();
        user.setUid(1);
        user.setUserName("cat");
        user.setPassWord("miaomiao");
        user.setSalary(4000);

        int result = userService.updateUser(user);

        if(result != 0){
            return "update user success";
        }

        return "fail";
    }
    
    @ResponseBody
    @RequestMapping("/insertUser")
    public String insertUser(@RequestParam String username, String password, String salary){
        System.out.println("username====="+username);
        System.out.println("password====="+password);
        System.out.println("salary====="+salary);
        User user = new User();
        user.setUid(1);
        user.setUserName(username);
        user.setPassWord(password);
        user.setSalary(Integer.parseInt(salary));
    	
        int result = userService.insertUser(user);
        System.out.println("result====="+result);
        if(result != 0){
            return "insert user success";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id){
        int result = userService.deleteUserById(id);
        if(result != 0){
            return "delete success";
        }
        return "delete fail";
    }
}
