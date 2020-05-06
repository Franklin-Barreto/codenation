package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT DISTINCT u FROM User u JOIN Candidate c ON u.id = c.id.user JOIN Acceleration a ON a.id = c.id.acceleration WHERE a.name = ?1")
	List<User> findByAccelerationName(String name);

	@Query("SELECT DISTINCT u FROM User u JOIN Candidate c ON u.id = c.id.user JOIN Company co ON co.id = c.id.company WHERE co.id = ?1")
	List<User> findByCompanyId(Long id);
}
