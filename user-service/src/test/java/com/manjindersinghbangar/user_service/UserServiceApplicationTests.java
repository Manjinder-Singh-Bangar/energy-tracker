package com.manjindersinghbangar.user_service;

import com.manjindersinghbangar.user_service.entity.User;
import com.manjindersinghbangar.user_service.repositry.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserServiceApplicationTests {
	public static final int NUMBER_OF_USERS = 10;
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createUsers(){
		for (int i = 0; i < NUMBER_OF_USERS; i++){
			var user = User.builder()
					.name("User" + i)
					.address((i *10) + "Example ST")
					.surname("surname"+ i)
					.energyAlertingThreshold(1000.0 + i)
					.email("user" + i + "@example.com")
					.alerting(i % 2 == 0)
					.build();
			userRepository.save(user);
		}

		log.info("User repo has been populated");
	}

}
