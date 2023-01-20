/**
 * Method sua(), inDS(): Nguyen Van Anh 20200035
 * Other things: Le Pham Thuy Tien 20207633
 */
package congtyBH;

import nhanvien.NhanVien;
import nhanvien.NhanVienBienChe;
import nhanvien.NhanVienThoiVu;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CongTyBH {
    private PhongQuanLy pql;
    private PhongTaiChinh ptc;
    private String tenCongTy;

    public CongTyBH(String tenCongTy) {
        this.pql = new PhongQuanLy();
        this.ptc = new PhongTaiChinh();
        this.tenCongTy = tenCongTy;
    }

    // them nhan vien
    public void themNhanVien() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn loại nhân viên bạn muốn thêm");
        System.out.println("1. Nhân viên biên chế");
        System.out.println("2. Nhân viên thời vụ");
        System.out.println("Lựa chọn của bạn: ");
        String choiceStr = sc.nextLine();
        if(HelpMethod.checkNumber(choiceStr)){
            int choice = Integer.parseInt(choiceStr);
            switch (choice) {
                case 1:
                    // upcasting
                    NhanVien nv = new NhanVienBienChe();
                    nv.nhapTT();
                    pql.themNV(nv);
                    nv.inTT();
                    break;
                case 2:
                    // down casting
                    NhanVien nvien = new NhanVienThoiVu();
                    NhanVienThoiVu nvtv = (NhanVienThoiVu) nvien;
                    nvtv.nhapTT();
                    pql.themNV(nvtv);
                    nvtv.inTTin();
                    break;
                default:
                    System.out.println("Lựa chọn của bạn ko hợp lệ");
                    break;
            }
        }else{
            System.out.println("[Error]: Nhập thông tin không hợp lệ!");
        }


    }
    // xóa nhân viên
    public void xoaNV(){
        if(pql.getDsNV().size()!=0){
            pql.inDS();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập lựa chọn thông tin cần xóa: ");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                pql.xoaNV(pql.getDsNV().get(choice-1));
                System.out.println("[Info]: Xóa nhân viên thành công");
            }catch (Exception e){
                System.out.println(e);
                System.out.println("[Error]: Nhập thông tin không hợp lệ");
                System.out.println("Xóa không thành công");
            }
        }else{
            System.out.println("Chưa tồn tại dữ liệu. Vui lòng thêm nhân viên vào dach sách trước");
        }

    }

    // sua nhan vien
    //sửa nhân viên
    public void suaNV(){
        if(pql.getDsNV().size()!=0){
            pql.inDS();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập lựa chọn thông tin cần sửa: ");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                pql.suaNV(pql.getDsNV().get(choice-1));
                System.out.println("[Info]: Sửa nhân viên thành công");
            }catch (Exception e){
                System.out.println(e);
                System.out.println("[Error]: Nhập thông tin không hợp lệ");
                System.out.println("Sửa không thành công");
            }
        }else{
            System.out.println("Chưa tồn tại dữ liệu. Vui lòng thêm nhân viên vào dach sách trước");
        }
    }
    // tìm kiếm
    public void timKiem() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập lựa chọn" + "\n" +
                            "1. Tìm kiếm theo tên" + "\n"+
                            "2. Tìm kiếm theo số CMT"+ "\n"+
                            "3. Tìm kiếm theo ngày");
        System.out.println("Lựa chọn của bạn: ");
        String choice_str = sc.nextLine();
        if(HelpMethod.checkNumber(choice_str)){
            int choice = Integer.parseInt(choice_str);
            String keywords;
            switch(choice){
                case 1 :
                    System.out.println("Nhập từ khóa tên nhân viên bạn muốn tìm kiếm");
                    keywords = sc.nextLine();
                    ArrayList <NhanVien> result1 = pql.timKiem(keywords);
                    if(result1.size() == 0) System.out.println("Không tìm thấy dữ liệu");
                    else {
                        for(NhanVien nv: result1){
                            nv.inTT();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập CMT bạn muốn tìm kiếm");
                    keywords = sc.nextLine();
                    ArrayList<NhanVien> result2 = pql.timKiemCMT(keywords);
                    if(result2.size() == 0) System.out.println("Không tìm thấy dữ liệu");
                    else {
                        for(NhanVien nv: result2){
                            nv.inTT();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập ngày tháng năm bạn muốn tìm kiếm");
                    keywords = sc.nextLine();
                    if(HelpMethod.checkDateInput(keywords)){
                        Date date = HelpMethod.stringToDate(keywords);
                        ArrayList<NhanVien> result3 = pql.timKiem(date);
                        if(result3.size()==0) System.out.println("Không tìm thấy dữ liệu");
                        else{
                            for(NhanVien nv: result3){
                                nv.inTT();
                            }
                        }
                    }else{
                        System.out.println("[Error]: Nhập thông tin không hợp lệ");
                    }
                    break;
                default:
                    System.out.println("[Error]: Lựa chọn không hợp lệ !");
                    break;

            }

        }else{
            System.out.println("[Error]: Nhập thông tin không hợp lệ");
        }
    }


    // tính lương TB tại thời điểm hiện tại
    public void tinhLuongTB(){
        double luongTB = ptc.tinhLuongTB(pql.getDsNV());
        if(luongTB==0){
            System.out.println("Chưa có thông tin về giờ làm thêm và số hợp đồng tháng này");
            System.out.println("Vui lòng nhập đẩy đủ các thông tin trên");
        }else{
            System.out.println("Lương TB của tất cả các nhân viên thời điểm hiện tại : " + HelpMethod.formatNumber(luongTB));
        }
    }

    // nhập lương của nhân viên theo tháng
    public void nhapLuongHangThang(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập MM/YYYY mà bạn muốn nhập lương");
        String monthYear = sc.nextLine();
        if(HelpMethod.checkMonthYearInput(monthYear)){
            ptc.nhapLuongTheoThang(monthYear, pql.getDsNV());
        }else{
            System.out.println("[Error]: Nhập thông tin không hợp lệ. Vui lòng nhập thông tin đúng định dạng");
        }
    }

    // thống kê luong tại một thời điểm bất kì
    public void thongKeLuong(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập MM/YYYY mà bạn muốn nhập lương");
        String monthYear = sc.nextLine();
        if(HelpMethod.checkMonthYearInput(monthYear)){
            ptc.inLuongTheoThang(monthYear, pql.getDsNV());
        }else{
            System.out.println("[Error]: Nhập thông tin không hợp lệ");
        }

    }
    // in danh sach
    public void inDS(){
        pql.inDS();
    }
    public void inTT(){
        System.out.println("Tên công ty: " + getTenCongTy());
        System.out.println("Tổng số nhân viên: " + pql.getSoNV());
    }
    public String getTenCongTy() {
        return tenCongTy;
    }
}
