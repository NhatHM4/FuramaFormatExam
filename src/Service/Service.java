package Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.House;
import Entity.Phong;
import Entity.Services;
import Entity.Villa;

public class Service {
	public List<Services> readFile(){
		List<Services> listServices = new ArrayList<Services>();
		String line;
		String path = "E:\\nhat\\Furama2\\furama.csv";
		try (BufferedReader bff = new BufferedReader(new FileReader(path))){
			bff.readLine();
			while ((line = bff.readLine()) != null) {
				String[] data = line.split(",",11);
				Services ser = null;
				
				if (!data[9].equals("")) {
					ser = new Villa();
					((Villa)ser).setTieuchuanPhong(data[6]);
					((Villa)ser).setMota(data[7]);
					((Villa)ser).setSoTang(Integer.parseInt(data[8]));
					((Villa)ser).setDtichHoBoi(Float.parseFloat(data[9]));
				}
				
				if ((!data[8].equals("")) && (data[9].equals(""))) {
					ser = new House();
					((House)ser).setTieuchuanPhong(data[6]);
					((House)ser).setMota(data[7]);
					((House)ser).setSotang(Integer.parseInt(data[8]));
				}
				
				if ((!data[10].equals(""))) {
					ser = new Phong();
					((Phong)ser).setDvFree(data[10]);
				}
				
				ser.setTenDV(data[0]);
				ser.setDtichSD(data[1]);
				ser.setChiPhi(Integer.parseInt(data[2]));
				ser.setSoLuong(Integer.parseInt(data[3]));
				ser.setKieuThue(data[4]);
				ser.setDVThue(data[5]);
				listServices.add(ser);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return listServices;
	}
}
