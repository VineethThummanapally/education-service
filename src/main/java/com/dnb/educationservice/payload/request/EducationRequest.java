package com.dnb.educationservice.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EducationRequest {
	
	@NotBlank(message = "School name must be provided")
	private String school;

	@NotBlank(message = "Degree must be provided")
	private String degree;

	private String fieldOfStudy;

	private String fromDate;

	private String toDate;

	private String programDescription;
	
	private String profileId;
}
