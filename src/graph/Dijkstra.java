package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra1(Node from) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while(minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                }else{
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
            HashSet<Node> selectedNodes) {
                Set<Node> set = distanceMap.keySet();
                int min = Integer.MAX_VALUE;
                Node minNode = null;
                for (Node node : set) {
                    if(!selectedNodes.contains(node) && min > distanceMap.get(node)){
                        min = distanceMap.get(node);
                        minNode = node;
                    }
                }

        return minNode;
    }
}
