
public class DeleteEarn {
/**
 * Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points.
 After, you must delete everyelement equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by 
applying such operations.
The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int num[]= {2,2,3,3,3,4};
System.out.println(deleteAndEarn2(num));

	}
	public static int deleteAndEarn(int num[]) {
		int sums[]=new int[10001];//因为取值为【1，10000】
		for(int i=0;i<num.length;i++) {
			sums[num[i]]+=num[i];
		}
		int take=0,skip=0;
		for(int i=0;i<10001;i++) {
			int takei=skip+sums[i];  //如果我们拿了当前的数字，我们就不能拿之前的数字（如果我们从小往大遍历就不需要考虑后面的数字），
									//那么当前的积分就是不拿前面的数字的积分加上当前数字之和。
			int skipi=Math.max(skip, take);//如果我们不拿当前的数字，那么对于前面的数字我们既可以拿也可以不拿，
											//于是当前的积分就是拿前面的数字的积分和不拿前面数字的积分中的较大值。
			skip=skipi;
			take=takei;
		}
		return Math.max(skip, take);
	}
	
	
	public static int deleteAndEarn2(int num[]) {
		int sums[]=new int[10001];//因为取值为【1，10000】
		for(int i=0;i<num.length;i++) {
			sums[num[i]]+=num[i];
		}
		for(int i=2;i<10001;i++) {
			sums[i]=Math.max(sums[i]+sums[i-2], sums[i-1]);
		}
		return sums[10000];
	}
}