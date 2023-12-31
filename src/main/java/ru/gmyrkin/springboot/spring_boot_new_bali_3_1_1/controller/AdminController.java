package ru.gmyrkin.springboot.spring_boot_new_bali_3_1_1.controller;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gmyrkin.springboot.spring_boot_new_bali_3_1_1.model.User;
import ru.gmyrkin.springboot.spring_boot_new_bali_3_1_1.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String findAll(Model model) { // Model аналог MAP в который вставляем атрибуты
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }

    @GetMapping ("/user-create")
    public String createUserForm (User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser (User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new UsernameNotFoundException("user is not exists"));;
        model.addAttribute("user",user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
