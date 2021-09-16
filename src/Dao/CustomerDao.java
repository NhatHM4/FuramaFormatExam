package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Customer;
import utils.JdbcUtil;

public class CustomerDao {
	private JdbcUtil jdbcUtil = new JdbcUtil();
	public boolean existsNameCustomer(String name) {
		String sql = "select * from customer where hoten = ?";
		ResultSet rs = jdbcUtil.excuteQuery(sql, name);
		return getHoten(rs);
	}

	private static boolean getHoten(ResultSet rs) {
		try {
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert(Customer customer) {
		String sql = "insert into customer values(?,?,?,?)";
		jdbcUtil.excuteUpdate(sql, customer.getHoten(),
								   customer.getNgaysinh(),
								   customer.getSDT(),
								   customer.getTenDV()
				);
	}

	public List<Customer> getList() {
		String sql = "select * from customer";
		ResultSet rs = jdbcUtil.excuteQuery(sql);
		return getCus(rs);
	}

	private List<Customer> getCus(ResultSet rs) {
		List<Customer> listCus = new ArrayList<Customer>();
		try {
			while(rs.next()) {
				Customer cus = new Customer();
				cus.setHoten(rs.getString(1));
				cus.setNgaysinh(rs.getString(2));
				cus.setSDT(rs.getString(3));
				cus.setTenDV(rs.getString(4));
				listCus.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCus;
	}

	public void deleteCustomer(String name) {
		String sql = "delete from customer where hoten = ?";
		jdbcUtil.excuteUpdate(sql, name);
	}

}
