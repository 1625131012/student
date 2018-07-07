package cn.edu.hqu.javaee.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.student.domain.entity.Host;
import cn.edu.hqu.javaee.student.repository.HostRepository;
import cn.edu.hqu.javaee.student.service.HostService;

@Service
public class HostServiceImpl implements HostService{
	@Autowired
	HostRepository hostRepository;

	@Override
	public Host login(String userNamehou, String passwordhou) {
		Host host;
		
		if((host=hostRepository.findByUserName(userNamehou))!=null 
				&& host.getPasswordhou().equals(passwordhou)) {
			System.out.println(host.getUserNamehou());
			return host;
		}
		return null;
	}

	@Override
	public boolean register(Host host) {
		if((hostRepository.findByUserName(host.getUserNamehou()))==null) {
			hostRepository.save(host);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Host getUserDetail(String userNamehou) {
		return hostRepository.findByUserName(userNamehou);
	}

}
