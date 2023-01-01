package nhanvien;

import java.util.Date;

public class NhanVienThoiVu extends NhanVien {
    private int tongBaoHiem;
    private final double TIEN_BH = 200000;

    public NhanVienThoiVu(int tongBaoHiem) {
        this.tongBaoHiem = tongBaoHiem;
    }

    public NhanVienThoiVu(String ten, String soCMT, String donvi, Date tgBatDauLam, int tongBaoHiem) {
        super(ten, soCMT, donvi, tgBatDauLam);
        this.tongBaoHiem = tongBaoHiem;
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
