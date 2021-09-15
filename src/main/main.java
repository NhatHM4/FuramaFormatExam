package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.HouseDao;
import Dao.PhongDao;
import Dao.ServiceDao;
import Dao.VillaDao;
import Entity.House;
import Entity.Phong;
import Entity.Services;
import Entity.Villa;
import Exception.TenDVIsExistsExcpetion;
import Service.Service;
import Validate.ValidatorUtil;
import utils.JdbcUtil;

public class main {
	static Service readFile = new Service();
	static ServiceDao insertDB = new ServiceDao();

	public static void main(String[] args) {
//		showList();
		try {
			insertToDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		showFromDB();
	}

	private static void showFromDB() {
		List<Villa> villas = new VillaDao().select();
		List<House> houses = new HouseDao().select();
		List<Phong> phongs = new PhongDao().select();
		List<Services> listSer = new ArrayList<Services>();
		listSer.addAll(villas);
		listSer.addAll(houses);
		listSer.addAll(phongs);

		for (Services services : listSer) {
			System.out.println(services.toString());
		}
	}

	private static void insertToDB() throws SQLException {
		List<Services> listSer = readFile.readFile();
		int lineCount = 0;
		for (Services services : listSer) {
			try {
				lineCount++;
				if (ValidatorUtil.containTenDV(services.getTenDV())) {
					insertDB.insert(services);
				}
			} catch (TenDVIsExistsExcpetion e) {
				e.printStackTrace();
				System.err.printf(" Dong %d bi loi. TenDV: %s  da ton tai", lineCount, services.getTenDV());
				System.exit(0);
			}
		}
	}

	private static void showList() {
		List<Services> listSer = readFile.readFile();
		for (Services services : listSer) {
			System.out.println(services.toString());
		}
	}
}
