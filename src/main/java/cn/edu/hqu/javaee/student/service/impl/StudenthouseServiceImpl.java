package cn.edu.hqu.javaee.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.student.domain.entity.Studenthouse;
import cn.edu.hqu.javaee.student.repository.StudentRepository;
import cn.edu.hqu.javaee.student.repository.StudenthouseRepository;
import cn.edu.hqu.javaee.student.service.StudenthouseService;

@Service
public class StudenthouseServiceImpl implements StudenthouseService{

	@Autowired
	StudenthouseRepository studenthouseRepository;
	@Autowired
	StudentRepository studentRepository;
	@Override
	public List<Studenthouse> getMessageByUserName(String userNamestu) {
		
		return studenthouseRepository.findMessageByUserId(studenthouseRepository.findByUserName(userNamestu).getId());
	}
	@Override
	public void saveMessage(Studenthouse studenthousemessage) {
		studenthouseRepository.save(studenthouse);
		
	}

}
