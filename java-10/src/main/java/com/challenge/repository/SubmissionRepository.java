package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

	@Query("SELECT MAX(s.score) FROM Submission s JOIN s.id.challenge c WHERE c.id = ?1")
	Optional<BigDecimal> findHigherScoreByChallengeId(Long challengeId);

//	List<Submission> findByIdChallengeIdAndIdChallengeAccelerations(Long challengeId, Long accelerations);
	@Query("SELECT s FROM Submission s JOIN s.id.challenge.accelerations ac WHERE s.id.challenge.id = ?1 AND ac.id = ?2")
	List<Submission> findByChallegeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
