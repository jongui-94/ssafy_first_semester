package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ssafy.cafe.model.dto.Stamp;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	//Singleton Pattern 적용
	private static UserDao instance;
	
	private UserDaoImpl() {}
	
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		
		return instance;
	}
	
	// End of Singleton Pattern 적용

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStamp(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User select(String userId) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			// 1. DBUtil 활용하여 Connection 객체 가져오기
			conn = DBUtil.getConnection();
			
			// 2. SQL문 작성하기
			String sql = "SELECT * FROM t_user WHERE id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			
			// 3. SQL문 실행하기
			rs = stmt.executeQuery();
			
			// 4. SQL문 실행 결과를 User 객체에 담기
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setStamps(rs.getInt("stamps"));
				
				// 4-1. (특화) StampList 가져와서 User 객체에 채우기
				StampDao sDao = StampDaoImpl.getInstance();
				List<Stamp> stampList = sDao.selectByUserId(userId);
				user.setStampList(stampList);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return user;
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
