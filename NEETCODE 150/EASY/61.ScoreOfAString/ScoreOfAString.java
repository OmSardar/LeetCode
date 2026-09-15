// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Simple Loop — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public int scoreOfString(String s) {
        int score = 0;

        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return score;
    }
}

// RANK 2: Char Array — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int scoreOfString(String s) {
//         char[] arr = s.toCharArray();
//         int score = 0;

//         for (int i = 1; i < arr.length; i++) {
//             score += Math.abs(arr[i] - arr[i - 1]);
//         }

//         return score;
//     }
// }


// RANK 3: Explicit ASCII Values — O(n) TIME, O(1) EXTRA SPACE — CLEAR / GOOD ALTERNATIVE
// class Solution {
//     public int scoreOfString(String s) {
//         int score = 0;

//         for (int i = 1; i < s.length(); i++) {
//             int curr = (int) s.charAt(i);
//             int prev = (int) s.charAt(i - 1);
//             score += Math.abs(curr - prev);
//         }

//         return score;
//     }
// }

// RANK 4: Recursive Approach — O(n) TIME, O(n) STACK SPACE — SIMPLE / RECURSIVE ALTERNATIVE
// class Solution {
//     public int scoreOfString(String s) {
//         return helper(s, 1);
//     }

//     private int helper(String s, int i) {
//         if (i == s.length()) return 0;

//         return Math.abs(s.charAt(i) - s.charAt(i - 1)) + helper(s, i + 1);
//     }
// }

// RANK 5: Java Streams — O(n) TIME, O(1) EXTRA SPACE — CONCISE / MODERN / MORE OVERHEAD
// import java.util.stream.IntStream;

// class Solution {
//     public int scoreOfString(String s) {
//         return IntStream.range(1, s.length())
//                 .map(i -> Math.abs(s.charAt(i) - s.charAt(i - 1)))
//                 .sum();
//     }
// }

// Driver code to test the Solution class
public class ScoreOfAString {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Standard case
        String s1 = "hello";
        System.out.println(solution.scoreOfString(s1)); // Answer: 13

        // Test Case 2: Single character
        String s2 = "a";
        System.out.println(solution.scoreOfString(s2)); // Answer: 0

        // Test Case 3: Two characters
        String s3 = "ab";
        System.out.println(solution.scoreOfString(s3)); // Answer: 1

        // Test Case 4: Increasing characters
        String s4 = "abcde";
        System.out.println(solution.scoreOfString(s4)); // Answer: 4

        // Test Case 5: Decreasing characters
        String s5 = "edcba";
        System.out.println(solution.scoreOfString(s5)); // Answer: 4

        // Test Case 6: Same characters
        String s6 = "aaaa";
        System.out.println(solution.scoreOfString(s6)); // Answer: 0

        // Test Case 7: Larger differences
        String s7 = "az";
        System.out.println(solution.scoreOfString(s7)); // Answer: 25

        // Test Case 8: Mixed characters
        String s8 = "abcxyz";
        System.out.println(solution.scoreOfString(s8)); // Answer: 25

        // Test Case 9: Alternating characters
        String s9 = "azaz";
        System.out.println(solution.scoreOfString(s9)); // Answer: 75
    }
}