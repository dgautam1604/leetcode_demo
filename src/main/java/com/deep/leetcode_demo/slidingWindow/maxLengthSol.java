package com.deep.leetcode_demo.slidingWindow;
//3411. Maximum Subarray With Equal Products
//Easy
//Topics
//Companies
//Hint
//You are given an array of positive integers nums.
//
//An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:
//
//prod(arr) is the product of all elements of arr.
//gcd(arr) is the GCD of all elements of arr.
//lcm(arr) is the LCM of all elements of arr.
//Return the length of the longest product equivalent subarray of nums.
public class maxLengthSol {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxL = 0;

        for (int i = 0; i < n; i++) {
            int currGCD = nums[i];
            int currLCM = nums[i];
            int currPro = nums[i];

            for (int j = i + 1; j < n; j++) {
                currPro *= nums[j];
                currGCD = gcd(nums[j], currGCD);
                currLCM = lcm(nums[j], currLCM);

                if (currPro == currLCM * currGCD) {
                    maxL = Math.max(maxL, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxL;
    }
}

/*
* Example 1:

Input: nums = [1,2,1,2,1,1,1]
Output: 5
Explanation:
The longest product equivalent subarray is [1, 2, 1, 1, 1], where prod([1, 2, 1, 1, 1]) = 2, gcd([1, 2, 1, 1, 1]) = 1, and lcm([1, 2, 1, 1, 1]) = 2.

Example 2:

Input: nums = [2,3,4,5,6]
Output: 3
Explanation:
The longest product equivalent subarray is [3, 4, 5].

Example 3:

Input: nums = [1,2,3,1,4,5,1]
Output: 5
* */