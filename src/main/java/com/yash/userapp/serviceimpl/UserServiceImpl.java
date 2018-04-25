package com.yash.userapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.userapp.dao.UserDao;
import com.yash.userapp.pojo.User;
import com.yash.userapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
		
	public void addUser(User user) {

		userDao.insertUser(user);

	}

}
