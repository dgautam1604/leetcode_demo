package com.deep.leetcode_demo.daily;

import java.util.*;

public class findXsum {
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Frequency map of elements in current window
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Initialize frequency map with the first k elements
        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // Compute x-sum for the first window
        result[0] = computeXSum(freqMap, x);

        // Slide the window
        for (int i = 1; i <= n - k; i++) {
            int out = nums[i - 1];       // Element going out of window
            int in = nums[i + k - 1];    // Element coming into window

            // Update frequency map
            freqMap.put(out, freqMap.get(out) - 1);
            if (freqMap.get(out) == 0) {
                freqMap.remove(out);
            }
            freqMap.put(in, freqMap.getOrDefault(in, 0) + 1);

            // Compute x-sum for current window
            result[i] = computeXSum(freqMap, x);
        }

        return result;
    }

    // Helper method to compute x-sum based on top x frequent elements
    private static int computeXSum(Map<Integer, Integer> freqMap, int x) {
        // Convert map to list of pairs [value, frequency]
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Sort by frequency descending, then value descending
        freqList.sort((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // Frequency descending
            return b[0] - a[0];                   // Value descending
        });

        int sum = 0;
        int count = 0;

        // Add up top x most frequent elements
        for (int[] pair : freqList) {
            if (count == x) break;
            sum += pair[0] * pair[1];
            count++;
        }

        return sum;
    }
    public static int maximumLengthSubstring(String s) {
        Map<Character, Integer> h=new HashMap<>();
        int left=0, right=1;
        int count=1,max=0;
        h.put(s.charAt(0),1);
        while(right<s.length()){
            char a=s.charAt(right);
            if(h.containsKey(a)){
                if(h.get(a)==2){
                    char prev=s.charAt(left);
                    h.put(prev,h.get(prev)-1);
                    left++;
                    max=Math.max(count, max);
                    count--;
                    continue;
                }else{
                    h.put(a,h.get(a)+1);
                }
            }else{
                h.put(a,1);
            }
            count++;
            right++;
        }
        return Math.max(count, max);
    }

    public static int divisorSubstrings(int num, int k) {
        String s= String.valueOf(num);
        int count=0;
        for(int i=0;i<s.length()-k+1;i++){
            String str=s.substring(i,i+k);
            int n=Integer.parseInt(str);
            if(num%n==0)
                count++;

        }
        return count;
    }
    public int minimumDifference(int[] nums, int k) {

        int diff=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        if(nums.length<2)
            return 0;
        for(int left=0;left< k;left++){
            int right=left+1;
            while(right<left+k){
                diff=nums[right]-nums[left];
                min=Math.min(min,Math.abs(diff));
                right++;
            }
        }
        return min;
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        int start=-1, mini=-1,maxi=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK)
                start=i;
            if(nums[i]==minK)
                mini=i;
            if(nums[i]==maxK)
                maxi=i;

            int valid=Math.max(0, Math.min(mini,maxi)-start);
            count+=valid;

        }
        return count;
    }
    public static int countSubarrays(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length-1;i++){
            if(2*(nums[i+1]+nums[i-1])==nums[i])
                count++;
        }
        return count;
    }

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If both upper and lower not in set, split here
            if (!(set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c)))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }

    public static long countSubarrays(int[] nums, long k) {
        long count=0;
        long sum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum*(right-left+1)>=k){
                sum=sum-nums[left];
                left++;
            }
            count=count+(right-left+1);
        }
        return count;
    }
    public static long countSubarrays3(int[] nums, int k) {
        int max=nums[0];
        for(int right=1;right<nums.length;right++){
            max=Math.max(max,nums[right]);
        }
        int left=0;long maxOccurance=0,count=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==max){
                maxOccurance++;
            }
            while(maxOccurance>=k){
                if(nums[left]==max)
                    maxOccurance--;
                left++;
            }
            count+=left;
        }
        return count;
    }

    public int maxTaskAssign(
            int[] tasks,
            int[] workers,
            int pills,
            int strength
    ) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 1, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Check if pills and strength can be used in mid tasks
    private boolean check(
            int[] tasks,
            int[] workers,
            int pills,
            int strength,
            int mid
    ) {
        int p = pills;
        int m = workers.length;
        Deque<Integer> ws = new ArrayDeque<>();
        int ptr = m - 1;
        // Enumerate each task from largest to smallest
        for (int i = mid - 1; i >= 0; --i) {
            while (ptr >= m - mid && workers[ptr] + strength >= tasks[i]) {
                ws.addFirst(workers[ptr]);
                --ptr;
            }
            if (ws.isEmpty()) {
                return false;
            } else if (ws.getLast() >= tasks[i]) {
                // If the largest element in the deque is greater than or equal to tasks[i]
                ws.pollLast();
            } else {
                if (p == 0) {
                    return false;
                }
                --p;
                ws.pollFirst();
            }
        }
        return true;
    }
    public static int minDominoRotations(int[] tops, int[] bottoms) {

        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<tops.length;i++){
            map.put(tops[i],map.getOrDefault(tops[i],0)+1);
        }
        for(int i=0;i<bottoms.length;i++){
            map2.put(bottoms[i],map2.getOrDefault(bottoms[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i: map.keySet()){
            if(map.containsKey(i) && map2.containsKey(i) && map.get(i)+map2.get(i)>=tops.length)
                list.add(i);
        }
        for(int i: map2.keySet()){
            if(map.containsKey(i) && map2.containsKey(i) && map.get(i)+map2.get(i)>=tops.length && !list.contains(i))
                list.add(i);
        }
        if(list.isEmpty())
            return -1;

        int minRotation=Integer.MAX_VALUE;
        while(!list.isEmpty()){
            int count=0;
            int key=list.get(0);
            int tempRotationTop=0;
            int tempRotationBottom=0;
            for(int i=0;i<tops.length;i++){
                if(tops[i]==key || bottoms[i]==key){
                    count++;
                    if(tops[i]!=bottoms[i] && tops[i]==key)
                        tempRotationBottom++;
                    else if(tops[i]!=bottoms[i] && bottoms[i]==key)
                        tempRotationTop++;
                }
            }
            if(count== tops.length){
                minRotation=Math.min(minRotation,Math.min(tempRotationTop,tempRotationBottom));
            }
            list.remove(0);
        }

        return minRotation==Integer.MAX_VALUE?-1:minRotation;

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map=new HashMap<>();
        for(int[] domino:dominoes){
            int[] a=domino;
            Arrays.sort(a);
            String s=Arrays.toString(a);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }
        int count=0;
        for(int val:map.values()){
            count += val * (val - 1) / 2;
        }
        return count;
    }
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=nums[nums[i]];
        }
        return res;
    }
    public static void main(String[] args) {
       int[] tops = {3,5,1,2,3};
        int[] bottom = {3,6,3,3,4};
        int[][] dominoes  = {{1,2},{2,1},{3,4},{5,6}};
//       int[] res=findXSum(nums,6,2);
//        System.out.println(maximumLengthSubstring("bcbbbcba"));
//        System.out.println(divisorSubstrings(2,1));
//        System.out.println(countSubarrays(nums,1,1));
//        System.out.println(countSubarrays3(nums,2));
//        System.out.println(minDominoRotations(tops,bottom));
        System.out.println(numEquivDominoPairs(dominoes));
    }


}
