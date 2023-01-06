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
        // viết thêm nè
    }
    public void XoaNV(NhanVien nv){
        // viết thêm tiếp
    }
    public void SuaNV(){

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

//    public void layDSTheoThang(String monthYear){
//            ArrayList<NhanVien> ds = new ArrayList<>();
//            for (NhanVien nv : dsNV){
//                if(HelpMethod.compareMonthYear(nv.getTgBatDauLam(), monthYear)){
//                    ds.add(nv);
//                }
//            }
//            if(ds.size()==0){
//                System.out.println("Chưa có dữ liệu nhân viên");
//            }else{
//                dsTheoThang.put(monthYear, ds);
//            }
//
//
//    }

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

    public void setDsNV(ArrayList<NhanVien> dsNV) {
        this.dsNV = dsNV;
    }

//    public Hashtable<String, ArrayList<NhanVien>> getDsTheoThang() {
//        return dsTheoThang;
//    }
//
//    public void setDsTheoThang(Hashtable<String, ArrayList<NhanVien>> dsTheoThang) {
//        this.dsTheoThang = dsTheoThang;
//    }
}
