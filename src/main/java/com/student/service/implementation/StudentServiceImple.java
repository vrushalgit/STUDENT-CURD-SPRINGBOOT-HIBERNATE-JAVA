package com.student.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.StudentException;
import com.student.model.StudentModel;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Map<String, String> addStudent(StudentModel student) {
		Map<String, String> msg = new HashMap<String, String>();

		try {
			if (student.equals(null))
				throw new StudentException("Please provide valid data");
			else {
				if (studentRepository.save(student).equals(null))
					msg.put("msg", "Record not Added");
				else
					msg.put("msg", "Student Added Successfull");
			}
		} catch (StudentException se) {
			msg.put("msg", se.getMessage());
		} catch (Exception e) {
		}

		return msg;
	}

	@Override
	public Map<String, String> editStudent(StudentModel student, Integer id) {
		Map<String, String> msg = new HashMap<String, String>();

		try {
			if (student.equals(null))
				throw new StudentException("Please provide valid data");
			else {

				Optional<StudentModel> o = studentRepository.findById(id);
				o.ifPresent((stud) -> {
					stud.setStudFirstName(student.getStudFirstName());
					stud.setStudLastName(student.getStudLastName());
					stud.setDateOfBirth(student.getDateOfBirth());
					stud.setGender(student.getGender());
					stud.setStatus(student.getStatus());

					if (studentRepository.save(student).equals(null))
						msg.put("msg", "Record not Updated");
					else
						msg.put("msg", "Student Updated Successfull");
				});
				o.orElseThrow(() -> {
					return new StudentException("Record not found");
				});
			}
		} catch (StudentException se) {
			msg.put("msg", se.getMessage());
		} catch (Exception e) {
		}

		return msg;
	}

	@Override
	public Map<String, String> deleteStudent(Integer studId) {
		Map<String, String> msg = new HashMap<String, String>();
		if (studId.equals(null))
			msg.put("msg", "Record Not found");
		else {
			try {
				Optional<StudentModel> o = studentRepository.findById(studId);
				o.ifPresent(stud -> {
					studentRepository.delete(stud);
					msg.put("msg", "Record Deleted Successfully");
				});
				o.orElseThrow(() -> {
					return new StudentException("Record Not Deleted");
				});
			} catch (StudentException se) {
				msg.put("msg", se.getMessage());
			}
		}

		return msg;
	}

	@Override
	public List<StudentModel> getAllStudent() {
		List<StudentModel> studentList = new ArrayList<StudentModel>();

		studentList = studentRepository.findAll();
		if (studentList.stream().count() == 0)
			return null;
		return studentList;
	}

	@Override
	public StudentModel getStudentById(Integer studeId) {

		StudentModel student = null;
		if (!studeId.equals(null))
			return studentRepository.findById(studeId).get();

		return student;
	}

}
