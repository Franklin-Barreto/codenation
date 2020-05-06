package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

	public Acceleration findByName(String name);

	public List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

}
