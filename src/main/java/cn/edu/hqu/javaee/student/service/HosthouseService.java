package cn.edu.hqu.javaee.student.service;

import java.util.List;

import cn.edu.hqu.javaee.student.domain.entity.Hosthouse;

public interface HosthouseService {
	public List<Hosthouse> getMessageByUserName(String userNamehou);
	public void saveMessage(Hosthouse hosthouse);

}
