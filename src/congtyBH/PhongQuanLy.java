package congtyBH;

import nhanvien.NhanVien;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

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
    // tinhLuongTB
    public void tinhLuongTB(){
        Date dateNow = new Date();
    }
    // thong ke thonh tin va muc luong theo thang
}
