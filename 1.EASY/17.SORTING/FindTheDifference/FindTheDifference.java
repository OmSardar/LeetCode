// ============================ FINAL DESTINATION ============================

// RANK 1: XOR — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST EFFICIENT

class Solution {
    public char findTheDifference(String s, String t) {

        int result = 0;

        for (char ch : s.toCharArray()) {
            result ^= ch;
        }

        for (char ch : t.toCharArray()) {
            result ^= ch;
        }

        return (char) result;
    }
}


// RANK 2: Frequency Array — O(n) TIME, O(1) SPACE — SIMPLE / EFFICIENT

// class Solution {
//     public char findTheDifference(String s, String t) {
//
//         int[] count = new int[26];
//
//         for (char ch : s.toCharArray()) {
//             count[ch - 'a']++;
//         }
//
//         for (char ch : t.toCharArray()) {
//
//             count[ch - 'a']--;
//
//             if (count[ch - 'a'] < 0) {
//                 return ch;
//             }
//         }
//
//         return ' ';
//     }
// }


// RANK 3: HashMap Frequency Counting — O(n) TIME, O(1) SPACE — CLEAR / GOOD FOR LEARNING

// import java.util.HashMap;
//
// class Solution {
//     public char findTheDifference(String s, String t) {
//
//         HashMap<Character, Integer> map = new HashMap<>();
//
//         for (char ch : s.toCharArray()) {
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }
//
//         for (int i = 0; i < t.length(); i++) {
//
//             char ch = t.charAt(i);
//
//             if (!map.containsKey(ch) || map.get(ch) == 0) {
//                 return ch;
//             }
//
//             map.put(ch, map.get(ch) - 1);
//         }
//
//         return ' ';
//     }
// }


// RANK 4: Sorting — O(n log n) TIME, O(n) SPACE — SIMPLE / ALTERNATIVE

// import java.util.Arrays;
//
// class Solution {
//     public char findTheDifference(String s, String t) {
//
//         char[] a = s.toCharArray();
//         char[] b = t.toCharArray();
//
//         Arrays.sort(a);
//         Arrays.sort(b);
//
//         for (int i = 0; i < a.length; i++) {
//
//             if (a[i] != b[i]) {
//                 return b[i];
//             }
//         }
//
//         return b[b.length - 1];
//     }
// }


// RANK 5: String Removal — O(n²) TIME, O(n) SPACE — BRUTE FORCE / LEAST EFFICIENT

// class Solution {
//     public char findTheDifference(String s, String t) {
//
//         StringBuilder remaining = new StringBuilder(s);
//
//         for (char ch : t.toCharArray()) {
//
//             int index = remaining.indexOf(String.valueOf(ch));
//
//             if (index == -1) {
//                 return ch;
//             }
//
//             remaining.deleteCharAt(index);
//         }
//
//         return ' ';
//     }
// }


// Driver code to test the Solution class
public class FindTheDifference {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.findTheDifference("abcd", "abcde")
        ); // Answer: e

        // Test Case 2
        System.out.println(
            solution.findTheDifference("", "y")
        ); // Answer: y

        // Test Case 3
        System.out.println(
            solution.findTheDifference("a", "aa")
        ); // Answer: a

        // Test Case 4
        System.out.println(
            solution.findTheDifference("ae", "aea")
        ); // Answer: a

        // Test Case 5
        System.out.println(
            solution.findTheDifference("abcd", "dbace")
        ); // Answer: e
    }
}