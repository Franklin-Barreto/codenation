package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private final CompanyServiceInterface companyServiceInterface;

	@Autowired
	public CompanyController(CompanyServiceInterface companyServiceInterface) {
		this.companyServiceInterface = companyServiceInterface;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable("id")Long id) {
		return this.companyServiceInterface.findById(id).map(c -> new ResponseEntity<Company>(c, HttpStatus.OK))
				.orElse(new ResponseEntity<Company>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<Company>> findByAccelerationIdOrUserId(
			@RequestParam(required = false) Long accelerationId, @RequestParam(required = false) Long userId) {
		List<Company> companies = new ArrayList<Company>();
		if (accelerationId != null) {
			companies = this.companyServiceInterface.findByAccelerationId(accelerationId);
		}
		if (userId != null) {
			companies = this.companyServiceInterface.findByUserId(userId);
		}
		return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
	}

}
