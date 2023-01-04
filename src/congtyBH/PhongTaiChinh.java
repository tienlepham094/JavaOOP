package congtyBH;

import nhanvien.NhanVien;

import java.util.ArrayList;

public class PhongTaiChinh {


    public void nhapLuongTheoThang(ArrayList<NhanVien> dsNV){
        for(NhanVien nv: dsNV){
            nv.nhapLuong();
        }
    }

    public void inLuongTheoThang(String thangnam, ArrayList<NhanVien> dsNV){}


}
