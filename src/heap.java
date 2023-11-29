
public class heap {
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 > heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index - 1) /2]){
           swap(arr, index , (index - 1) / 2);
           index = (index - 1) / 2;
        }
    }
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2) {
            return;
        }
        // for(int i = 0; i < arr.length; i++) { //O(N)
        //     heapInsert(arr, i);             //O(logN)
        // }
        for(int i = arr.length - 1; i>=0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0){ //O(N)
            heapify(arr, 0, heapSize); //(logN)
            swap(arr, 0, --heapSize);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
