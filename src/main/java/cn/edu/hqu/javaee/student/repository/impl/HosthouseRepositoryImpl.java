package cn.edu.hqu.javaee.student.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.student.domain.entity.Hosthouse;
import cn.edu.hqu.javaee.student.repository.HosthouseRepository;

@Repository
public class HosthouseRepositoryImpl implements HosthouseRepository {

	private static final String SQL_SAVE_MESSAGE = "insert into hosthouse (address,type,people,money,id,rent) values(?,?,?,?,?)";
	private static final String SQL_FIND_MESSAGE_BY_HQUERID = "select address,type,people,money,id,rent from hosthouse where userhostId=?";
	@Autowired
	private JdbcOperations jdbcOperations;
	@Override
	public List<Hosthouse> findMessageByUserId(Long userId) {
		List<Hosthouse> list=new ArrayList<Hosthouse>();
		list=jdbcOperations.query(SQL_FIND_MESSAGE_BY_HQUERID, new RowMapper<Hosthouse>() {

			@Override
			public Hosthouse mapRow(ResultSet rs, int rowNum) throws SQLException {
				Hosthouse hosthouse=new Hosthouse();
				hosthouse.setAddress(rs.getString("address"));
				hosthouse.setType(rs.getString("type"));
				hosthouse.setPeople(rs.getLong("people"));
				hosthouse.setMoney(rs.getLong("money"));
				hosthouse.setId(rs.getLong("id"));
				hosthouse.setRent(rs.getString("rent"));
				return hosthouse;
			}
			
		}, userId);
		return list;
	}
	@Override
	public void save(Hosthouse hosthouse) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_SAVE_MESSAGE, hosthouse.getAddress(),hosthouse.getType(),hosthouse.getPeople(),hosthouse.getMoney(),hosthouse.getId(),hosthouse.getRent());
	}

}
