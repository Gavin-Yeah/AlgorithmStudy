package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {
    public static List<Node> tosort(Graph graph) {
        //add node whose in = 0
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node nextNode : cur.nexts) {
                inMap.put(nextNode, inMap.get(nextNode) - 1);
                if(inMap.get(nextNode) == 0) {
                    zeroInQueue.add(nextNode);
                }
            }
        }
        return result;
    }
}
