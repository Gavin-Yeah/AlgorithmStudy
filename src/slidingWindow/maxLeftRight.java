package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class maxLeftRight {
    public static Integer[][] maxLeftRight1(int[] arr){
        Integer[][] res = new Integer[arr.length][2];
        LinkedList<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while(!list.isEmpty() && arr[i] > arr[list.peekLast().get(0)]){
                List<Integer> temp = list.pollLast();
                for (int j = 0; j < temp.size(); j++) {
                    Integer index = temp.get(j);
                    if(list.peekLast() != null){
                        res[index][0] = arr[list.peekLast().get(0)];
                    }else {
                        res[index][0] = null;
                    }
                    res[index][1] = arr[i];
                }    
            }
            if(list.isEmpty() || arr[i] < arr[list.peekLast().get(0)]){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                list.addLast(temp);
            } else if (arr[i] == arr[list.peekLast().get(0)]){
                list.getLast().add(i);
            }

        }
        while(!list.isEmpty()){
            List<Integer> temp = list.pollLast();
            for (int j = 0; j < temp.size(); j++) {
                Integer index = temp.get(j);
                if(list.peekLast() != null){
                    res[index][0] = arr[list.peekLast().get(0)];
                }else {
                    res[index][0] = null;
                }
                res[index][1] = null;
            }    
        }
        return res;
    }
}
