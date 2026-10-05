// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Single Array (Smart Optimization) — O(T + N), O(N) SPACE — BEST / MOST EFFICIENT / OPTIMAL
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] t : trust) {
            score[t[0]]--;
            score[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}

// RANK 2: In-degree & Out-degree — O(T + N), O(N) SPACE — CLEAR / STANDARD / EASY TO UNDERSTAND
// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         int[] in = new int[n + 1];
//         int[] out = new int[n + 1];

//         for (int[] t : trust) {
//             out[t[0]]++;
//             in[t[1]]++;
//         }

//         for (int i = 1; i <= n; i++) {
//             if (in[i] == n - 1 && out[i] == 0) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// RANK 3: HashSet + Count — O(T + N), O(N) SPACE — GOOD ALTERNATIVE / EXTRA HASHSET OVERHEAD
// import java.util.*;

// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         int[] trustedBy = new int[n + 1];
//         Set<Integer> trustsSomeone = new HashSet<>();

//         for (int[] t : trust) {
//             trustsSomeone.add(t[0]);
//             trustedBy[t[1]]++;
//         }

//         for (int i = 1; i <= n; i++) {
//             if (!trustsSomeone.contains(i) && trustedBy[i] == n - 1) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// RANK 4: Brute Force — O(N × T), O(1) EXTRA SPACE — LEAST EFFICIENT / BRUTE FORCE
// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         for (int i = 1; i <= n; i++) {
//             int in = 0;
//             boolean out = false;

//             for (int[] t : trust) {
//                 if (t[0] == i) out = true;
//                 if (t[1] == i) in++;
//             }

//             if (!out && in == n - 1) return i;
//         }
//         return -1;
//     }
// }

// Driver code to test the Solution class
public class FindTheTownJudge {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Clear Town Judge
        int n1 = 2;
        int[][] trust1 = {
            {1, 2}
        };

        System.out.println(solution.findJudge(n1, trust1)); // Answer: 2


        // Test Case 2: No Judge
        int n2 = 3;
        int[][] trust2 = {
            {1, 3},
            {2, 3},
            {3, 1}
        };

        System.out.println(solution.findJudge(n2, trust2)); // Answer: -1


        // Test Case 3: Judge with Multiple People
        int n3 = 3;
        int[][] trust3 = {
            {1, 3},
            {2, 3}
        };

        System.out.println(solution.findJudge(n3, trust3)); // Answer: 3


        // Test Case 4: Judge Trusts Someone → Not Judge
        int n4 = 3;
        int[][] trust4 = {
            {1, 3},
            {2, 3},
            {3, 2}
        };

        System.out.println(solution.findJudge(n4, trust4)); // Answer: -1


        // Test Case 5: Single Person
        int n5 = 1;
        int[][] trust5 = {};

        System.out.println(solution.findJudge(n5, trust5)); // Answer: 1


        // Test Case 6: Nobody Trusts Anyone
        int n6 = 4;
        int[][] trust6 = {};

        System.out.println(solution.findJudge(n6, trust6)); // Answer: -1


        // Test Case 7: Judge with Many People
        int n7 = 4;
        int[][] trust7 = {
            {1, 4},
            {2, 4},
            {3, 4}
        };

        System.out.println(solution.findJudge(n7, trust7)); // Answer: 4
    }
}