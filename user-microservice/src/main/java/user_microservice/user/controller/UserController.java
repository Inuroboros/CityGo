package user_microservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_microservice.user.model.User;
import user_microservice.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> findAllUsers(){return userService.findAllUsers();}

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {return userService.findUserById(id);}

    @GetMapping("/names/{name}")
    public Optional<User> findUserByName(@PathVariable String name){return userService.findUserByName(name);}

    @GetMapping("/emails/{email}")
    public Optional<User> findUserByEmail(@PathVariable String email){return userService.findUserByEmail(email);}

}
