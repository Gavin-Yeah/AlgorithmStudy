package graph;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Kruskal {
    public static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node n) {
            Stack<Node> stack = new Stack<>();
            while (fatherMap.get(n) != n) {
                stack.push(n);
                n = fatherMap.get(n);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), n);
            }
            return n;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aDai = findFather(a);
            Node bDai = findFather(b);
            if (aDai != bDai) {
                int aSize = sizeMap.get(a);
                int bSize = sizeMap.get(b);
                Node big = aSize > bSize ? a : b;
                Node small = big == a ? b : a;
                fatherMap.put(small, big);
                sizeMap.put(big, aSize + bSize);
                sizeMap.remove(small);
            }
        }

        public static class EdgeComparator implements Comparator<Edge> {

            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }

        }
        public static Set<Edge> kruskalMST(Graph graph){
            UnionFind unionFind = new UnionFind();
            unionFind.makeSets(graph.nodes.values());
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
            for (Edge edge : graph.edges) { // M条边
                priorityQueue.add(edge); // O(log M)
            }
            Set<Edge> result = new HashSet<>();
            while(!priorityQueue.isEmpty()){ // M 条边
                Edge edge = priorityQueue.poll(); //O(logM)
                if(!unionFind.isSameSet(edge.from, edge.to)){ //O(1)
                    result.add(edge);
                    unionFind.union(edge.from, edge.to);
                }
            }
            return result;
        }
    }
}
