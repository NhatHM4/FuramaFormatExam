package Entity;

import java.util.Scanner;

public class Employee {
	private String hoten;
	private String ngaysinh;
	private String CMND;
	private String SDT;
	private String email;
	private String trinhdo;
	private String vitri;
	private float luong;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String hoten, String ngaysinh, String cMND, String sDT, String email, String trinhdo, String vitri,
			float luong) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		CMND = cMND;
		SDT = sDT;
		this.email = email;
		this.trinhdo = trinhdo;
		this.vitri = vitri;
		this.luong = luong;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho ten");
		this.hoten = sc.nextLine();
		System.out.println("Ngay sinh");
		this.ngaysinh = sc.nextLine();
		System.out.println("CMND");
		this.CMND = sc.nextLine();
		System.out.println("SDT");
		this.SDT = sc.nextLine();
		System.out.println("Trinh do");
		this.trinhdo = sc.nextLine();
		System.out.println("Vi tri");
		this.vitri = sc.nextLine();
		System.out.println("Luong");
		this.luong = Float.parseFloat(sc.nextLine());
		
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

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public String getVitri() {
		return vitri;
	}

	public void setVitri(String vitri) {
		this.vitri = vitri;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "Employee [hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", CMND=" + CMND + ", SDT=" + SDT + ", email="
				+ email + ", trinhdo=" + trinhdo + ", vitri=" + vitri + ", luong=" + luong + "]";
	}
	
	
}
