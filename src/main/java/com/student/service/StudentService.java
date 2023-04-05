package com.student.service;

import java.util.List;
import java.util.Map;

import com.student.model.StudentModel;


public interface StudentService {

	/**
	 * this method gets StudentModel as a argument and return Map<String, String> 
	 * 
	 * @param student
	 * @return Map<String, String>
	 */
	Map<String, String> addStudent(StudentModel student);

	/**
	 * Edit student record by id
	 * 
	 * @param student
	 * @param id
	 * @return
	 */
	Map<String, String> editStudent(StudentModel student, Integer id);

	/**
	 * Delete student record by id
	 * 
	 * @param studId
	 * @return Map<String, String>
	 */
	Map<String, String> deleteStudent(Integer studId);

	/**
	 * Display all students
	 * 
	 * @return list
	 */
	List<StudentModel> getAllStudent();

	/**
	 * Return record by student id
	 * 
	 * @param studeId
	 * @return StudentModel
	 */

	StudentModel getStudentById(Integer studeId);

}
