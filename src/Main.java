// Le Pham Thuy Tien 20207633
import congtyBH.CongTyBH;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        CongTyBH cty = new CongTyBH("Công ty Bảo hiểm");
        Scanner sc = new Scanner(System.in);

        while(true){
            showMenu();
            cty.inTT();

            System.out.println("\nLựa chọn của bạn (Chọn từ 1-9): ");
            String choiceStr = sc.nextLine();
            if(HelpMethod.checkNumber(choiceStr)){
                int choice = Integer.parseInt(choiceStr);
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
                        break;
                    case 7:
                        cty.tinhLuongTB();
                        break;
                    case 8:
                        cty.thongKeLuong();
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        break;
                }
            
            }else {
                System.out.println("[Error]: Nhập thông tin không hợp lệ");
            }
            
        }


    }
    public static void showMenu(){
        System.out.println("======================================================================");
        System.out.println("*                    QUẢN LÝ CÔNG TY BẢO HIỂM                        *");
        System.out.println("======================================================================");
        System.out.println("*  1. Thêm nhân viên                                                 *");
        System.out.println("*  2. Xóa nhân viên                                                  *");
        System.out.println("*  3. Cập nhật thông tin nhân viên                                   *");
        System.out.println("*  4. Tìm kiếm nhân viên                                             *");
        System.out.println("*  5. Hiển thị danh sách các nhân viên                               *");
        System.out.println("*  6. Nhập lương của nhân viên theo từng tháng                       *");
        System.out.println("*  7. Tính lương trung bình của các nhân viên tại thời điểm hiện tại *");
        System.out.println("*  8. Thống kê mức lương của nhân viên tại thời điểm nhập vào        *");
        System.out.println("*  9. Thoát                                                          *");
        System.out.println("======================================================================");
        System.out.println("");

    }
}