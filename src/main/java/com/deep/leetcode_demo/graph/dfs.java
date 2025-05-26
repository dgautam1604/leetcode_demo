package com.deep.leetcode_demo.graph;

import java.util.Map;
import java.util.Stack;


public class dfs {
    public static void dfsPrint(Map<String,String[]> l, String src){
        Stack s=new Stack();
        s.push(src);
        while(!s.isEmpty()){
            String temp=(String)s.pop();
            System.out.println(temp);
            for(String i:l.get(temp)){
                s.push(i);
            }
        }
    }

    public static void dfsPrintRecursive(Map<String,String[]> l, String src){
        System.out.println(src);
        for(String i:l.get(src)){
            dfsPrintRecursive(l,i);
        }
    }

    public static void main(String[] args) {

    }
}
