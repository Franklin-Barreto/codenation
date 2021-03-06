package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateService implements CandidateServiceInterface {

	private CandidateRepository candidateRepository;

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		return candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		return candidateRepository.findByIdCompanyId(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		return candidateRepository.findByIdAccelerationId(accelerationId);
	}

}
