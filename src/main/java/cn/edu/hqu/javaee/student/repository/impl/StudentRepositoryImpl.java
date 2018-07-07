package cn.edu.hqu.javaee.student.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.student.domain.entity.Student;
import cn.edu.hqu.javaee.student.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	private static final String SQL_INSERT_HQUER = "insert into hquer (firstname, lastname, address_stu, phonestu, birthday, sex, usernamestu, passwordstu) values(?,?,?,?,?,?,?,?)";
	private static final String SQL_FIND_HQUER = "select firstname, lastname, address_stu, phonestu, birthday, sex, usernamestu, passwordstu from student where usernamestu=?";
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_HQUER, student.getFirstName(),student.getLastName(),student.getAddress(),student.getPhonestu(),student.getBirthday(),student.getSex(),student.getUserNamestu(),student.getPasswordstu());
	}

	@Override
	public Student findByUserName(String userNamestu) {
		List<Student> list = new ArrayList<Student>();
		list = jdbcOperations.query(SQL_FIND_HQUER, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setAddress(rs.getString("address"));
				student.setPhonestu(rs.getString("phonestu"));
				student.setBirthday(rs.getString("birthday"));
				student.setSex(rs.getString("sex"));
				student.setUserNamestu(rs.getString("usernamestu"));
				student.setPasswordstu(rs.getString("passwordstu"));
			
				return student;
			}

		}, userNamestu);
		
		if (list.size() >= 1) {
			return list.get(0);
		} else
			return null;
	}
}
