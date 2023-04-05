package com.student.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data

public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	private Integer studId;
	
	@Column(name = "stud_firstname",length = 20,nullable = false)
	private String studFirstName;
	
	@Column(name = "stud_lastname",length = 20,nullable = false)
	private String studLastName;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender",columnDefinition ="enum('M','F','O')",nullable=false)
	private GenderEnum gender;

	@Column(name = "status",nullable = true)
	private Boolean status;
}
