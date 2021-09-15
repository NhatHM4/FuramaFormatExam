package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.House;
import Entity.Phong;
import Entity.Services;
import Entity.Villa;
import utils.JdbcUtil;

public class ServiceDao {
	public void insert(Services ser) {
		if (ser instanceof Villa) {
			String sql = "insert into services(TenDV,DienTichSD,CPThue,SLuongToiDa,KieuThue,DVType,TieuChuanPhong,MoTaTienNghi,SoTang,DTHoBoi) values(?,?,?,?,?,?,?,?,?,?)";
			JdbcUtil.excuteUpdate(sql, ser.getTenDV(),
									   ser.getDtichSD(),
									   ser.getChiPhi(),
									   ser.getSoLuong(),
									   ser.getKieuThue(),
									   ser.getDVThue(),
									   ((Villa) ser).getTieuchuanPhong(),
									   ((Villa) ser).getMota(),
									   ((Villa) ser).getSoTang(),
									   ((Villa) ser).getDtichHoBoi()
					);
		}
		
		if (ser instanceof House) {
			String sql = "insert into services(TenDV,DienTichSD,CPThue,SLuongToiDa,KieuThue,DVType,TieuChuanPhong,MoTaTienNghi,SoTang) values(?,?,?,?,?,?,?,?,?)";
			JdbcUtil.excuteUpdate(sql, ser.getTenDV(),
									   ser.getDtichSD(),
									   ser.getChiPhi(),
									   ser.getSoLuong(),
									   ser.getKieuThue(),
									   ser.getDVThue(),
									   ((House) ser).getTieuchuanPhong(),
									   ((House) ser).getMota(),
									   ((House) ser).getSotang()
					);
		}
		
		if (ser instanceof Phong) {
			String sql = "insert into services(TenDV,DienTichSD,CPThue,SLuongToiDa,KieuThue,DVType,DVMIenPhi) values(?,?,?,?,?,?,?)";
			JdbcUtil.excuteUpdate(sql, ser.getTenDV(),
									   ser.getDtichSD(),
									   ser.getChiPhi(),
									   ser.getSoLuong(),
									   ser.getKieuThue(),
									   ser.getDVThue(),
									   ((Phong) ser).getDvFree()
					);
		}
	}

	public boolean containTenDV(String tenDV) {
		String sql = "select * from services where TenDV = ?";
		ResultSet rs = JdbcUtil.excuteQuery(sql, tenDV);
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
