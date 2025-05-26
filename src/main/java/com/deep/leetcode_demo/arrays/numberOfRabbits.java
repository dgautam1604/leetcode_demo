package com.deep.leetcode_demo.arrays;

import java.util.HashMap;

public class numberOfRabbits {

    public int numRabbits(int[] answers) {
        int result=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (map.containsKey(answers[i])) {
                map.put(answers[i], map.get(answers[i]) + 1);

                int key = answers[i];
                int val = map.get(answers[i]);
                if(val>key+1) {
                    result = result + key + 1;
                    val=val - key -1;
                    map.put(answers[i],val);
                }

            }
            else
                map.put(answers[i],1);
        }

        for(int i: map.keySet()){
            result=result+i+1;
        }
        return result;
    }

    public static void main(String[] args) {
        numberOfRabbits obj = new numberOfRabbits();
        int[] answers = {1, 1, 2};
        System.out.println(obj.numRabbits(answers));
    }
}
