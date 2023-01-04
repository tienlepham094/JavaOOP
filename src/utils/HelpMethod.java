package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpMethod {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyyy");
    public static String formatDate(Date date){
        return dateFormatter.format(date);
    }
    public static Date stringToDate(String dateString) throws ParseException {
        return dateFormatter.parse(dateString);
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // check độ dài của chuỗi nhập vào
    public static boolean checkLength(String str, int length){
        if(str == null) return false;
        return str.length() >= length;
    }

    // check cmt
    public static boolean checkCMT(String str){
        return isNumeric(str) && str.trim().length() == 9;
    }

    // check là số và lớn hơn 0
    public static boolean checkNumber(String str){
        return isNumeric(str) && Double.parseDouble(str)>=0;
    }

    // kiểm tra định dạng ngày nhập
    public static boolean checkDateInput(String str){
        if (str == null) return false;
        try {
            dateFormatter.parse(str);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
