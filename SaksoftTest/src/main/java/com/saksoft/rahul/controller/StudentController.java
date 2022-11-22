package com.saksoft.rahul.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.rahul.exception.EmptyException;
import com.saksoft.rahul.exception.GlobalException;
import com.saksoft.rahul.model.Student;
import com.saksoft.rahul.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	private final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServiceImpl service;

	@PutMapping("/add")
	public ResponseEntity<String> addemp(@RequestBody Student student) {
		log.info("Add operation Started");
		if (student.getFirstname() != null) {
			log.info("Add operation Done");
			String str = service.add(student);
			return ResponseEntity.ok(str);

		} else {
			log.info("Add operation No Data Provided");
			return new ResponseEntity<String>("Please Enter data", HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteemp(@PathVariable Integer id) {
		log.info("Delete operation Started");
		Student objstudent = service.delete(id);

		if (objstudent != null) {
			log.info("Delete operation Done");
			return ResponseEntity.ok("Record Deleted Successfully");
		} else {
			log.info("delete operation No Data Provided to delete");
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getall")
	public List<Student> getemplist() {
		log.info("FindAll operation Started");
		List<Student> list = service.getAll();
		return list;
	}

	@PostMapping("/update")
	public String updateemp(@RequestBody Student s) {
		log.info("Update operation Started");
		return (service.update(s)); 
	}

}