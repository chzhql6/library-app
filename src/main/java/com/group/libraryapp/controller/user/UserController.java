package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.reponse.UserResponse;
import com.group.libraryapp.dto.user.reponse.UserUpdateRequest;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService){
        this.userService = userService;
    }

    @PostMapping("/user") //POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
//        users.add(new User(request.getName(), request.getAge()));
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }



}
