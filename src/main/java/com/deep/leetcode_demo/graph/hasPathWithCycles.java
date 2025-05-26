package com.deep.leetcode_demo.graph;

import java.util.HashSet;
import java.util.Map;

public class hasPathWithCycles {
    public static boolean bfsPrint(Map<String,String[]> l, String src, String dest, HashSet<String> visited){
        if(src.equals(dest))
             return true;
        if(visited.contains(src))
            return false;

        visited.add(src);
        for(String i:l.get(src)){
            if(bfsPrint(l,i,dest,visited))
                return true;
        }
        return false;
    }
}
