package cn.edu.hqu.javaee.student.repository;

import java.util.List;

import cn.edu.hqu.javaee.student.domain.entity.Studenthouse;

public interface StudenthouseRepository {
	
	public List<Studenthouse> findMessageByUserId(Long userId);
	public void save(Studenthouse studenthouse);

}
