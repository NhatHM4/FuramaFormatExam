package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.House;
import Entity.Phong;
import utils.JdbcUtil;

public class PhongDao {
	public List<Phong> select(){
		String sql = "select * from services where DVType = 3";
		ResultSet rs = JdbcUtil.excuteQuery(sql);
		return getPhong(rs);
	}

	private List<Phong> getPhong(ResultSet rs) {
		List<Phong> listPhong = new ArrayList<Phong>();
		try {
			while (rs.next()) {
				Phong room = new Phong();
				room.setTenDV(rs.getString(1));
				room.setDtichSD(rs.getString(2));
				room.setChiPhi(rs.getInt(3));
				room.setSoLuong(rs.getInt(4));
				room.setKieuThue(rs.getString(5));
				room.setDVThue(rs.getString(6));
				room.setDvFree(rs.getString(11));
				listPhong.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPhong;
	}
}
