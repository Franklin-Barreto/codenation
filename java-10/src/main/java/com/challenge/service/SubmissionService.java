package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface {

	private final SubmissionRepository submissionRepository;

	@Autowired
	public SubmissionService(SubmissionRepository submissionRepository) {
		this.submissionRepository = submissionRepository;
	}

	@Override
	public Submission save(Submission object) {
		return this.submissionRepository.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		return this.submissionRepository.findHigherScoreByChallengeId(challengeId).orElse(BigDecimal.ZERO);
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return this.submissionRepository.findByChallegeIdAndAccelerationId(challengeId, accelerationId);
	}

}
