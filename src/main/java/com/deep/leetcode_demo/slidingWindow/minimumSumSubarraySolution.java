package com.deep.leetcode_demo.slidingWindow;

import java.util.List;

public class minimumSumSubarraySolution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int sum=0;
        for(int i=0;i<l;i++){
            sum+=nums.get(i);
        }
        int minSum=sum;
        for(int i=l;i<nums.size()&&i<=r;i++){
            sum+=nums.get(i);
            minSum=Math.min(minSum,sum);
        }
        int left=0;
        int right=r+1;
        while(right<nums.size()){
            sum-=nums.get(left);
            sum+=nums.get(right);
            minSum=Math.min(minSum,sum);
            left++;
            right++;
        }
        return minSum>0?minSum:-1;
    }

    public static void main(String[] args) {
        minimumSumSubarraySolution obj = new minimumSumSubarraySolution();
        List<Integer> nums = List.of(1,2,3,4);
        int l = 2;
        int r = 4;
        System.out.println(obj.minimumSumSubarray(nums, l, r));
    }
}
