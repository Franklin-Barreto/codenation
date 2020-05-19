package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

	private final ChallengeServiceInterface challengeServiceInterface;

	@Autowired
	public ChallengeController(ChallengeServiceInterface challengeServiceInterface) {
		this.challengeServiceInterface = challengeServiceInterface;
	}

	@GetMapping
	public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(@RequestParam Long accelerationId,
			@RequestParam Long userId) {
		return new ResponseEntity<List<Challenge>>(
				this.challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId), HttpStatus.OK);
	}

}
