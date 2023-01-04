package nhanvien;

import java.util.Date;

public abstract class NhanVien {
    private String ten;
    private String soCMT;
    private String donvi;
    private Date tgBatDauLam;

    public NhanVien() {
    }

    public NhanVien(String ten, String soCMT, String donvi, Date tgBatDauLam) {
        this.ten = ten;
        this.soCMT = soCMT;
        this.donvi = donvi;
        this.tgBatDauLam = tgBatDauLam;
    }

    public abstract double tinhLuong();
    public abstract void nhapLuong();
    public void inTT(){
        System.out.println(this.toString());
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Date getTgBatDauLam() {
        return tgBatDauLam;
    }

    public void setTgBatDauLam(Date tgBatDauLam) {
        this.tgBatDauLam = tgBatDauLam;
    }
}
