package congtyBH;

import nhanvien.NhanVien;
import utils.HelpMethod;

import java.util.*;

public class PhongQuanLy {
    private int soNV;
    private PhongTaiChinh ptc;
    private ArrayList<NhanVien> dsNV;
    private Hashtable<String, ArrayList<NhanVien>> dsTheoThang;


    public PhongQuanLy() {
        this.soNV = 0;
        this.dsNV = new ArrayList<>();
        this.dsTheoThang = new Hashtable<String, ArrayList<NhanVien>>();
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
    public double tinhLuongTB(){
        Date dateNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        String monthYear = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.YEAR);

        Set<String> keys =dsTheoThang.keySet();
        for(String key: keys){
            if(Objects.equals(key, monthYear)){
                ArrayList<NhanVien> dsach = dsTheoThang.get(key);
                int total = dsach.size();
                double sum = 0;
                for(NhanVien nv: dsach){
                    sum += nv.tinhLuong();
                }
                return sum/total;
            }
            }
        return 0;
        }




        // nhap luong theo thang
    public void nhapLuongTheoThang(String monthYear){
        Set<String> keys =dsTheoThang.keySet();
        for(String key: keys){
            if(Objects.equals(key, monthYear)){
                ptc.nhapLuongTheoThang(dsTheoThang.get(key));
            }
        }
    }
    public void themSuaDSTheoThang(String monthYear){
            ArrayList<NhanVien> ds = new ArrayList<>();
            for (NhanVien nv : dsNV){
                if(HelpMethod.compareMonthYear(nv.getTgBatDauLam(), monthYear)){
                    ds.add(nv);
                }
            }
            if(ds.size()==0){
                System.out.println("Chưa có dữ liệu nhân viên");
            }else{
                dsTheoThang.put(monthYear, ds);
            }


    }
    // thong ke thonh tin va muc luong theo thang
}
