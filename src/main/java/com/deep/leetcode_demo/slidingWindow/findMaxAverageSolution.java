package com.deep.leetcode_demo.slidingWindow;

public class findMaxAverageSolution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double avg= (double) sum /k;
        int right=k;
        while(right<nums.length){
            sum-=nums[left];
            sum+=nums[right];
            avg=Math.max(avg,(double) sum /k);
            left++;
            right++;
        }
        return avg;
    }
}
