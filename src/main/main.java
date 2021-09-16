package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.CustomerDao;
import Dao.HouseDao;
import Dao.PhongDao;
import Dao.ServiceDao;
import Dao.VillaDao;
import Entity.Customer;
import Entity.House;
import Entity.Phong;
import Entity.Services;
import Entity.Villa;
import Exception.DateException;
import Exception.ExistedFullNameCustomerExpection;
import Exception.TenDVIsExistsExcpetion;
import Service.Service;
import Validate.ValidatorUtil;
import utils.JdbcUtil;

public class main {
	static Service readFile = new Service();
	static ServiceDao insertDB = new ServiceDao();
	static CustomerDao insertCus = new CustomerDao();

	public static void main(String[] args) {
//		showList();
//		try {
//			insertToDB();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		showFromDB();
//		addcustomer();
		deleteCustomer();
	}

	private static void deleteCustomer() {
		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> listCus = new CustomerDao().getList();
			for (Customer customer : listCus) {
				System.out.println(customer.getHoten());
			}
			System.out.println("Nhap ten KH muon xoa");
			String name = sc.nextLine();
			System.out.println("Nhap kieu thue muon doi");
			String kieuThue = sc.nextLine();
			insertCus.deleteCustomer(name);
			int n = insertDB.updateService(getTenDV(name, listCus),kieuThue);
			if (n > 0) {
				System.out.println("Thanh cong");
			} else {
				System.out.println("That bai");
			}
		}
	}

	private static String getTenDV(String name, List<Customer> listCus) {
		for (Customer customer : listCus) {
			if (customer.getHoten().equals(name)) {
				return customer.getTenDV();
			}
		}
		return name;
	}

	private static void addcustomer() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter name customer ");
			String name = sc.nextLine();
			try {
				if (ValidatorUtil.containNameCustomer(name)) {
					Customer cus = createCus(name, sc);
					if (cus != null) {
						insertCus.insert(cus);
						insertDB.update(cus.getTenDV(), "Dang thue");
						System.out.println("Thanh cong");
					}
				}
			} catch (ExistedFullNameCustomerExpection e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	private static Customer createCus(String name, Scanner sc) {
		Customer cus = new Customer();
		cus.setHoten(name);
		System.out.println("Enter birthday");
		String date = sc.nextLine();
		try {
			if (ValidatorUtil.isValidEntryDate(date)) {
				cus.setNgaysinh(date);
			}
		} catch (DateException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("Enter phone");
		String phone = sc.nextLine();
		cus.setSDT(phone);
		System.out.println("Enter ten DV");
		String tenDV = sc.nextLine();
		try {
			if (ValidatorUtil.containExitedTenDV(tenDV)) {
				cus.setTenDV(tenDV);
				return cus;
			}
		} catch (TenDVIsExistsExcpetion e) {
			e.printStackTrace();
			return null;
		}
		return cus;
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
//				System.exit(0);
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
