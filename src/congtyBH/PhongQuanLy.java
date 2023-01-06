package congtyBH;

import nhanvien.NhanVien;
import utils.HelpMethod;

import java.util.*;

public class PhongQuanLy {
    private int soNV;
    private PhongTaiChinh ptc;
    private ArrayList<NhanVien> dsNV;

    public PhongQuanLy() {
        this.soNV = 0;
        this.dsNV = new ArrayList<>();
        this.ptc = new PhongTaiChinh();
    }
    // them, sua, xoa nhan vien
    public void themNV(NhanVien nv){
        dsNV.add(nv);

    }
    public void xoaNV(NhanVien nv){
        dsNV.remove(nv);
    }
    public void suaNV(){

    }
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


    public int getSoNV() {
        return soNV;
    }

    public void setSoNV(int soNV) {
        this.soNV = soNV;
    }

    public PhongTaiChinh getPtc() {
        return ptc;
    }

    public void setPtc(PhongTaiChinh ptc) {
        this.ptc = ptc;
    }

    public ArrayList<NhanVien> getDsNV() {
        return dsNV;
    }

}
