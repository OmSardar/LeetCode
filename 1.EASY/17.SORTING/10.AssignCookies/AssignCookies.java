// ============================ FINAL DESTINATION ============================

// RANK 1: Sorting + Two Pointers — O(n log n + m log m) TIME, O(1) EXTRA SPACE* — BEST / OPTIMAL / MOST PRACTICAL
// *Ignoring the space used internally by the sorting implementation.

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;
        int satisfied = 0;

        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {
                satisfied++;
                child++;
            }

            cookie++;
        }

        return satisfied;
    }
}


// RANK 2: Sorting + One Pointer — O(n log n + m log m) TIME, O(1) EXTRA SPACE* — SIMPLE / EASY TO UNDERSTAND
// *Ignoring the space used internally by the sorting implementation.
// import java.util.Arrays;

// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         Arrays.sort(g);
//         Arrays.sort(s);
//         int child = 0;
//         for (int cookie : s) {
//             if (child < g.length && cookie >= g[child]) {
//                 child++;
//             }
//         }
//         return child;
//     }
// }

// RANK 3: Brute Force + Used Array — O(n × m) TIME, O(m) SPACE — SIMPLE / LEAST EFFICIENT

// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//
//         boolean[] used = new boolean[s.length];
//         int satisfied = 0;
//
//         for (int child : g) {
//
//             int bestCookie = -1;
//
//             for (int j = 0; j < s.length; j++) {
//
//                 if (!used[j] && s[j] >= child) {
//
//                     if (bestCookie == -1 || s[j] < s[bestCookie]) {
//                         bestCookie = j;
//                     }
//                 }
//             }
//
//             if (bestCookie != -1) {
//                 used[bestCookie] = true;
//                 satisfied++;
//             }
//         }
//
//         return satisfied;
//     }
// }


// Driver code to test the Solution class
public class AssignCookies {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                solution.findContentChildren(
                        new int[] { 1, 2, 3 },
                        new int[] { 1, 1 })); // Answer: 1

        // Test Case 2
        System.out.println(
                solution.findContentChildren(
                        new int[] { 1, 2 },
                        new int[] { 1, 2, 3 })); // Answer: 2

        // Test Case 3
        System.out.println(
                solution.findContentChildren(
                        new int[] { 1, 2, 3 },
                        new int[] { 3 })); // Answer: 1

        // Test Case 4
        System.out.println(
                solution.findContentChildren(
                        new int[] { 10, 9, 8, 7 },
                        new int[] { 5, 6, 7, 8 })); // Answer: 2

        // Test Case 5
        System.out.println(
                solution.findContentChildren(
                        new int[] { 1, 1, 1 },
                        new int[] { 1, 1 })); // Answer: 2
    }
}