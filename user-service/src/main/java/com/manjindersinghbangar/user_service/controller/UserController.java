package com.manjindersinghbangar.user_service.controller;

import com.manjindersinghbangar.user_service.dto.UserDto;
import com.manjindersinghbangar.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto created = userService.createUser(userDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userDto =  userService.getUserById(id);
        if(userDto == null){
            return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
}
