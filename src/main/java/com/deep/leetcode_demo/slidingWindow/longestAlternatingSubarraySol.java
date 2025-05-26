package com.deep.leetcode_demo.slidingWindow;

public class longestAlternatingSubarraySol {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int[] temp = nums.clone();
        int left=0;
        int hasEven=0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]%2==0){
                left=i;
                hasEven=1;
                break;
            }
        }
        if(hasEven==0){
            return 0;
        }

//        int max=0;
        int longestCount=0;
        while(left<temp.length){
            int count=0;
            int flag=0;
            int right=left;
            while(right<temp.length && temp[right]<=threshold){
                if(temp[right]%2==flag){
                    count++;
                }else{
                    break;
                }
                flag=flag==0?1:0;
                right++;
            }
            if(count>longestCount){
//                max=right-left;
                longestCount=count;
            }
            if(right>=temp.length-1)
                break;

            if(temp[right]>threshold){
                while( right<temp.length-1 && temp[right]>threshold){
                    right++;
                }
            }
            left=right;


            while( temp[left]%2!=0 && left<temp.length-1){
                left++;
            }

        }
        return longestCount;
    }

    public static void main(String[] args) {
        longestAlternatingSubarraySol obj = new longestAlternatingSubarraySol();
        int[] nums = {3,2,5,4};
        int threshold = 5;
//        System.out.println(obj.longestAlternatingSubarray(nums, threshold));
        int[] nums1 = {4,4,4};
        int threshold1 = 8;
        System.out.println(obj.longestAlternatingSubarray(nums1, threshold1));
        int[] nums2 = {2,3,4,5};
        int threshold2 = 4;
        System.out.println(obj.longestAlternatingSubarray(nums2,threshold2));
    }
}
//2760. Longest Even Odd Subarray With Threshold
//Easy
//Topics
//Companies
//Hint
//You are given a 0-indexed integer array nums and an integer threshold.
//
//Find the length of the longest subarray of nums starting at index l and ending at index r (0 <= l <= r < nums.length) that satisfies the following conditions:
//
//nums[l] % 2 == 0
//For all indices i in the range [l, r - 1], nums[i] % 2 != nums[i + 1] % 2
//For all indices i in the range [l, r], nums[i] <= threshold
//Return an integer denoting the length of the longest such subarray.
//
//Note: A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,5,4], threshold = 5
//Output: 3
//Explanation: In this example, we can select the subarray that starts at l = 1 and ends at r = 3 => [2,5,4]. This subarray satisfies the conditions.
//Hence, the answer is the length of the subarray, 3. We can show that 3 is the maximum possible achievable length.