package cn.edu.hqu.javaee.student.service;

import cn.edu.hqu.javaee.student.domain.entity.Student;

public interface StudentService {
	public Student login(String userNamestu,String passwordstu);
	public boolean register(Student student);
	public Student getUserDetail(String userNamestu);
}
