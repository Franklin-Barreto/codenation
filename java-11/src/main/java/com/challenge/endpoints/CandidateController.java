package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	private final CandidateServiceInterface candidateService;
	private final CandidateMapper candidateMapper = Mappers.getMapper(CandidateMapper.class);

	@Autowired
	public CandidateController(CandidateServiceInterface candidateService) {
		this.candidateService = candidateService;
	}

	@GetMapping("/{userId}/{companyId}/{accelerationId}")
	public ResponseEntity<CandidateDTO> findById(@PathVariable("userId") Long userId,
			@PathVariable("companyId") Long companyId, @PathVariable("accelerationId") Long accelerationId) {

		return this.candidateService.findById(userId, accelerationId, companyId)
				.map(c -> new ResponseEntity<CandidateDTO>(candidateMapper.map(c), HttpStatus.OK))
				.orElse(new ResponseEntity<CandidateDTO>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<CandidateDTO>> findByCompanyIdOrAccelerationId(
			@RequestParam(required = false) Long companyId, @RequestParam(required = false) Long accelerationId) {
		List<CandidateDTO> candidates = new ArrayList<CandidateDTO>();

		if (companyId != null) {
			candidates = candidateMapper.map(this.candidateService.findByCompanyId(companyId));
		}
		if (accelerationId != null) {
			candidates = candidateMapper.map(this.candidateService.findByAccelerationId(accelerationId));
		}
		return new ResponseEntity<List<CandidateDTO>>(candidates, HttpStatus.OK);
	}
}
