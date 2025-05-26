package com.deep.leetcode_demo.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class hasPathProblems {

    public static boolean dfsPrint(Map<String,String[]> l, String src, String dest){
        Stack s=new Stack();
        s.push(src);

        while(!s.isEmpty()){
            String temp=(String)s.pop();
            if(temp.equals(dest)){
                return true;
            }
            for(String i:l.get(temp)){
                s.push(i);
            }
        }
        return false;
    }

    public static boolean dfsPrintRecursive(Map<String,String[]> l, String src, String dest){
        if(src.equals(dest)){
            return true;
        }
        for(String i:l.get(src)){
            if(dfsPrintRecursive(l,i,dest))
                return true;
        }
        return false;
    }

    public static boolean bfsPrint(Map<String,String[]> l, String src, String dest){
        Queue<String> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            String temp=q.remove();
            if(temp.equals(dest)){
                return true;
            }
            for(String i:l.get(temp)){
                q.add(i);
            }
        }
        return false;
    }
}
