package com.example.springmvc_practice.controller;

import com.example.springmvc_practice.models.user;
import com.example.springmvc_practice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/admin")
public class UserController {
    private UserService userService;

    public UserController(UserService theUser) {
        userService = theUser;
    }
    @GetMapping("/home-page")
    public String getAll(Model model) {
        List<user> userList = userService.findAll();
        model.addAttribute("listData",userList);
        return "Admin/admin-home";
    }

    @GetMapping("/add-user")
    public String AddProduct(
            Model model
    ) {
        user NewUser = new user();
        model.addAttribute("the_user", NewUser);
        return "Admin/add-form";
    }

    @GetMapping("/edit-user/{id}")
    private String loadProduct(@PathVariable(value = "id") Integer id, Model model)
            throws Exception {

        user theUser = userService.findById(id);

        model.addAttribute("the_user", theUser);

        return "Admin/edit-form";
    }

    @PostMapping("/update-user/{id}")
    public String PutProduct(
            @PathVariable(value = "id") Integer id, @ModelAttribute("the_user") user userDetail,
            Model model
    ) {
        user theStarbuck = userService.findById(id);

        theStarbuck.setName(userDetail.getName());
        theStarbuck.setAge(userDetail.getAge());
        theStarbuck.setSalary(userDetail.getSalary());

        userService.save(theStarbuck);
        model.addAttribute("listData", userService.findAll());
        return "redirect:/admin/home-page";
    }

    @GetMapping("/delete-user/{id}")
    public String DeleteProduct(
            @PathVariable(value = "id") Integer id,
            Model model
    ) {

        userService.deleteById(id);
        model.addAttribute("listData", userService.findAll());
        return "redirect:/admin/home-page";
    }

    @PostMapping("/new-user")
    public String NewProduct(@ModelAttribute("the_user") user userDetail, Model model
    ) {
    user Newuser = new user(userDetail.getName(), userDetail.getAge(), userDetail.getSalary());
        userService.save(Newuser);
        model.addAttribute("listData", userService.findAll());
        return "redirect:/admin/home-page";
    }
}
