public class bitwiseOperation {
    public static int rightestOne(int num) {
        return (~num + 1) & num;
    }

    // 所有数偶数个 一个数奇数个
    public static int oddNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    // 所有数偶数个 两个数奇数个
    public static void oddNumbers(int[] nums) {
        int eor = 0;
        for (int i : nums) {
            eor ^= i;
        }
        int rightOne = eor & (~eor + 1);
        int num = 0;
        for (int i : nums) {
            if ((i & rightOne) != 0) {
                num ^= i;
            }
        }
        System.out.println(num + "" + (eor ^ num));
    }
    public static int oneNumbers(int num){
        int count = 0;
        while(num != 0) {
            int rightOne = num & (~num + 1);
            count ++;
            num ^= rightOne;
        }
        return count;
    }
}
