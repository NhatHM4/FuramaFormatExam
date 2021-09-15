package Entity;

import java.util.Scanner;

public class Phong extends Services{
	Scanner sc = new Scanner(System.in);
	private String dvFree;
	
	public Phong() {
		// TODO Auto-generated constructor stub
	}

//	public Phong(String id, String tenDV, String dtichSD, float chiPhi, int soLuong, String kieuThue, String dvFree) {
//		super(id, tenDV, dtichSD, chiPhi, soLuong, kieuThue);
//		this.dvFree = dvFree;
//	}

	@Override
	public void showInfo() {
//		System.out.println(" TenDV " + super.getTenDV() + " Dientich " + super.getDtichSD()
//		+ " Chi Phi " + super.getSoLuong() + " kieu thue " + super.getKieuThue() + " TC phong " + this.dvFree);
	}

	public String getDvFree() {
		return dvFree;
	}

	public void setDvFree(String dvFree) {
		this.dvFree = dvFree;
	}

	@Override
	public String toString() {
		return super.toString() + "Phong [" + ", dvFree=" + dvFree + "]";
	}
	
//	@Override
//	public void input() {
//		super.input();
//		System.out.println("Dich vu mien phi");
//		setDvFree(sc.nextLine());
//	}
	
	
}
