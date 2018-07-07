package cn.edu.hqu.javaee.student.repository;

import cn.edu.hqu.javaee.student.domain.entity.Host;

public interface HostRepository {
	public void save(Host host);
	public Host findByUserName(String userNamehou);
}
