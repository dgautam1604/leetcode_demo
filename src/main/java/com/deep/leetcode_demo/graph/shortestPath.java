package com.deep.leetcode_demo.graph;

import java.util.*;

//solved by BFS and not DFS
public class shortestPath {

    public static int shortestPathFinder(Map<String,String[]> l, String src, String dest){
       HashSet<String> visited=new HashSet<>();
       HashMap<String,Integer> dist=new HashMap<>();
       Queue<String> q=new LinkedList<>();

       q.add(src);
       dist.put(src,0);
       while(!q.isEmpty()){
           String temp=q.remove();
           int distance=dist.get(temp);
           if(temp.equals(dest))
               return distance;
           for(String neighbour:l.get(temp)){
               if(!visited.contains(neighbour)){
                   visited.add(neighbour);
                   dist.put(neighbour,distance+1);
                   q.add(neighbour);
               }
           }
       }
       return -1;
    }
}
