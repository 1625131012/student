package cn.edu.hqu.javaee.student.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.student.domain.entity.Studenthouse;
import cn.edu.hqu.javaee.student.repository.StudenthouseRepository;

@Repository
public class StudenthouseRepositoryImpl implements StudenthouseRepository {

	private static final String SQL_SAVE_MESSAGE = "insert into studenthouse (address,type,people,money,id) values(?,?,?,?,?)";
	private static final String SQL_FIND_MESSAGE_BY_HQUERID = "select address,type,people,money,id from studenthouse where userstudentId=?";
	@Autowired
	private JdbcOperations jdbcOperations;
	@Override
	public List<Studenthouse> findMessageByUserId(Long userId) {
		List<Studenthouse> list=new ArrayList<Studenthouse>();
		list=jdbcOperations.query(SQL_FIND_MESSAGE_BY_HQUERID, new RowMapper<Studenthouse>() {

			@Override
			public Studenthouse mapRow(ResultSet rs, int rowNum) throws SQLException {
				Studenthouse studenthouse=new Studenthouse();
				studenthouse.setAddress(rs.getString("address"));
				studenthouse.setType(rs.getString("type"));
				studenthouse.setPeople(rs.getLong("people"));
				studenthouse.setMoney(rs.getLong("money"));
				studenthouse.setId(rs.getLong("id"));

				return studenthouse;
			}
			
		}, userId);
		return list;
	}
	@Override
	public void save(Studenthouse studenthouse) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_SAVE_MESSAGE, studenthouse.getAddress(),studenthouse.getType(),studenthouse.getPeople(),studenthouse.getMoney(),studenthouse.getId());
	}

}
