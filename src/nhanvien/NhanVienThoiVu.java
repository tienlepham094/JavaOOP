package nhanvien;

import java.util.Date;
import java.util.Hashtable;

public class NhanVienThoiVu extends NhanVien {
    private int tongBaoHiem;
    private final double TIEN_BH = 200000;
    private Hashtable<String, Double> luongTungThang;

    public NhanVienThoiVu(String ten, String soCMT, String donvi, Date tgBatDauLam, int tongBaoHiem) {
        super(ten, soCMT, donvi, tgBatDauLam);
        this.tongBaoHiem = 0;
        luongTungThang  = new Hashtable<>();
    }

    @Override
    public double tinhLuong() {
        return tongBaoHiem * TIEN_BH;
    }
    public void inTT(){
        super.inTT();
        System.out.println(this.toString());
        System.out.println("Tien Luong: " + tinhLuong());
    }
    public void nhapLuong(String monthYear){
        // nhập giờ làm thêm
        setLuongTungThang(monthYear, 2000);
    }
    public void setLuongTungThang(String monthYear, double luong){
        luongTungThang.put(monthYear, luong);

    }
    public int getTongBaoHiem() {
        return tongBaoHiem;
    }

    public void setTongBaoHiem(int tongBaoHiem) {
        this.tongBaoHiem = tongBaoHiem;
    }

    public double getTIEN_BH() {
        return TIEN_BH;
    }
}
