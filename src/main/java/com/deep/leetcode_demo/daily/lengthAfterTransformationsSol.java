package com.deep.leetcode_demo.daily;

import java.util.HashMap;
import java.util.Map;

public class lengthAfterTransformationsSol {
    public int lengthAfterTransformations(String s, int t) {
        Map<String, String> map = new HashMap<>();
        String result = "";
        for (int j = 0; j < t; j++) {
            System.out.println(j);
            StringBuilder shifted = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(map.containsKey(s))
                {
                    shifted= new StringBuilder(map.get(s));
                    break;
                }
                char c = s.charAt(i);
                if (c != 'z') {
                    char shiftedChar = (char) (c + 1);
                    shifted.append(shiftedChar);
                } else {
                    shifted.append("ab");
                }
            }

            map.putIfAbsent(s, shifted.toString());
            s = shifted.toString();
        }
        return s.length();
    }

    public static void main(String[] args) {
        lengthAfterTransformationsSol obj = new lengthAfterTransformationsSol();
        String s = "jqktcurgdvlibczdsvnsg";
        int t = 7517;
        System.out.println(obj.lengthAfterTransformations(s, t));
    }
}
