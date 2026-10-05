// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: KMP (Knuth-Morris-Pratt) — O(n + m) TIME, O(m) SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        int[] lps = buildLPS(needle);

        int i = 0;
        int j = 0;

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }
            } else {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String needle) {

        int[] lps = new int[needle.length()];

        int len = 0;
        int i = 1;

        while (i < needle.length()) {

            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}


// RANK 2: Built-in indexOf() — O(n × m) WORST-CASE TIME, O(1) EXTRA SPACE — SIMPLEST / MOST PRACTICAL
// class Solution {
//     public int strStr(String haystack, String needle) {
//         return haystack.indexOf(needle);
//     }
// }


// RANK 3: Brute Force String Matching — O(n × m) TIME, O(1) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int strStr(String haystack, String needle) {
//
//         if (needle.length() == 0) {
//             return 0;
//         }
//
//         for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//
//             int j = 0;
//
//             while (j < needle.length()
//                     && haystack.charAt(i + j) == needle.charAt(j)) {
//                 j++;
//             }
//
//             if (j == needle.length()) {
//                 return i;
//             }
//         }
//
//         return -1;
//     }
// }

// RANK 4: Character Array Comparison — O(n × m) TIME, O(n + m) SPACE — SIMPLE / EXTRA MEMORY
// class Solution {
//     public int strStr(String haystack, String needle) {

//         if (needle.length() == 0) {
//             return 0;
//         }

//         char[] text = haystack.toCharArray();
//         char[] pattern = needle.toCharArray();

//         for (int i = 0; i <= text.length - pattern.length; i++) {

//             int j = 0;

//             while (j < pattern.length
//                     && text[i + j] == pattern[j]) {
//                 j++;
//             }

//             if (j == pattern.length) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }


// Driver code to test the Solution class
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Normal occurrence
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(
            "Test Case 1: " + solution.strStr(haystack1, needle1)
        ); // Answer: 0


        // Test Case 2: Occurrence in the middle
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(
            "Test Case 2: " + solution.strStr(haystack2, needle2)
        ); // Answer: -1


        // Test Case 3: Needle at the beginning
        String haystack3 = "hello";
        String needle3 = "he";
        System.out.println(
            "Test Case 3: " + solution.strStr(haystack3, needle3)
        ); // Answer: 0


        // Test Case 4: Needle at the end
        String haystack4 = "hello";
        String needle4 = "lo";
        System.out.println(
            "Test Case 4: " + solution.strStr(haystack4, needle4)
        ); // Answer: 3


        // Test Case 5: Needle occurs multiple times
        String haystack5 = "aaaaa";
        String needle5 = "aa";
        System.out.println(
            "Test Case 5: " + solution.strStr(haystack5, needle5)
        ); // Answer: 0


        // Test Case 6: Needle longer than haystack
        String haystack6 = "abc";
        String needle6 = "abcd";
        System.out.println(
            "Test Case 6: " + solution.strStr(haystack6, needle6)
        ); // Answer: -1


        // Test Case 7: Single character
        String haystack7 = "abc";
        String needle7 = "b";
        System.out.println(
            "Test Case 7: " + solution.strStr(haystack7, needle7)
        ); // Answer: 1


        // Test Case 8: Empty needle
        String haystack8 = "hello";
        String needle8 = "";
        System.out.println(
            "Test Case 8: " + solution.strStr(haystack8, needle8)
        ); // Answer: 0
    }
}
