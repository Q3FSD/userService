package com.mentorondemand.userservice.controllers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.userservice.entities.Users;
import com.mentorondemand.userservice.services.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/v1/user")
public class UserController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody Object addUser(@Valid @RequestBody Users user) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Optional<Users> optional = userRepository.findByUserName(user.getUserName());
		HashMap<String, Boolean> map = new HashMap<>();

		if (optional.isPresent()) {
			// user exist
			map.put("userExist", true);
			return map;
		} else {
			// user not exist
			return userRepository.save(user);
		}
	}

	@PostMapping(path = "/login")
	public @ResponseBody Object login(@Valid @RequestBody Users user) {

		Optional<Users> optional = userRepository.findByUserName(user.getUserName());
		HashMap<String, Boolean> map = new HashMap<>();

		if (optional.isPresent()) {
			Users users = optional.get();
			if (users.getPassword().equals(user.getPassword())) {
				return users;
			} else {
				// wrong password
				map.put("wrongPassword", true);
				return map;
			}
		} else {
			// new register
			map.put("newRegister", true);
			return map;
		}
	}

	@PostMapping(path = "/reset")
	public @ResponseBody Object reset(@Valid @RequestBody Users user) {
		Optional<Users> optional = userRepository.findByUserName(user.getUserName());
		HashMap<String, Boolean> map = new HashMap<>();

		if (optional.isPresent()) {
			Users users = optional.get();
			users.setResetPassword(true);
			users.setResetPasswordDate(Calendar.getInstance().getTime());
			return userRepository.save(users);
		} else {
			// user not exist
			map.put("userExist", false);
			return map;
		}
	}

	@DeleteMapping(path = "/remove/{userName}")
	public @ResponseBody Object removeUser(@PathVariable(value = "userName") String userName) {
		return userRepository.deleteByUserName(userName);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Users> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}