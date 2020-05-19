package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

	private final SubmissionServiceInterface submissionService;
	private final SubmissionMapper submissionMapper = Mappers.getMapper(SubmissionMapper.class);

	@Autowired
	public SubmissionController(SubmissionServiceInterface submissionService) {
		this.submissionService = submissionService;
	}

	@GetMapping
	public ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(
			@RequestParam(required = false) Long challengeId, @RequestParam(required = false) Long accelerationId) {
		List<Submission> submissions = new ArrayList<Submission>();
		if (challengeId != null && accelerationId != null) {
			submissions = submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
		}
		return new ResponseEntity<List<SubmissionDTO>>(submissionMapper.map(submissions), HttpStatus.OK);
	}
}
