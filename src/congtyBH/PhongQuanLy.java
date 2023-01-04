package congtyBH;

import nhanvien.NhanVien;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Objects;

public class PhongQuanLy {
    private int soNV;
    private PhongTaiChinh ptc;
    private ArrayList<NhanVien> dsNV;
    private Hashtable<String, ArrayList> dsTheoThang;


    public PhongQuanLy() {
        this.soNV = 0;
        this.dsNV = new ArrayList<>();
        this.dsTheoThang = new Hashtable<>();
        this.ptc = new PhongTaiChinh();
    }
    // them, sua, xoa nhan vien
    // tim kiem nhan vien
    public ArrayList<NhanVien> timKiem(String ten){

        ArrayList<NhanVien> result = new ArrayList<>();
        String regex = ".*\\b"+ ten.toLowerCase() +".*";
        for (NhanVien nv: dsNV){
            if(nv.getTen().toLowerCase().matches(regex)){
                result.add(nv);
            }
        }
        return result;
    }
    public ArrayList<NhanVien> timKiemCMT(String cmt){
        ArrayList<NhanVien> result = new ArrayList<>();
        for(NhanVien nv: dsNV){
            if(Objects.equals(nv.getSoCMT(), cmt)){
                result.add(nv);
            }
        }
        return result;
    }
    // overloading
    public ArrayList<NhanVien> timKiem(Date date){
        ArrayList<NhanVien> result = new ArrayList<>();
        for(NhanVien nv: dsNV){
            if(nv.getTgBatDauLam() == date){
                result.add(nv);
            }
        }
        return result;
    }
    // tinhLuongTB
    public void tinhLuongTB(){
        Date dateNow = new Date();
    }
    // thong ke thonh tin va muc luong theo thang
}
