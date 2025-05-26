package com.deep.leetcode_demo.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class bfs {
    public static void bfsPrint(Map<String,String[]> l, String src){
        Queue<String> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            String temp=q.remove();
            System.out.println(temp);
            for(String i:l.get(temp)){
                q.add(i);
            }
        }
    }
}
