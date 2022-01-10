package com.thebeezgroup.autopint;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebeezgroup.autopint.model.UserModel;
import com.thebeezgroup.autopint.service.TestService;


@SpringBootTest
class AutopintApplicationTests {

	@Autowired
	private TestService testService;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser() {
		UserModel user = new UserModel();
		user.setEmail("test@test.com");
		user.setPassword("test");
		
		//creation de l'utilisateur
		UserModel userCreate = testService.createUser(user);
		
		//vérification de l'existance de l'utilisateur
		UserModel userModel = testService.getUserById(userCreate.getId()).stream().findFirst().get();
		Assert.assertEquals(userModel.getId(), userCreate.getId()); 
	}
}
