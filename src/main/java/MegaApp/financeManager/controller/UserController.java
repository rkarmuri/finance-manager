package MegaApp.financeManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import MegaApp.financeManager.entity.User;
import MegaApp.financeManager.service.UserService;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to Finance Manager - User Service is running!";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/users/{email}")
    public Optional<String> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email).map(User::getName);
    }
}
