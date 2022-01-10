package com.thebeezgroup.autopint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebeezgroup.autopint.model.UserModel;
import com.thebeezgroup.autopint.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	public UserModel createUser(UserModel userModel ) {
		return testRepository.save(userModel);
	}
	
	public List<UserModel> getAllUsers () {
		return testRepository.findAll();
	}
	
	public UserModel updateUser(UserModel userModel) {
		return testRepository.save(userModel);
	}
	
	public List<UserModel> getUserById(Integer id) {
		return testRepository.findById(id).stream().toList();
	}
	
	public void deleteUser(Integer id) {
		testRepository.deleteById(id);
	}
}
