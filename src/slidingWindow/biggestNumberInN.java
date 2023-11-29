package slidingWindow;

import java.util.LinkedList;

public class biggestNumberInN {
    public static int[] big(int[] arr, int n){
        int[] res = new int[arr.length - n + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!list.isEmpty() && arr[list.peekLast()] <= arr[i]){
                list.poll();
            }
            list.addLast(i);
            if(list.peekFirst() == i - n){
                list.pollFirst();
            }
            if(i >= n - 1)
            res[index++] = arr[list.peekFirst()];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,4,5,3,2,1,6,3};
        int [] res = big(arr,4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
