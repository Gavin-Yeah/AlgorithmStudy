package ChallengeSet.Leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1) );    // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2) );         // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1) );          // returns -1 (not found)
		System.out.println(cache.get(3) );          // returns 3
		System.out.println(cache.get(4) );         // returns 4
	}
	
	   private int capacity;
	    private int count;
	    private HashMap<Integer,Integer>map;
	    private LinkedList<Integer> list;
	    public LRUCache(int capacity) {
	    	map=new HashMap<>();
	        this.capacity=capacity;
	        count=0;
	        list= new LinkedList<>();
	    }
	    
	    public int get(int key) {
	   
	       Integer value= map.get(key);
	     //  System.out.println("key" + key);
	        if(value==null) return -1;
	          if(list.contains(key)){
	            list.remove((Integer)key);
	        }
	        list.add(key);
	         return value;
	        
	    }
	    
	    public void put(int key, int value) {
	        
	    	if(list.contains(key)){
	            list.remove((Integer)key);    
	        }
	             list.add(key); 
	        if(map.containsKey(key)){ 
	            map.put(key,value); 
	            return;
	        }
	    
	        if(count<capacity){   
	            count++;
	        }else
	        if(count==capacity){
	        	Integer de=list.poll();
	            map.remove((Integer)de);   
	          
	      //      System.out.println("delete"+de);
	            
	        }
	        map.put(key,value); 
	       
	    }

}
