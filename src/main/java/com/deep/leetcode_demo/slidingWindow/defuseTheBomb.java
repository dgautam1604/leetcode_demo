package com.deep.leetcode_demo.slidingWindow;

public class defuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length; // total elements
        int[] result = new int[n]; // output array

        // Edge case: if k is 0, return array of 0s
        if (k == 0) return result;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            // Loop through k elements in the correct direction
            for (int j = 1; j <= Math.abs(k); j++) {
                int idx;
                if (k > 0) {
                    idx = (i + j) % n; // wrap around forwards
                } else {
                    idx = (i - j + n) % n; // wrap around backwards
                }
                sum += code[idx];
            }

            result[i] = sum;
        }

        return result;
    }

}
