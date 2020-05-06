package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
	
	@Query("SELECT c FROM Challenge c JOIN c.accelerations ac JOIN ac.candidates ca JOIN ca.id.user u WHERE ac.id=?1 AND u.id=?2")
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);
}
