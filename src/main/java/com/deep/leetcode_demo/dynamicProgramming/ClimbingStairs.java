package com.deep.leetcode_demo.dynamicProgramming;

import org.springframework.stereotype.Component;

@Component
public class ClimbingStairs extends dp{
    private int n;

    // Constructor - no need to initialize `n` here
    public ClimbingStairs() {
        // Spring will call the setter to inject `n` later
    }

    // Setter method for `n` - This will be called by Spring to inject the value of `n`
    public void setN(int n) {
        this.n = n;
    }

    @Override
    public int solve() {
        return climbStairs(n);
    }

    private int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
