package com.dnb.educationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.educationservice.dto.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, String> {

}
