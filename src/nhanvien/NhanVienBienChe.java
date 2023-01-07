package nhanvien;

import utils.HelpMethod;

import java.text.ParseException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class NhanVienBienChe extends NhanVien {
    private double luongCoBan;
    private double gioLamThem;
    private final double TIEN_LUONG_CB = 2000000;
    private final double TIEN_LUONG_LT = 200000;
    public NhanVienBienChe(){};
    public NhanVienBienChe(String ten, String soCMT, String donvi, Date tgBatDauLam, double luongCoBan) {
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
        System.out.println("Lương cơ bản: " + luongCoBan);
    }

    public void nhapLuong(String monthYear){
        inTT();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhập số giờ làm thêm: ");
            String soGioLamThem = sc.nextLine();
            if(HelpMethod.checkNumber(soGioLamThem)){
                setGioLamThem(Double.parseDouble(soGioLamThem));
                super.setLuongTungThang(monthYear, tinhLuong());
                System.out.println("------- Kết quả ---------");
                inLuong(monthYear);
                break;
            }else{
                System.out.println("[Error]: Nhập thông tin chưa hợp lệ");
            }
        }

    }
    public void nhapTT() throws ParseException {
        super.nhapTT();
        while (true){
            System.out.print("Nhập lương cơ bản: ");
            Scanner sc = new Scanner(System.in);
            String luongCoBan = sc.nextLine();
            if (HelpMethod.checkNumber(luongCoBan))
            {
                setLuongCoBan(Double.parseDouble(luongCoBan));
                break;
            }
            else {
                System.out.println("[Error]: Nhập lương cơ bản chưa hợp lệ");
            }
        }
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
