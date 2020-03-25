package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public String insert(Student student) {
		if(studentDao.insert(student)) {
			return "Success";
		}else {
			return "Failure";
		}
	}
	public List<Student> getAll(){
		return studentDao.getAll();
	}
	public String update(int id, String name, int marks) {
		if(studentDao.update(id,name,marks)) {
			return "Success";
		}else {
			return "Failure";
		}		
	}
	
	public String delete(int id) {
		if(studentDao.delete(id)) {
			return "Success";
		}else {
			return "Failure";
		}
	}
}
