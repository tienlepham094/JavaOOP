// Nguyen Thi Van Anh 20200035
package nhanvien;

import utils.HelpMethod;
import java.util.Date;
import java.util.Scanner;

public class NhanVienThoiVu extends NhanVien {
    private final double TIEN_BH = 200000;
    private int soHopDongBan;
    public NhanVienThoiVu(){};
    public NhanVienThoiVu(String ten, String soCMT, String donvi, Date tgBatDauLam) {
        super(ten, soCMT, donvi, tgBatDauLam);
        this.soHopDongBan = 0;
    }

    @Override
    public double tinhLuong() {
        return soHopDongBan * TIEN_BH;
    }
    public void nhapLuong(String monthYear){
        //nhập số hợp đồng bán được
        Scanner sc = new Scanner(System.in);
        inTTin();
        while(true){
            System.out.println("Nhập số hợp đồng bảo hiểm bán được: ");
            String soHopDongBan = sc.nextLine();
            if(HelpMethod.checkNumber(soHopDongBan)){
                setSoHopDongBan(Integer.parseInt(soHopDongBan));
                super.setLuongTungThang(monthYear, tinhLuong());
                System.out.println("------- Kết quả ---------");
                inLuong(monthYear);
                break;
            }else{
                System.out.println("Nhập số hợp đồng bảo hiểm bán được chưa hợp lệ");
            }
        }


    }
    public void inTTin(){
        super.inTT();
        System.out.println("Loại nhân viên: Nhân viên thời vụ");
    }
    public double getTIEN_BH() {
        return TIEN_BH;
    }
    public int getSoHopDongBan() {
        return soHopDongBan;
    }

    public void setSoHopDongBan(int soHopDongBan) {
        this.soHopDongBan = soHopDongBan;
    }

}
