package cn.edu.hqu.javaee.student.repository;

import java.util.List;

import cn.edu.hqu.javaee.student.domain.entity.Hosthouse;

public interface HosthouseRepository {
	
	public List<Hosthouse> findMessageByUserId(Long userId);
	public void save(Hosthouse hosthouse);

}
