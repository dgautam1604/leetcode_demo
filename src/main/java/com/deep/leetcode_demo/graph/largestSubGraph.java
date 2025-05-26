package com.deep.leetcode_demo.graph;

import java.util.HashSet;
import java.util.Map;

public class largestSubGraph {
    public static int explore(Map<String,String[]> l, String src, HashSet<String> visited){
        if(visited.contains(src))
            return 0;
        visited.add(src);
        int size=1;
        for(String i:l.get(src)){
            size+=explore(l,i,visited);
        }
        return size;
    }

    public static int connectedGraphsFinder(Map<String,String[]> l){
        HashSet<String> visited=new HashSet<>();
        int largest=0;
        for(String i:l.keySet()){
            int size=explore(l,i,visited);
                largest=Math.max(largest,size);
        }
        return largest;
    }
}
