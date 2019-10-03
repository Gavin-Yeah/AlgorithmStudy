package ChallengeSet.Drawbridge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * leetcode 341
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

        private ListIterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer>list= new ArrayList<>();
         flatten(nestedList.listIterator(),list);
        it=list.listIterator();
       
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
    private void flatten(ListIterator<NestedInteger> it, List<Integer> list){
        while(it.hasNext()){
            NestedInteger next= it.next();
            if(next.isInteger()){
                list.add(next.getInteger());
            }
            else{
                flatten(next.getList().listIterator(),list);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */