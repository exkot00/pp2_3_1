package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/users")

public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("userList", userDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user",userDAO.show(id));
        return "users/show";
    }
//    @GetMapping("new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "users/new";
//    }
    @GetMapping("new")
    public String newUser(User user) {
    return "users/new";
}

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id) {
        model.addAttribute("user", userDAO.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user) {
        userDAO.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }
}
