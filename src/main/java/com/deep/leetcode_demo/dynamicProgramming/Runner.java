package com.deep.leetcode_demo.dynamicProgramming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private dp configDP;

    @Autowired
    public Runner(@Qualifier("climbingStairs") dp configDP) {
        this.configDP = configDP;
    }

    @Override
    public void run(String... args) throws Exception {
        // We need to cast `configDP` to ClimbingStairs to call setN()
        if (configDP instanceof ClimbingStairs) {
            ClimbingStairs climbingStairs = (ClimbingStairs) configDP;
            climbingStairs.setN(10);  // Set `n` to 10 for ClimbingStairs
        }
        // Call the solve method for the specific dynamic programming problem
        System.out.println("Solution: " + configDP.solve());
    }
}