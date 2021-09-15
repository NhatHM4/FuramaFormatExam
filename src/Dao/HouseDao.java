package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.House;
import utils.JdbcUtil;

public class HouseDao {
	public List<House> select() {
		String sql = "select * from services where DVType = 2";
		ResultSet rs = JdbcUtil.excuteQuery(sql);
		return getHouse(rs);
	}

	private List<House> getHouse(ResultSet rs) {
		List<House> listHouse = new ArrayList<House>();
		try {
			while (rs.next()) {
				House house = new House();
				house.setTenDV(rs.getString(1));
				house.setDtichSD(rs.getString(2));
				house.setChiPhi(rs.getInt(3));
				house.setSoLuong(rs.getInt(4));
				house.setKieuThue(rs.getString(5));
				house.setDVThue(rs.getString(6));
				house.setTieuchuanPhong(rs.getString(7));
				house.setMota(rs.getString(8));
				house.setSotang(rs.getInt(9));
				listHouse.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHouse;
	}
}
