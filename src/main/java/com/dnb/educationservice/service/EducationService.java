package com.dnb.educationservice.service;

import java.util.Optional;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.exceptions.IdNotFoundException;

public interface EducationService {
	public Education createEducationDetails(Education education);

	public Optional<Education> getEducationDetailsById(String educationId);

	public boolean deleteEducationDetailsById(String educationId) throws IdNotFoundException;

	public boolean checkEducationExistsById(String educationId);
	
	public Iterable<Education> getAllEducationDetails();
}
