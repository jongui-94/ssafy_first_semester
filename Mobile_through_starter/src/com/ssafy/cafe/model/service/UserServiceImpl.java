package com.ssafy.cafe.model.service;

import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dao.UserDaoImpl;
import com.ssafy.cafe.model.dto.User;

public class UserServiceImpl implements UserService{
	
	//Singleton Pattern 적용
	private static UserService instance;
	
	private UserServiceImpl() {}
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserServiceImpl();
		}
		
		return instance;
	}
	
	//End of Singleton Pattern 적용

	@Override
	public void join(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String id, String pass) {
		//1. UserDao 객체를 얻는다.
		UserDao uDao = UserDaoImpl.getInstance();
		
		// 2. Dao 객체를 활용해서 SQL문 실행
		User user = uDao.select(id);
		
		// 3. DB 데이터 활용하여 메서드에 맞는 Business Logic 수행		
		if(user.getPass().equals(pass)) {
			return user;
		}
		
		return null;
	}

	@Override
	public void leave(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUsedId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
