// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: Frequency Counting — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int longestPalindrome(String s) {

        int[] count = new int[128];

        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int frequency : count) {

            // Use the largest even portion of each character.
            length += (frequency / 2) * 2;

            // One odd-frequency character can provide
            // the center of the palindrome.
            if (frequency % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length++;
        }

        return length;
    }
}

// RANK 2: HashMap Frequency Counting — O(n) TIME, O(k) SPACE — General / Flexible
// class Solution {
//     public int longestPalindrome(String s) {

//         HashMap<Character, Integer> map = new HashMap<>();

//         for (char ch : s.toCharArray()) {
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>();

//         boolean hasOdd = false;

//         for (char ch : map.keySet()) {

//             int count = map.get(ch);

//             if (count % 2 == 0) {
//                 list.add(count);
//             } else {
//                 list.add(count - 1);
//                 hasOdd = true;
//             }
//         }

//         int length = 0;

//         for (int num : list) {
//             length += num;
//         }

//         if (hasOdd) {
//             length++;
//         }

//         return length;
//     }
// }

// RANK 3: HashSet Pairing — O(n) TIME, O(k) SPACE — Greedy / Alternative

// class Solution {
//     public int longestPalindrome(String s) {

//         HashSet<Character> set = new HashSet<>();

//         int length = 0;

//         for (char ch : s.toCharArray()) {

//             if (set.contains(ch)) {

//                 set.remove(ch);
//                 length += 2;

//             } else {

//                 set.add(ch);
//             }
//         }

//         if (!set.isEmpty()) {
//             length++;
//         }

//         return length;
//     }
// }



// Driver code to test the Solution class
public class LongestPalindrome {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        String s1 = "abccccdd";

        System.out.println(solution.longestPalindrome(s1));
        // Answer: 7

        // Test Case 2
        String s2 = "a";

        System.out.println(solution.longestPalindrome(s2));
        // Answer: 1

        // Test Case 3
        String s3 = "bb";

        System.out.println(solution.longestPalindrome(s3));
        // Answer: 2

        // Test Case 4
        String s4 = "abc";

        System.out.println(solution.longestPalindrome(s4));
        // Answer: 1

        // Test Case 5
        String s5 = "aabbcc";

        System.out.println(solution.longestPalindrome(s5));
        // Answer: 6

        // Test Case 6
        String s6 = "aaabbbbcc";

        System.out.println(solution.longestPalindrome(s6));
        // Answer: 9

        // Test Case 7
        String s7 = "Aa";

        System.out.println(solution.longestPalindrome(s7));
        // Answer: 1
    }
}