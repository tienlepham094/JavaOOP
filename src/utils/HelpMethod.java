package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpMethod {
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyyy");
    public  String formatDate(Date date){
        return dateFormatter.format(date);
    }
    public Date stringToDate(String dateString) throws ParseException {
        return dateFormatter.parse(dateString);
    }

}
