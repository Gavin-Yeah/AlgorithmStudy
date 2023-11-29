package ChallengeSet.challenge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReformatingDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reformat("1 Aug 1984"));
	//	System.out.println(Integer.parseInt("1001",2));
		System.out.println("SS".charAt(1));
	}
	public static String reformat(String date) {
		String[] split= date.split(" ");
		int month=0;
		String ret="";
		String[] months= {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(int i=0;i<months.length;i++) {
			if(months[i].equals(split[1])) {
				month=i;
			}
		}
		
		try {
			DateFormat df=new SimpleDateFormat("ddd-MMM-yyyy");
			Date d=df.parse(split[0]+"-"+split[1]+"-" + split[2]);
			DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
			ret=df1.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return ret;
		
	}
}
