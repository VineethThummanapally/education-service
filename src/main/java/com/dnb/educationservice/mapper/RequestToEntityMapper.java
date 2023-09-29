package com.dnb.educationservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.payload.request.EducationRequest;
import com.dnb.educationservice.utils.Converters;

@Component
public class RequestToEntityMapper {

	@Autowired
	Converters converter;

	public Education getEducationEntityObject(EducationRequest educationRequest) {

		Education education = new Education();
		education.setProgramDescription(educationRequest.getProgramDescription());
		education.setDegree(educationRequest.getDegree());
		education.setFieldOfStudy(educationRequest.getFieldOfStudy());
		education.setFromDate(educationRequest.getFromDate());
		education.setToDate(educationRequest.getToDate());
		education.setSchool(educationRequest.getSchool());
		education.setProfileId(educationRequest.getProfileId());
		return education;
	}
}
