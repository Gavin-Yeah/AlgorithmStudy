package ChallengeSet.Leetcode;

public class Colony
{
  //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	
	  //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	  public static int[] cellCompete(int[] cells, int days)
	  {
	      int []ret=new int[8];
	    // INSERT YOUR CODE HERE
	 
	    for(int i=0;i<days;i++){
	    ret=new int[8];
	     if(cells[1]==1)ret[0]=1;
	     else ret[0]=0;
	     if(cells[6]==1)ret[7]=1;
	     else ret[7]=0;
	        for(int j=1;j<cells.length-1;j++){
	            if((cells[j+1]==0&&cells[j-1]==0)||
	            (cells[j+1]==1&&cells[j-1]==1)){
	                ret[j]=0;
	        }else {ret[j]=1;
	        }
	        }
	          cells=ret;  
	    }
	        return ret;
	  }
	  // METHOD SIGNATURE ENDS
	
  // METHOD SIGNATURE ENDS
  public static void main(String[] args) {
	 
	  int[ ]cells= {1,1,1,0,1,1,1,1};
	  int []ret=cellCompete(cells,2);
	  for(int i=0;i<ret.length;i++)
	    System.out.print(ret[i]+",");
}
}
