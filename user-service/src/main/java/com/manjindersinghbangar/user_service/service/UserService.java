package com.manjindersinghbangar.user_service.service;

import com.manjindersinghbangar.user_service.dto.UserDto;
import com.manjindersinghbangar.user_service.entity.User;
import com.manjindersinghbangar.user_service.exception.UserNotFoundException;
import com.manjindersinghbangar.user_service.repositry.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto input){
        final User createdUser = User.builder()
                .name(input.getName())
                .surname(input.getSurname())
                .email(input.getEmail())
                .address(input.getAddress())
                .alerting(input.isAlerting())
                .energyAlertingThreshold(input.getEnergyAlertingThreshold())
                .build();

        User saved = userRepository.save(createdUser);

        return toDto(saved);
    }

    private UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .address(user.getAddress())
                .alerting(user.isAlerting())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();
    }

    public UserDto getUserById(long id){
        return userRepository.findById(id).map(this::toDto).orElse(null);
    }

    public void updateUser(long id, UserDto userDto){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setAddress(userDto.getAddress());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAlerting(userDto.isAlerting());
        user.setEmail(userDto.getEmail());
        user.setEnergyAlertingThreshold(userDto.getEnergyAlertingThreshold());

        userRepository.save(user);
    }

    public void deleteUser(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }


}
