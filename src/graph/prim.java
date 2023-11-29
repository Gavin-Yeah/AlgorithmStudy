package graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class prim {
    public static Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Edge> result = new HashSet<>();
        HashSet<Node> set = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if(!set.contains(node)){ // start node
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
