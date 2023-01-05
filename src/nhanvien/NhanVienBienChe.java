package nhanvien;

import utils.HelpMethod;

import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class NhanVienBienChe extends NhanVien {
    private double luongCoBan;
    private double gioLamThem;
    private final double TIEN_LUONG_CB = 2000000;
    private final double TIEN_LUONG_LT = 200000;
    private Hashtable<String, Double> luongTungThang;

    public NhanVienBienChe(String ten, String soCMT, String donvi, Date tgBatDauLam, double luongCoBan, double gioLamThem) {
        super(ten, soCMT, donvi, tgBatDauLam);
        this.luongCoBan = luongCoBan;
        this.gioLamThem = 0;
        luongTungThang = new Hashtable<>();
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * TIEN_LUONG_CB + gioLamThem * TIEN_LUONG_LT;
    }
    public void inTT(){
        super.inTT();
        System.out.println("Luong: " + tinhLuong());
    }

    public void nhapLuong(String monthYear){
        while(true){
            System.out.print("Nhập số giờ làm thêm: ");
            Scanner sc = new Scanner(System.in);
            String soGioLamThem = sc.nextLine();
            if(HelpMethod.checkNumber(soGioLamThem)){
                setGioLamThem(Double.parseDouble(soGioLamThem));
                setLuongTungThang(monthYear, tinhLuong());
                break;
            }else{
                System.out.println("Nhập thông tin chưa hợp lệ");
            }
        }

    }
    public void nhapTT() {
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
                System.out.println("Nhập lương cơ bản chưa hợp lệ");
            }
        }
    }
   public void setLuongTungThang(String monthYear, double luong){
        luongTungThang.put(monthYear, luong);

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
