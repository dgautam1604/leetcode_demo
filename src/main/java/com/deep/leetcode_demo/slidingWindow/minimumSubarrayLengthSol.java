package com.deep.leetcode_demo.slidingWindow;

public class minimumSubarrayLengthSol {
    public int minimumSubarrayLength(int[] nums, int k) {


                int n = nums.length;
                int minLen = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    int orVal = 0;

                    for (int j = i; j < n; j++) {
                        orVal |= nums[j]; // Expand window to the right

                        if (orVal >= k) {
                            minLen = Math.min(minLen, j - i + 1);
                            break; // No need to go further from this start index
                        }
                    }
                }

                return minLen == Integer.MAX_VALUE ? -1 : minLen;



    }

    public static void main(String[] args) {
        minimumSubarrayLengthSol obj = new minimumSubarrayLengthSol();
        int[] nums = {2,1,8};
        int k = 10;
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }
}
