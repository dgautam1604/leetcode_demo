package com.deep.leetcode_demo.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class countSubstringKconstraint {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, count = 0;
        int ones = 0, zeros = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') ones++;
            else zeros++;

            while (ones > k && zeros > k) {
                if (s.charAt(left) == '1') ones--;
                else zeros--;
                left++;
            }

            count += (right - left + 1);
        }
        return count;
    }
    public int minimumRecolors(String blocks, int k) {
        int min=Integer.MAX_VALUE;
        for(int left=0;left<blocks.length();left++){
            int right=left;
            int count=0;
            while(right<blocks.length() && right<=left+k){
                if(blocks.charAt(right)=='W'){
                    count++;
                }
                right++;
            }
            if(count<min)
                min=count;
        }
        return min;
    }

    public int numberOfAlternatingGroups(int[] colors) {
        int count=0;
        for (int i = 0; i < colors.length-2; i++) {
            int a=colors[i];
            int b=colors[i+1];
            int c=colors[i+2];
            if(a==c && b!=c){
                count++;
            }
        }
        int i=colors.length-2;
        int a=colors[i];
        int b=colors[i+1];
        int c=colors[0];
        if(a==c && b!=c){
            count++;
        }
         a=colors[i+1];
         b=colors[0];
         c=colors[1];
        if(a==c && b!=c){
            count++;
        }

        return count;
    }

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> mpp = new HashMap<>();//key is sum of digits, value is count of numbers whose digits when added have the same sum
        int maxi = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            int x = digsum(i);
            mpp.put(x, mpp.getOrDefault(x, 0) + 1);
            maxi = Math.max(maxi, mpp.get(x));
        }
        //from maxi we will know the largest count of numbers
        // having the same sum but we won't know how many of such numbers are there
        // so we will check the count of numbers having the same sum as maxi
        // eg if it says there are 3 numbers with sum 2 and there are 3 numbers with sum 3
        //so 3 numbers with sum 2 : [2,11,20], and 3 numbers with sum 3 : [3,12,21] and if maxi is 3
        //then we will count this twice(2 arrays), as we have 3 numbers for both sum 2 and 3 and return 2
        for (int val : mpp.values()) if (val == maxi) count++;
        return count;
    }

    private static int digsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(99));
    }
}
