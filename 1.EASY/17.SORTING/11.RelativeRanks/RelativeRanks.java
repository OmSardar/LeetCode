// ============================ FINAL DESTINATION ============================

// RANK 1: Sorting + HashMap — O(n log n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // Copy scores so that the original array remains unchanged
        int[] sorted = score.clone();

        // Sort from smallest to largest
        Arrays.sort(sorted);

        // Map score → rank
        HashMap<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int rank = n - i;

            if (rank == 1) {
                rankMap.put(sorted[i], "Gold Medal");
            }
            else if (rank == 2) {
                rankMap.put(sorted[i], "Silver Medal");
            }
            else if (rank == 3) {
                rankMap.put(sorted[i], "Bronze Medal");
            }
            else {
                rankMap.put(sorted[i], String.valueOf(rank));
            }
        }

        // Build answer in original order
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(score[i]);
        }

        return result;
    }
}


// RANK 2: Sorting + Index Tracking — O(n log n) TIME, O(n) SPACE — CLEAN / GOOD ALTERNATIVE
/*
import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Integer[] indexes = new Integer[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        // Sort indexes according to scores
        Arrays.sort(indexes, (a, b) -> score[b] - score[a]);

        String[] result = new String[n];

        for (int rank = 0; rank < n; rank++) {

            int index = indexes[rank];

            if (rank == 0) {
                result[index] = "Gold Medal";
            }
            else if (rank == 1) {
                result[index] = "Silver Medal";
            }
            else if (rank == 2) {
                result[index] = "Bronze Medal";
            }
            else {
                result[index] = String.valueOf(rank + 1);
            }
        }

        return result;
    }
}
*/


// RANK 3: Priority Queue (Max Heap) — O(n log n) TIME, O(n) SPACE — HEAP-BASED ALTERNATIVE
/*
import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int num : score) {
            pq.offer(num);
        }

        HashMap<Integer, String> rankMap = new HashMap<>();

        int rank = 1;

        while (!pq.isEmpty()) {

            int num = pq.poll();

            if (rank == 1) {
                rankMap.put(num, "Gold Medal");
            }
            else if (rank == 2) {
                rankMap.put(num, "Silver Medal");
            }
            else if (rank == 3) {
                rankMap.put(num, "Bronze Medal");
            }
            else {
                rankMap.put(num, String.valueOf(rank));
            }

            rank++;
        }

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(score[i]);
        }

        return result;
    }
}
*/


// RANK 4: Brute Force — O(n²) TIME, O(n) SPACE — SIMPLE / LEAST EFFICIENT
/*
class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {

            int rank = 1;

            for (int j = 0; j < n; j++) {

                if (score[j] > score[i]) {
                    rank++;
                }
            }

            if (rank == 1) {
                result[i] = "Gold Medal";
            }
            else if (rank == 2) {
                result[i] = "Silver Medal";
            }
            else if (rank == 3) {
                result[i] = "Bronze Medal";
            }
            else {
                result[i] = String.valueOf(rank);
            }
        }

        return result;
    }
}
*/


// Driver code to test the Solution class
public class RelativeRanks {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1
        int[] score1 = {5, 4, 3, 2, 1};

        System.out.println(
            "Test 1: " +
            Arrays.toString(solution.findRelativeRanks(score1)) +
            "    // Answer: [Gold Medal, Silver Medal, Bronze Medal, 4, 5]"
        );


        // Test 2
        int[] score2 = {10, 3, 8, 9, 4};

        System.out.println(
            "Test 2: " +
            Arrays.toString(solution.findRelativeRanks(score2)) +
            "    // Answer: [Gold Medal, 5, Bronze Medal, Silver Medal, 4]"
        );


        // Test 3
        int[] score3 = {100};

        System.out.println(
            "Test 3: " +
            Arrays.toString(solution.findRelativeRanks(score3)) +
            "    // Answer: [Gold Medal]"
        );


        // Test 4
        int[] score4 = {100, 90};

        System.out.println(
            "Test 4: " +
            Arrays.toString(solution.findRelativeRanks(score4)) +
            "    // Answer: [Gold Medal, Silver Medal]"
        );


        // Test 5
        int[] score5 = {100, 90, 80};

        System.out.println(
            "Test 5: " +
            Arrays.toString(solution.findRelativeRanks(score5)) +
            "    // Answer: [Gold Medal, Silver Medal, Bronze Medal]"
        );


        // Test 6
        int[] score6 = {50, 20, 80, 40, 70, 60, 30, 10};

        System.out.println(
            "Test 6: " +
            Arrays.toString(solution.findRelativeRanks(score6)) +
            "    // Answer: [5, 8, Gold Medal, 6, Silver Medal, Bronze Medal, 7, 8]"
        );


        // Test 7
        int[] score7 = {1, 2, 3, 4, 5};

        System.out.println(
            "Test 7: " +
            Arrays.toString(solution.findRelativeRanks(score7)) +
            "    // Answer: [5, 4, Bronze Medal, Silver Medal, Gold Medal]"
        );


        // Test 8
        int[] score8 = {30, 10, 50, 20, 40};

        System.out.println(
            "Test 8: " +
            Arrays.toString(solution.findRelativeRanks(score8)) +
            "    // Answer: [4, 5, Gold Medal, 4, Silver Medal]"
        );
    }
}