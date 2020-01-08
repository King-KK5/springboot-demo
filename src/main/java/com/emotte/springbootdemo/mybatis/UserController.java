package com.emotte.springbootdemo.mybatis;

import com.emotte.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${my.max}")
    private String name;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getOne/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @ResponseBody
    @RequestMapping("/get")
    public Object getUserPhone(){
        return userService.getUserPhone();
    }

    @RequestMapping("/list")
    public String getList(){

        String s = new String();
        s = name;
        return "list";
    }


}
