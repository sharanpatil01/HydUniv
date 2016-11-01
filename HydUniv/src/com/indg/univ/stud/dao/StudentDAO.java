package com.indg.univ.stud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.indg.univ.stud.Student;

@Repository
public interface StudentDAO {
	public abstract void insert(Student student);
	public abstract Student findById(String id);
	List<Student> findAllStudent();
	void removeStudentById(String stid);
}
