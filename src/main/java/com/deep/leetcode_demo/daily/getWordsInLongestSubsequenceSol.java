package com.deep.leetcode_demo.daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getWordsInLongestSubsequenceSol {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        List<String> result = List.of();
        for (int i = 0; i < words.length; i++) {
            int left = i;
            for(int j=i;j<words.length;j++){
                List<String> resultTemp = new java.util.ArrayList<>(List.of());
                resultTemp.add(words[i]);
                int right = left + j;
                int tempLength = 1;
                while (right < words.length) {
                    if (groups[left] != groups[right] && words[left].length() == words[right].length() && hammingCheck(words[left], words[right])) {
                        resultTemp.add(words[right]);
                        tempLength++;
                        left = right;
                        right++;
                    } else
                        right++;
                }
                if (tempLength > max) {
                    max = tempLength;
                    result = resultTemp;
                }
            }

        }
        return result;
    }

    public boolean hammingCheck(String s1, String s2) {
        int flag = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                flag++;
        }
        return flag == 1;
    }

    public static void main(String[] args) {
        getWordsInLongestSubsequenceSol obj = new getWordsInLongestSubsequenceSol();
        String[] words = {"bad","dc","bc","ccd","dd","da","cad","dba","aba"};
        int[] groups = {9,7,1,2,6,8,3,7,2};
        System.out.println(obj.getWordsInLongestSubsequence(words, groups));
    }
}
