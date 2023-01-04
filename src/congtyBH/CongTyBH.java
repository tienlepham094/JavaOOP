package congtyBH;

import nhanvien.NhanVien;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CongTyBH {
    private PhongQuanLy pql;
    private String tenCongTy;

    public CongTyBH(String tenCongTy) {
        this.pql = new PhongQuanLy();
        this.tenCongTy = tenCongTy;
    }

    public void timKiem() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập lựa chọn" + "\n" +
                            "1. Tìm kiếm theo tên" + "\n"+
                            "2. Tìm kiếm theo số CMT"+ "\n"+
                            "3. Tìm kiếm theo ngày");
        System.out.println("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine());
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
                    System.out.println("Dữ liệu nhập không hợp lệ");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ !");
                break;

        }
    }

    public void tinhLuongTB(){
        double luongTB = pql.tinhLuongTB();
        if(luongTB==0){
            System.out.println("Chưa có thông tin về giờ làm thêm và số hợp đồng tháng này");
            System.out.println("Vui lòng nhập đẩy đủ các thông tin trên");
        }else{
            System.out.println("Lương TB của tất cả các nhân viên thời điểm hiện tại : " + luongTB);
        }
    }
    public void nhapLuongHangThang(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập tháng/năm mà bạn muốn nhập lương");
        String monthYear = sc.nextLine();
        pql.nhapLuongTheoThang(monthYear);
    }
}
