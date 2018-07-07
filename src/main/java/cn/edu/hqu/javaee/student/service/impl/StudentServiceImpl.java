package cn.edu.hqu.javaee.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.student.domain.entity.Student;
import cn.edu.hqu.javaee.student.repository.StudentRepository;
import cn.edu.hqu.javaee.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student login(String userNamestu, String passwordstu) {
		Student student;
		
		if((student=studentRepository.findByUserName(userNamestu))!=null 
				&& student.getPasswordstu().equals(passwordstu)) {
			System.out.println(student.getUserNamestu());
			return student;
		}
		return null;
	}

	@Override
	public boolean register(Student stuednt) {
		if((studentRepository.findByUserName(student.getUserName()))==null) {
			studentRepository.save(student);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getUserDetail(String userNamestu) {
		return studentRepository.findByUserName(userNamestu);
	}

}
