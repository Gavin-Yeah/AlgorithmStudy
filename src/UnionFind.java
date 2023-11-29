import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Node<V>{
        public V value;
        public Node(V value){
            this.value = value;
        }
    }
    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {
            for(V cur : values){
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        public Node<V> findFather(Node<V> cur){
            Stack<Node<V>> path = new Stack<>();
            while(parents.get(cur)!=cur){
                path.push(cur);
                cur = parents.get(cur);
            }
            while(!path.isEmpty()){
                parents.put(path.pop(), cur);
            }
            return cur;
        }
        public boolean isSameSet(V a, V b){
            if(!nodes.containsKey(a) || !nodes.containsKey(b)){
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }
        public void union(V a, V b) {
            if(!nodes.containsKey(a) || !nodes.containsKey(b)){
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if(aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize > bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                sizeMap.put(big, aSetSize + bSetSize);
                parents.put(small, big);
                sizeMap.remove(small);
            }
        }

    }
    public static class User{
        String a;
        String b;
        String c;
        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static int mergeUsers(List<User> users){
        UnionSet<User> unionFind = new UnionSet<>(users);
        HashMap<String, User> aMap = new HashMap<>();
        HashMap<String, User> bMap = new HashMap<>();
        HashMap<String, User> cMap = new HashMap<>();
        for (User user : users) {
            if(aMap.containsKey(user.a)){
                unionFind.union(user, aMap.get(user.a));
            }else {
                aMap.put(user.a, user);
            }
            if(bMap.containsKey(user.b)){
                unionFind.union(user, bMap.get(user.b));
            }else {
                bMap.put(user.b, user);
            }
            if(cMap.containsKey(user.c)){
                unionFind.union(user, cMap.get(user.c));
            }else {
                cMap.put(user.c, user);
            }
        }
        return unionFind.sizeMap.size();
    }
}
