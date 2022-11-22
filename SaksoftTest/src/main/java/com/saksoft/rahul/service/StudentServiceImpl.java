package com.saksoft.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saksoft.rahul.model.Student;
import com.saksoft.rahul.repository.StudentRepo;

@Service
public class StudentServiceImpl {
	
	@Autowired
	private StudentRepo repo;
	
	public String add(Student student) {
	repo.save(student);
	return "Data Saved Successfully";
	}
	
	public Student delete(Integer id) {
		Student studentobj = repo.findById(id).orElse(null);
		if(studentobj!=null) {
		repo.deleteById(id);
		}else {
			return studentobj;
		}
		return studentobj;
	}
	
	public List<Student> getAll(){
		List<Student> list = repo.findAll();
		return list;
	}
	
	
	public String update(Student s) {
		Student student = repo.findById(s.getId()).orElse(null);
		student.setFirstname(s.getFirstname());
		student.setLastname(s.getLastname());
		student.setEmail(s.getEmail());
		student.setAge(s.getAge());
		repo.save(student);
		return "Updated Successully";
	}
	
}
