package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
@Service
public class CandidateService implements CandidateServiceInterface {

	private final CandidateRepository candidateRepository;

	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}

	@Override
	public Candidate save(Candidate object) {
		return this.candidateRepository.save(object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		return this.candidateRepository.findById(id);
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		//return this.candidateRepository.findById_UserId_CompanyId_AccelerationId(userId, companyId, accelerationId);
		return null;
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		return this.candidateRepository.findById_Company(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		System.out.println("Teste"+accelerationId);
		return this.candidateRepository.findById_AccelerationId(accelerationId);
	}

}
