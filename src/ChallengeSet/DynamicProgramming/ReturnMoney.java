import java.util.ArrayList;
import java.util.List;

public class ReturnMoney {

	public static void main(String[] args) {
	
	StringBuilder a=new StringBuilder("2");
	a.toString();
		
		// TODO Auto-generated method stub
	//	double [] p= {0.01,0.05,0.10,0.25,0.50,1.00,2.00,5.00,10.00,20.00,50.00,100.00};
	
	}
	public static double buttom_up_cut(double []p)
    {
        double []r=new double[p.length+1];
        for(int i=1;i<=p.length;i++)
        {
            double q=-1;
            //①
            for(int j=1;j<=i;j++)
                q=Math.max(q, p[j-1]+r[i-j]);
            r[i]=q;
        }
        return r[p.length];
    }

}
