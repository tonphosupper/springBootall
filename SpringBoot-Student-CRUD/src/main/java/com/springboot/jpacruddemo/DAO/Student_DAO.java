package com.springboot.jpacruddemo.DAO;

import java.util.List;

import com.springboot.jpacruddemo.model.Student;



public interface Student_DAO {

	public boolean saveStudent(Student student);
	public List<Student> getStudents();
	public boolean deleteStudent(Student student);
	public List<Student> getStudentByID(Student student);
	public boolean updateStudent(Student student);
}
