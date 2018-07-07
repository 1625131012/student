package cn.edu.hqu.javaee.student.service;

import cn.edu.hqu.javaee.student.domain.entity.Host;

public interface HostService {
	public Host login(String userNamehou,String passwordhou);
	public boolean register(Host host);
	public Host getUserDetail(String userNamehou);
}
