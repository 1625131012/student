package cn.edu.hqu.javaee.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.student.domain.entity.Hosthouse;
import cn.edu.hqu.javaee.student.repository.HostRepository;
import cn.edu.hqu.javaee.student.repository.HosthouseRepository;
import cn.edu.hqu.javaee.student.service.HosthouseService;

@Service
public class HosthouseServiceImpl implements HosthouseService{

	@Autowired
	HosthouseRepository hosthouseRepository;
	@Autowired
	HostRepository hostRepository;
	@Override
	public List<Hosthouse> getMessageByUserName(String userNamehou) {
		
		return hosthouseRepository.findMessageByUserId(hosthouseRepository.findByUserName(userNamehou).getId());
	}
	@Override
	public void saveMessage(Hosthouse hosthouse) {
		hosthouseRepository.save(hosthouse);
		
	}

}
