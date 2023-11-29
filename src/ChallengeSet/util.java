package ChallengeSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class util {
    public static void main(String[] args) {
        // char arr to int
        char[] arr = { '2', '4' };
        System.out.println(Integer.parseInt(new String(arr)));
        // reformat date
        DateFormat df = new SimpleDateFormat("ddMMMyyyy");
        Date d;
        try {
            d = df.parse("12121999");
            DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df1.format(d);
            System.out.println(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
}
