package com.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.StudentModel;
import com.student.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "")
	public ResponseEntity<Object> getAllStudent() {
		return ResponseEntity.ok(studentService.getAllStudent());
	}

	@GetMapping(path = "/{studid}")
	public ResponseEntity<Object> getStudentById(@PathVariable(name = "studid") Integer studId) {
		return ResponseEntity.ok(studentService.getStudentById(studId));
	}

	@PostMapping(path = "/add") 
	public ResponseEntity<Map<String, String>> addStudent(@RequestBody StudentModel student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@PutMapping(path = "/edit/{studid}")
	public ResponseEntity<Object> editStudent(@RequestBody StudentModel student,
			@PathVariable(name = "studid") Integer studId) {
		return ResponseEntity.ok(studentService.editStudent(student, studId));
	}

	@DeleteMapping(path = "/delete/{studid}")
	public ResponseEntity<Object> deleteStudent(@PathVariable(name = "studid") Integer studId) {
		return ResponseEntity.ok(studentService.deleteStudent(studId));
	}

}
