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

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        try{
            userService.updateUser(id, userDto);
            return ResponseEntity.ok("User has been updated");
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return null;
        }
    }
}
