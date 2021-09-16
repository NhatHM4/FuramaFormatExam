package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Villa;
import utils.JdbcUtil;

public class VillaDao {
	private JdbcUtil jdbcUtil = new JdbcUtil();
	public List<Villa> select() {
		String sql = "select * from services where DVType = 1";
		ResultSet rs = jdbcUtil.excuteQuery(sql);
		return getVilla(rs);
	}

	private List<Villa> getVilla(ResultSet rs) {
		List<Villa> listVilla = new ArrayList<Villa>();
		try {
			while (rs.next()) {
				Villa vl = new Villa();
				vl.setTenDV(rs.getString(1));
				vl.setDtichSD(rs.getString(2));
				vl.setChiPhi(rs.getInt(3));
				vl.setSoLuong(rs.getInt(4));
				vl.setKieuThue(rs.getString(5));
				vl.setDVThue(rs.getString(6));
				vl.setTieuchuanPhong(rs.getString(7));
				vl.setMota(rs.getString(8));
				vl.setSoTang(rs.getInt(9));
				vl.setDtichHoBoi(rs.getFloat(10));
				listVilla.add(vl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
//				rs.getStatement().close();
//				rs.getStatement().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listVilla;
	}
}
