import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class mapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
       Node[] arr = new Node[3];
       arr[0] = new Node(0,3);
       arr[1] = new Node(1,2);
       arr[2] = new Node(2,5);
      

       Arrays.sort(arr, (a,b) -> a.val - b.val);
       for (Node node : arr) {
           System.out.println(node.val);
       }
       String str = "avc";
       for (char c : str.toCharArray()) {
           System.out.println(c);
       }
       TreeMap<Integer, String> treeMap = new TreeMap<>();
       treeMap.put(1,"1");
       treeMap.put(10,"10");
       treeMap.put(4, "4");
       treeMap.put(2, "2");
       treeMap.remove(10);
       treeMap.get(2);
       System.out.println(treeMap.firstKey());
       System.out.println(treeMap.floorKey(5));
       System.out.println(treeMap.ceilingKey(6));

    }
}
class Node {
    int index;
    int val;
    public Node(int index, int val) {
        this.index = index;
        this.val = val;
    }
    
    
}
