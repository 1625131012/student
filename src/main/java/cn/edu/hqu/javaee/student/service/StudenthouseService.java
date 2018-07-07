package cn.edu.hqu.javaee.student.service;

import java.util.List;

import cn.edu.hqu.javaee.student.domain.entity.Studenthouse;

public interface StudenthouseService {
	public List<Studenthouse> getMessageByUserName(String userNamestu);
	public void saveMessage(Studenthouse studenthouse);

}
