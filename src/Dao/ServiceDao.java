package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Entity.House;
import Entity.Phong;
import Entity.Services;
import Entity.Villa;
import utils.JdbcUtil;

public class ServiceDao {
	private JdbcUtil jdbcUtil = new JdbcUtil();
	public void insert(Services ser) {
		if (ser instanceof Villa) {
			String sql = "insert into services(TenDV,DienTichSD,CPThue,SLuongToiDa,KieuThue,DVType,TieuChuanPhong,MoTaTienNghi,SoTang,DTHoBoi) values(?,?,?,?,?,?,?,?,?,?)";
			jdbcUtil.excuteUpdate(sql, ser.getTenDV(),
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
			jdbcUtil.excuteUpdate(sql, ser.getTenDV(),
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
			jdbcUtil.excuteUpdate(sql, ser.getTenDV(),
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
		ResultSet rs = jdbcUtil.excuteQuery(sql, tenDV);
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void update(String TenDV,String kieuThue) {
		String sql = "update services set KieuThue = ? where TenDV = ?";
		jdbcUtil.excuteUpdate(sql, kieuThue, TenDV);
	}

	public int  updateService(String tenDV, String kieuThue) {	
		String sql = "update services set Kieuthue = ? where TenDV = ?";
		return jdbcUtil.excuteUpdate(sql, kieuThue,tenDV);
	}
}
