import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 6, 3, 2, 1, 7 };
        swap(arr, 1, 2);
        // selectionSort(arr);
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // for 0 to N - 1, find the min value and swap it
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        // 0 - n-1
        // 0 - n-2
        for (int i = arr.length - 1; i > 0; i--) {
            boolean sorted = true;
            // 0 1
            // 1 2
            // i-1 i
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    sorted = false;
                    swap(arr, j + 1, j);
                }
            }
            if (sorted)
                return;
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        mergeSort(arr1);
        mergeSort(arr2);
        merge(arr1, arr2, arr);
    }

    private static void merge(int[] arr1, int[] arr2, int[] arr) {
        int i1 = 0, i2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr1[i1++];
            } else if (i2 == arr2.length) {
                arr[i] = arr2[i2++];
            } else if (arr1[i1] > arr2[i2]) {
                arr[i] = arr2[i2++];
            } else {
                arr[i] = arr1[i1++];
            }
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        process3(arr, 0, arr.length - 1);

    }

    private static void process3(int[] arr, int L, int R) {
        if (L >= R)
            return;
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalLand = netherlandsFlag(arr, L, R);
        process3(arr, L, equalLand[0] - 1);
        process3(arr, equalLand[1] + 1, R);
    }

    // arr[L...R] 荷兰国旗问题的划分，以arr[R]作划分值
    // <arr[R] ==arr[R] >arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R)
            return new int[] { -1, -1 };
        if (L == R)
            return new int[] { L, R };
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        // int tmp = arr[i];
        // arr[i] = arr[j];
        // arr[j] = tmp;
    }
}
