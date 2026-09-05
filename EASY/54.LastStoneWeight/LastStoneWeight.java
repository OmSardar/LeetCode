// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Max Heap (Priority Queue) — O(N log N), O(N) SPACE — BEST / OPTIMAL / MOST PRACTICAL
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones) pq.add(s);

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y != x) pq.add(y - x);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}


// RANK 2: Counting Sort — O(N × K), O(K) SPACE — BOUNDED-VALUE OPTIMIZATION / GOOD ALTERNATIVE
// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         int[] freq = new int[1001];

//         for (int s : stones) freq[s]++;

//         int max = 1000;

//         while (true) {
//             int y = -1, x = -1;

//             for (int i = max; i >= 1; i--) {
//                 if (freq[i] > 0) {
//                     if (y == -1) {
//                         y = i;
//                         freq[i]--;
//                     } else {
//                         x = i;
//                         freq[i]--;
//                         break;
//                     }
//                 }
//             }

//             if (x == -1) return y == -1 ? 0 : y;
//             if (y != x) freq[y - x]++;
//         }
//     }
// }

// RANK 3: Sorting Every Time — O(N² log N) WORST CASE, O(N) SPACE — SIMPLE / LESS EFFICIENT
// import java.util.*;

// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         List<Integer> list = new ArrayList<>();
//         for (int s : stones) list.add(s);

//         while (list.size() > 1) {
//             Collections.sort(list);
//             int y = list.remove(list.size() - 1);
//             int x = list.remove(list.size() - 1);
//             if (y != x) list.add(y - x);
//         }

//         return list.isEmpty() ? 0 : list.get(0);
//     }
// }

// RANK 4: Brute Force — O(N²), O(1) EXTRA SPACE — NO EXTRA DATA STRUCTURE / LEAST PRACTICAL
// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         int n = stones.length;

//         while (true) {
//             int max1 = -1, max2 = -1;
//             int i1 = -1, i2 = -1;

//             // find largest and second largest
//             for (int i = 0; i < n; i++) {
//                 if (stones[i] > max1) {
//                     max2 = max1;
//                     i2 = i1;
//                     max1 = stones[i];
//                     i1 = i;
//                 } else if (stones[i] > max2) {
//                     max2 = stones[i];
//                     i2 = i;
//                 }
//             }

//             // if only one or zero stones left
//             if (max2 == -1) return max1 == -1 ? 0 : max1;

//             // smash
//             stones[i1] = max1 - max2;
//             stones[i2] = -1; // mark as removed
//         }
//     }
// }

// Driver code to test the Solution class
public class LastStoneWeight {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Standard Case
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeight(stones1)); // Answer: 1


        // Test Case 2: All Stones Equal
        int[] stones2 = {2, 2, 2, 2};
        System.out.println(solution.lastStoneWeight(stones2)); // Answer: 0


        // Test Case 3: One Stone
        int[] stones3 = {10};
        System.out.println(solution.lastStoneWeight(stones3)); // Answer: 10


        // Test Case 4: Two Equal Stones
        int[] stones4 = {5, 5};
        System.out.println(solution.lastStoneWeight(stones4)); // Answer: 0


        // Test Case 5: Two Different Stones
        int[] stones5 = {10, 4};
        System.out.println(solution.lastStoneWeight(stones5)); // Answer: 6


        // Test Case 6: Large Difference
        int[] stones6 = {20, 3, 2};
        System.out.println(solution.lastStoneWeight(stones6)); // Answer: 15


        // Test Case 7: All Different
        int[] stones7 = {1, 3, 6, 10};
        System.out.println(solution.lastStoneWeight(stones7)); // Answer: 0


        // Test Case 8: Empty Array
        int[] stones8 = {};
        System.out.println(solution.lastStoneWeight(stones8)); // Answer: 0
    }
}