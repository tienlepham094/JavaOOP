package nhanvien;

import utils.HelpMethod;

import java.text.ParseException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public abstract class NhanVien {
    private String ten;
    private String soCMT;
    private String donvi;
    private Date tgBatDauLam;
    private Hashtable<String, Double> luongTungThang = new Hashtable<>();
    public NhanVien() {
    }

    public NhanVien(String ten, String soCMT, String donvi, Date tgBatDauLam) {
        this.ten = ten;
        this.soCMT = soCMT;
        this.donvi = donvi;
        this.tgBatDauLam = tgBatDauLam;
    }

    public abstract double tinhLuong();
    public abstract void nhapLuong(String monthYear);
    public void nhapTT() throws ParseException { //update lại
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("Nhập tên nhân viên: ");
            String ten = sc.nextLine();
            if(HelpMethod.checkLength(ten, 3))
            {
                setTen(ten);
                break;
            }
            else
            {System.out.println("[Error]: Nhập thông tin có trên 3 ký tự");}
        }

        while (true)
        {
            System.out.print("Nhập số chứng minh thư: ");
            String soCMT = sc.nextLine();
            if(HelpMethod.checkCMT(soCMT)){
                setSoCMT(soCMT);
                break;
            }else{
                System.out.println("[Error]: Nhập số CMT là dãy 9 số");
            }
        }

        System.out.print("Nhập đơn vị: ");
        String donVi = sc.nextLine();
        setDonvi(donVi);
        while(true){
            System.out.print("Nhập thời gian bắt đầu làm : ");
            String tgBatDauLam = sc.nextLine();
            if(HelpMethod.checkDateInput(tgBatDauLam)){
                setTgBatDauLam(HelpMethod.stringToDate(tgBatDauLam));
                break;
            }else{
                System.out.println("[Error]: Nhập lại thông tin có dạng DD/MM/YYYY");
            }
        }
    }
    public void inTT(){
        System.out.println("-------IN THÔNG TIN NHÂN VIÊN--------");
        System.out.println("Tên: " + getTen());
        System.out.println("Số CMT: " + getSoCMT());
        System.out.println("Đơn vị: " + getDonvi());
        System.out.println("Thời gian bắt đầu làm: " + HelpMethod.formatDate(getTgBatDauLam()));
    }
    public void inLuong(String monthYear){
        double luong = getLuong(monthYear);
        if(luong !=0){
            System.out.println("Tên nhân viên: " + getTen());
            System.out.println("Lương tháng " + monthYear + " : " + HelpMethod.formatNumber(luong));
        }else{
            System.out.println("[Error]: Chưa tồn tại dữ liệu về lương tháng " + monthYear);
            System.out.println("[Error]: Vui lòng nhập thông tin trước khi tìm kiếm !");
        }
    }
    public double getLuong(String monthYear){
        if(luongTungThang.containsKey(monthYear)){
            return luongTungThang.get(monthYear);
        }else{
            return 0;
        }
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

    public Hashtable<String, Double> getLuongTungThang() {
        return luongTungThang;
    }
    public void setLuongTungThang(String monthYear, double luong){
        luongTungThang.put(monthYear, luong);}
}
