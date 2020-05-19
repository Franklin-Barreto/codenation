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

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

	private final AccelerationServiceInterface accelerationService;

	@Autowired
	public AccelerationController(AccelerationServiceInterface accelerationService) {
		this.accelerationService = accelerationService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {

		return accelerationService.findById(id).map(a -> new ResponseEntity<Acceleration>(a, HttpStatus.OK))
				.orElse(new ResponseEntity<Acceleration>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<Acceleration>> findByCompanyId(@RequestParam(required = false) Long companyId) {
		List<Acceleration> accelerations = new ArrayList<Acceleration>();
		if (companyId != null) {
			accelerations = this.accelerationService.findByCompanyId(companyId);
		}
		return new ResponseEntity<List<Acceleration>>(accelerations, HttpStatus.OK);
	}

}
