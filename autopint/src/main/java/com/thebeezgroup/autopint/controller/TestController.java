package com.thebeezgroup.autopint.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thebeezgroup.autopint.model.UserModel;
import com.thebeezgroup.autopint.service.TestService;

@RestController
@CrossOrigin
public class TestController {
	
	@Autowired
	private TestService testService;
	
	/**
	 * Test de vie de l'API.
	 * @return la date et l'heure.
	 */
	@GetMapping("/healt")
	public Date healt() {
		return new Date();
	}
	
	/**
	 * Path API Rest de la création d'un utilisateur
	 * @param userModel
	 * @return l'utilisateur crée
	 */
	@PostMapping("/users")
	public UserModel createUser(@RequestBody UserModel userModel) {
		return testService.createUser(userModel);
	}
	
	/**
	 * Récupère la liste de tous les utilisateur de la BDD si aucun id n'est indiqué.
	 * Sinon récupère l'user avec son ID.
	 * @return
	 */
	@GetMapping("/users")
	public List<UserModel> getUsers(@RequestParam @Nullable Integer id) {
		if (id == null) {
			return testService.getAllUsers();			
		}else {
			return testService.getUserById(id);
		}
	}
	
	/**
	 * Mise à jour d'un utilisateur
	 * @param userModel
	 * @return
	 */
	@PutMapping("/users")
	public UserModel updateUser (@RequestBody UserModel userModel) {
		return testService.updateUser(userModel);
	}
	
	/**
	 * Suppression d'un utilisateur avec son ID
	 * @param id sous la forme ?id=0
	 */
	@DeleteMapping("/users")
	public void deleteUser(@RequestParam Integer id) {
		testService.deleteUser(id);
	}

}
