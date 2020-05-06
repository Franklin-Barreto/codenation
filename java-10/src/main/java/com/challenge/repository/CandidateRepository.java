package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
	@Query("SELECT c FROM Candidate c WHERE c.id.user =?1 and c.id.company = ?2 and c.id.acceleration =?3 ")
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);
	
	public List<Candidate> findById_CompanyId(Long companyId);
	
	public List<Candidate> findById_AccelerationId(Long acceleration);
}
