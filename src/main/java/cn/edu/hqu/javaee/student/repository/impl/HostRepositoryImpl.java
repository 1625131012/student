package cn.edu.hqu.javaee.student.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.student.domain.entity.Host;
import cn.edu.hqu.javaee.student.repository.HostRepository;

@Repository
public class HostRepositoryImpl implements HostRepository {
	private static final String SQL_INSERT_HQUER = "insert into host (firstname, lastname, address, phonehou, usernamehou, passwordhou) values(?,?,?,?,?,?)";
	private static final String SQL_FIND_HQUER = "select firstname, lastname, address, phonehou, usernamehou, passwordhou from host where usernamehou=?";
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public void save(Host host) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_HQUER, host.getFirstName(), host.getLastName(), host.getPhonehou(),
				host.getAddress(),host.getUserNamehou(),host.getPasswordhou());
	}

	@Override
	public Host findByUserName(String userNamehou) {
		List<Host> list = new ArrayList<Host>();
		list = jdbcOperations.query(SQL_FIND_HQUER, new RowMapper<Host>() {

			@Override
			public Host mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Host host = new Host();
				host.setFirstName(rs.getString("firstname"));
				host.setLastName(rs.getString("lastname"));
				host.setPhonehou(rs.getString("phonehou"));
				host.setAddress(rs.getString("address"));
				host.setUserNamehou(rs.getString("usernamehou"));
				host.setPasswordhou(rs.getString("passwordhou"));
				return host;
			}

		}, userNamehou);
		
		if (list.size() >= 1) {
			return list.get(0);
		} else
			return null;
	}
}
