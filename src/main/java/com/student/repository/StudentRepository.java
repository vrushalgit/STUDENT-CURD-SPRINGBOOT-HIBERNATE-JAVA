package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

	/**
	 * return studentmodel by student id
	 * @param studId
	 * @return studentModel
	 */
	public StudentModel findByStudId(Integer studId);
}
