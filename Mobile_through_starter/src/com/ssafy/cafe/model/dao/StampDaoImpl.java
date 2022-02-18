package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.cafe.model.dto.Stamp;
import com.ssafy.util.DBUtil;

public class StampDaoImpl implements StampDao{
	
	//Singleton Pattern 적용
		private static StampDao instance;
		
		private StampDaoImpl() {}
		
		public static StampDao getInstance() {
			if(instance == null) {
				instance = new StampDaoImpl();
			}
			
			return instance;
		}
		
		// End of Singleton Pattern 적용

	@Override
	public int insert(Stamp stamp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Stamp select(Integer stampId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stamp> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stamp> selectByUserId(String userId) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Stamp> list = new ArrayList<Stamp>();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "SELEct * FROM t_stamp WHERE user_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Stamp stamp = new Stamp();
				
				stamp.setId(rs.getInt("id"));
				stamp.setOrderId(rs.getInt("order_id"));
				stamp.setQuantity(rs.getInt("quantity"));
				stamp.setUserId(rs.getString("user_id"));
				
				list.add(stamp);
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
		
		return list;
	}

}
