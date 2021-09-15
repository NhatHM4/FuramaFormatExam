package Entity;

import java.util.Scanner;

public class House extends Services {
	Scanner sc = new Scanner(System.in);
	private String tieuchuanPhong;
	private String mota;
	private int sotang;
	
	public House() {
		// TODO Auto-generated constructor stub
	}
	
	



	@Override
	public void showInfo() {
		System.out.println("ID: "+ " TenDV " + super.getTenDV() + " Dientich " + super.getDtichSD()
		+ " Chi Phi " + super.getSoLuong() + " kieu thue " + super.getKieuThue() + " TC phong " + this.tieuchuanPhong + " so tang " + this.sotang);
	}



	public String getTieuchuanPhong() {
		return tieuchuanPhong;
	}



	public void setTieuchuanPhong(String tieuchuanPhong) {
		this.tieuchuanPhong = tieuchuanPhong;
	}



	public String getMota() {
		return mota;
	}



	public void setMota(String mota) {
		this.mota = mota;
	}



	public int getSotang() {
		return sotang;
	}



	public void setSotang(int sotang) {
		this.sotang = sotang;
	}
//	@Override
//	public void input() {
//		super.input();
//		System.out.println("Tieu chuan phong");
//		setTieuchuanPhong(sc.nextLine());
//		System.out.println("Mo ta");
//		setMota(sc.nextLine());
//		System.out.println("So tang");
//		setSotang(Integer.parseInt(sc.nextLine()));
//	}





	@Override
	public String toString() {
		return super.toString() + "House [" + ", tieuchuanPhong=" + tieuchuanPhong + ", mota=" + mota + ", sotang=" + sotang + "]";
	}


	


	
	
	
	
}
