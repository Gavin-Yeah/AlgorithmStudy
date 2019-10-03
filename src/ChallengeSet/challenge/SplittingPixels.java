package ChallengeSet.challenge;

public class SplittingPixels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt("11111111", 2));
		System.out.println(split("000000001111111111111111"));
		
	}
	public static String split(String p) {
		String r=p.substring(0,8);
		String g=p.substring(8,16);
		String b=p.substring(16,24);
		int dis[]=new int[5];
		int min=Integer.MAX_VALUE;
	
		int a=0;
		int r1=Integer.parseInt(r,2);
		int g1=Integer.parseInt(g,2);
		int b1=Integer.parseInt(b,2);
		int[]p1= {r1,g1,b1};
	
		
		int[][]c= {{0,0,0},{255,255,255},{255,0,0},{0,255,0},{0,0,255}};
	for(int i=0;i<5;i++) {
		for(int n=0;n<3;n++) {
			dis[i]+=Math.pow(p1[n]-c[i][n], 2);
		}
		if(min>=dis[i]) {
			min=dis[i];
			a=i;
		}
		
	}
	for(int i=0;i<dis.length;i++) {
		if(min==dis[i]&&a!=i) {
			return "Ambiguous";
		}
	}
	
		switch (a) {
		case 0:
			return "black";
		case 1:
			return "white";
		case 2:
			return "red";
		case 3:
			return "green";
		case 4:
			return "blue";
	
		
		}
		return "";
		
	}

}
