public class radixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[L...R]排序， digit
    //
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] help = new int[R - L + 1];
        for (int d = 1; d < digit; d++) {
            //count[0] 当前位是0的数字有几个
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i-1];
            }
            for (i = R; i>=L;i--) {
                j = getDitgit(arr[i],d);
                help[count[j]-1] = arr[i];
                count[j]--;
            }
            for ( i = L; i < R; i++, j++) {
                arr[i] = help[j];
            }

        }
    }
}
