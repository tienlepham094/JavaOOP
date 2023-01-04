package nhanvien;

import java.util.Date;

public class NhanVienBienChe extends NhanVien {
    private double luongCoBan;
    private double gioLamThem;
    private final double TIEN_LUONG_CB = 2000000;
    private final double TIEN_LUONG_LT  = 200000;

    public NhanVienBienChe(double luongCoBan, double gioLamThem) {
        this.luongCoBan = luongCoBan;
        this.gioLamThem = 0;
    }

    public NhanVienBienChe(String ten, String soCMT, String donvi, Date tgBatDauLam, double luongCoBan, double gioLamThem) {
        super(ten, soCMT, donvi, tgBatDauLam);
        this.luongCoBan = luongCoBan;
        this.gioLamThem = 0;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * TIEN_LUONG_CB + gioLamThem * TIEN_LUONG_LT;
    }
    public void inTT(){
        super.inTT();
        System.out.println(this.toString());
        System.out.println("Luong: " + tinhLuong());
    }

    public void nhapLuong(){
        // nhập giờ làm thêm
    }
    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getGioLamThem() {
        return gioLamThem;
    }

    public void setGioLamThem(double gioLamThem) {
        this.gioLamThem = gioLamThem;
    }

    public double getTIEN_LUONG_CB() {
        return TIEN_LUONG_CB;
    }

    public double getTIEN_LUONG_LT() {
        return TIEN_LUONG_LT;
    }
}
