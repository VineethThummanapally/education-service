package com.dnb.educationservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.exceptions.IdNotFoundException;
import com.dnb.educationservice.mapper.RequestToEntityMapper;
import com.dnb.educationservice.payload.request.EducationRequest;
import com.dnb.educationservice.service.EducationService;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	@Autowired
	private EducationService educationService;

	@Autowired
	private RequestToEntityMapper mapper;

	@PostMapping("/create") // combination of @RequestMapping + PostMethod => spring 4.3.
	public ResponseEntity<?> creatEducation(@RequestBody EducationRequest educationRequest) {
		Education education1 = mapper.getEducationEntityObject(educationRequest);
		try {
			Education education2 = educationService.createEducationDetails(education1);
			return new ResponseEntity<Education>(education2, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{educationId}")
	public ResponseEntity<?> getEducationById(@PathVariable("educationId") String educationId)
			throws IdNotFoundException {

		Optional<Education> requestedEducation = educationService.getEducationDetailsById(educationId);
		if (requestedEducation.isPresent())
			return ResponseEntity.ok(requestedEducation.get());
		else {
			throw new IdNotFoundException("Requested Id Info Not found");
		}
	}

	@GetMapping("/allEducations")
	public ResponseEntity<?> getAllEducations() throws IdNotFoundException {
		List<Education> allEducations = (List<Education>) educationService.getAllEducationDetails();

		if (allEducations.size() != 0)
			return ResponseEntity.ok(allEducations);
		else {
			throw new IdNotFoundException("No Educaitons Found ");
		}
	}

	@DeleteMapping("/{educationId}")
	public ResponseEntity<?> deleteEducationDetailsById(@PathVariable String educationId) throws IdNotFoundException {

		if (educationService.checkEducationExistsById(educationId)) {
			educationService.deleteEducationDetailsById(educationId);
			return ResponseEntity.noContent().build();
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
}
