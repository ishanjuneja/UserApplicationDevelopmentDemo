package com.yash.userapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.yash.userapp.dao.UserDao;
import com.yash.userapp.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {

	Logger logger = Logger.getLogger(UserDaoImpl.class);

	public void insertUser(User user) {

		Connection con = null;
		PreparedStatement pstmt = null;
		DataSource dataSource;
		Context ctx;
		try {
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/MyDB");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement("insert into users(name,salary) values (?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getSalary());
			pstmt.executeUpdate();
		} catch (NamingException | SQLException e) {
			logger.error(e);
		} finally {
			if (con != null) {
				try {
					logger.info("user saved with below details ");
					logger.info(user.getName());
					logger.info(user.getSalary());
					con.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}
		

	}

}
