package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserServiceInterface userService;

	@Autowired
	public UserController(UserServiceInterface userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {

		return userService.findById(id).map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
				.orElse(new ResponseEntity<User>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(
			@RequestParam(required = false) String accelerationName, @RequestParam(required = false) Long companyId) {
		List<User> users = new ArrayList<User>();
		if (accelerationName != null) {
			users = this.userService.findByAccelerationName(accelerationName);
		}
		if (companyId != null) {
			users = this.userService.findByCompanyId(companyId);
		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
