package Test;
import utils.HelpMethod;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số ");
        String number = sc.nextLine();
//        System.out.println(HelpMethod.checkNumber(number));
        System.out.println(HelpMethod.checkDateInput(number));
    }
}
