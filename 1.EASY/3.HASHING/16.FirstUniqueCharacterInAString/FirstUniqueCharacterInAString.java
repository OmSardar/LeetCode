// ============================ FINAL DESTINATION ============================

import java.util.HashMap;

// RANK 1: Frequency Array + Second Traversal — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int firstUniqChar(String s) {

        int[] count = new int[26];

        // Count every character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Find the first character that appears once
        for (int i = 0; i < s.length(); i++) {

            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

// RANK 2: HashMap + Second Traversal — O(n) TIME, O(1) SPACE — GENERAL / FLEXIBLE
// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char ch : s.toCharArray()) {
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
//         for (int i = 0; i < s.length(); i++) {
//             if (map.get(s.charAt(i)) == 1) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// RANK 3: Brute Force — O(n²) TIME, O(1) SPACE — SIMPLE / LEAST EFFICIENT

// class Solution {
//     public int firstUniqChar(String s) {
//
//         for (int i = 0; i < s.length(); i++) {
//
//             boolean unique = true;
//
//             for (int j = 0; j < s.length(); j++) {
//
//                 if (i != j && s.charAt(i) == s.charAt(j)) {
//                     unique = false;
//                     break;
//                 }
//             }
//
//             if (unique) {
//                 return i;
//             }
//         }
//
//         return -1;
//     }
// }


// Driver code to test the Solution class
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                solution.firstUniqChar("leetcode")); // Answer: 0

        // Test Case 2
        System.out.println(
                solution.firstUniqChar("loveleetcode")); // Answer: 2

        // Test Case 3
        System.out.println(
                solution.firstUniqChar("aabb")); // Answer: -1

        // Test Case 4
        System.out.println(
                solution.firstUniqChar("z")); // Answer: 0

        // Test Case 5
        System.out.println(
                solution.firstUniqChar("aabbc")); // Answer: 4
    }
}