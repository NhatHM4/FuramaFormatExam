package Entity;

import java.util.Scanner;

public class Customer {
	private String hoten;
	private String ngaysinh;
	private String gioitinh;
	private String CMND;
	private String SDT;
	private String email;
	private String LoaiKhach;
	private String Diachi;
	private Services dichvu;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String hoten, String ngaysinh, String gioitinh, String cMND, String sDT, String email,
			String loaiKhach, String diachi, Services dichvu) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.CMND = cMND;
		this.SDT = sDT;
		this.email = email;
		this.LoaiKhach = loaiKhach;
		this.Diachi = diachi;
		this.dichvu = dichvu;
	}
	
	public void showInfo() {
		System.out.println("Ho ten : " + hoten + " Ngay sinh " + ngaysinh );
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten");
		hoten = sc.nextLine();
		System.out.println("Nhap ngay sinh");
		ngaysinh = sc.nextLine();
		System.out.println("Gioi tinh");
		gioitinh = sc.nextLine();
		System.out.println("CMND");
		CMND = sc.nextLine();
		System.out.println("SDT ");
		SDT = sc.nextLine();
		System.out.println("Email");
		email = sc.nextLine();
		System.out.println("Loai khach");
		LoaiKhach = sc.nextLine();
		System.out.println("Dia chi");
		Diachi = sc.nextLine();
	}
	
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoaiKhach() {
		return LoaiKhach;
	}

	public void setLoaiKhach(String loaiKhach) {
		LoaiKhach = loaiKhach;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public Services getDichvu() {
		return dichvu;
	}

	public void setDichvu(Services dichvu) {
		this.dichvu = dichvu;
	}

	@Override
	public String toString() {
		return "Customer [hoten=" + hoten + "]";
	}
	
	
	
	
	
	
}
