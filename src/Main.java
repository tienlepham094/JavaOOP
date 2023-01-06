import congtyBH.CongTyBH;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        CongTyBH cty = new CongTyBH("Công ty Bảo hiểm");
        Scanner sc = new Scanner(System.in);
        System.out.println("QUẢN LÝ NHÂN VIÊN CÔNG TY BẢO HIỂM");
        while(true){
            showMenu();
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    cty.themNhanVien();
                    break;
                case 2:
                    cty.xoaNV();
                    break;
                case 3:
                    break;
                case 4:
                    cty.timKiem();
                case 5:
                    break;
                case 6:
                    cty.nhapLuongHangThang();
                case 7:
                    cty.tinhLuongTB();
                case 8:
                    cty.thongKeLuong();
                case 9:
                    System.exit(0);
                default:
                    break;
            }
        }


    }
    public static void showMenu(){
        System.out.println("******************************************************************");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Xóa nhân viên");
        System.out.println("3. Cập nhật thông tin nhân viên");
        System.out.println("4. Tìm kiếm nhân viên");
        System.out.println("5. Hiển thị danh sách các nhân viên");
        System.out.println("6. Nhập lương của nhân viên theo từng tháng");
        System.out.println("7. Tính lương trung bình của các nhân viên tại thời điểm hiện tại");
        System.out.println("8. Thống kê mức lương của nhân viên tại thời điểm nhập vào");
        System.out.println("9. Thoát");

    }
}