package ChallengeSet.Leetcode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PathFinder {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "C:/Users/yang liu/workspace/Interview2017/src/pocketGems/input_1.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);        
    }
    
    static List<String> parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
         *  Don't modify this function
         */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();


        return parseLines(allLines);  
    }
    
    static List<String> parseLines(List<String> allLines) {
        HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
        Set<String> visited = new HashSet<String>();
        String src = allLines.get(0).split(" ")[0];
        String dst = allLines.get(0).split(" ")[1];
        for (int i=1; i<allLines.size(); i++) {
            String line = allLines.get(i);
            String node = line.trim().split(":")[0].trim();
            String[] neibors = line.split(":")[1].trim().split(" ");
            graph.put(node, new HashSet<String>());
            for (String nb : neibors) {
                if (nb.length() != 0) graph.get(node).add(nb);
            }
        }
        
        List<String> res = new ArrayList<String>();
        visited.add(src);
        helper(res, src, src, dst, visited, graph);
        return res;
    }
    
    static void helper(List<String> res, String path, String cur, String dst, Set<String> visited, HashMap<String, HashSet<String>> graph) {
        if (cur.equals(dst)) {
            res.add(path);
            return;
        }
        HashSet<String> neibors = graph.get(cur); 
        if (neibors != null) {
            for (String each : neibors) {
                if (visited.contains(each)) continue;
                visited.add(each);
                helper(res, path+each, each, dst, visited, graph);
                visited.remove(each);
            }
        }
    }
}