package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.User;

public interface UserServiceInterface extends ServiceInterface<User> {

	Optional<User> findById(Long userId);

	List<User> findByAccelerationName(String name);

	List<User> findByCompanyId(Long companyId);

}
