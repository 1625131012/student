package cn.edu.hqu.javaee.student.repository;

import cn.edu.hqu.javaee.student.domain.entity.Student;

public interface StudentRepository {
	public void save(Student student);
	public Student findByUserName(String userNamestu);
}
