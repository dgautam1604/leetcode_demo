package com.deep.leetcode_demo.graph;

import java.util.HashSet;
import java.util.Map;

public class connectedGraphs {
    public static boolean explore(Map<String,String[]> l, String src, HashSet<String> visited){
        if(visited.contains(src))
            return false;
        visited.add(src);

        for(String i:l.get(src)){
            explore(l,i,visited);
        }
        return true;
    }

    public static int connectedGraphsFinder(Map<String,String[]> l){
        HashSet<String> visited=new HashSet<>();
        int count=0;
        for(String i:l.keySet()){
            if(explore(l,i,visited))
                count++;
        }
        return count;
    }
}
