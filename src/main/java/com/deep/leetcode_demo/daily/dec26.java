package com.deep.leetcode_demo.daily;
import java.util.*;

public class dec26 {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by original start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // available rooms: smallest room index first
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        // busy rooms: (endTime, roomIndex) -> earliest endTime first, tie by roomIndex
        PriorityQueue<long[]> busy = new PriorityQueue<>(
                (x, y) -> x[0] != y[0] ? Long.compare(x[0], y[0]) : Long.compare(x[1], y[1])
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0];
            long end = m[1];
            long duration = end - start;

            // Free up rooms that have finished by 'start'
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                // Assign immediately to smallest available room
                int room = available.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                // Delay: take the room that becomes free the earliest (tie -> smaller room index)
                long[] earliest = busy.poll();
                long freeTime = earliest[0];
                int room = (int) earliest[1];

                count[room]++;
                // Meeting starts at freeTime and keeps same duration
                busy.offer(new long[]{freeTime + duration, room});
            }
        }

        // Find room with max meetings (tie -> smaller index)
        int bestRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[bestRoom]) bestRoom = i;
        }
        return bestRoom;
    }
}
