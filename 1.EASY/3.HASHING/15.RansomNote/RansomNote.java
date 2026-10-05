// ============================ FINAL DESTINATION ============================

import java.util.HashMap;

// RANK 1: Frequency Array — O(n + m) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {

            count[ch - 'a']--;

            if (count[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}

// RANK 2: HashMap Frequency Counting — O(n + m) TIME, O(26) SPACE — GENERAL / FLEXIBLE
// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         char[] s = ransomNote.toCharArray();
//         char[] t = magazine.toCharArray();
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char ch : t) {
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
//         for (char ch : s) {
//             if (!map.containsKey(ch) || map.get(ch) == 0) {
//                 return false;
//             }
//             map.put(ch, map.get(ch) - 1);
//         }
//         return true;
//     }
// }

// RANK 3: Character Counting with Nested Search — O(n × m) TIME, O(m) SPACE — BRUTE FORCE / LEAST EFFICIENT

// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {

//         StringBuilder available = new StringBuilder(magazine);

//         for (char ch : ransomNote.toCharArray()) {

//             int index = available.indexOf(String.valueOf(ch));

//             if (index == -1) {
//                 return false;
//             }

//             available.deleteCharAt(index);
//         }

//         return true;
//     }
// }


// Driver code to test the Solution class
public class RansomNote {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                solution.canConstruct("a", "bca")); // Answer: true

        // Test Case 2
        System.out.println(
                solution.canConstruct("aa", "aba")); // Answer: true

        // Test Case 3
        System.out.println(
                solution.canConstruct("aaa", "aba")); // Answer: false

        // Test Case 4
        System.out.println(
                solution.canConstruct("bg", "efjbdfbdgfjhhaiigfhba")); // Answer: true

        // Test Case 5
        System.out.println(
                solution.canConstruct("fihjjjjei", "hjibagacbhadfaafhh")); // Answer: false
    }
}