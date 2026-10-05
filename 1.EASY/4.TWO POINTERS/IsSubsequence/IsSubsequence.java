// ============================ FINAL DESTINATION ============================

// RANK 1: Two Pointers — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}

// RANK 2: For-Each + Pointer — O(n) TIME, O(1) SPACE — SIMPLE / CLEAN / EASY TO UNDERSTAND

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//
//         int i = 0;
//
//         for (char ch : t.toCharArray()) {
//
//             if (i < s.length() && s.charAt(i) == ch) {
//                 i++;
//             }
//         }
//
//         return i == s.length();
//     }
// }

// RANK 3: Recursive Two Pointers — O(n) TIME, O(n) STACK SPACE — RECURSIVE / GOOD FOR LEARNING

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//
//         return check(s, t, 0, 0);
//     }
//
//     private boolean check(String s, String t, int i, int j) {
//
//         if (i == s.length()) {
//             return true;
//         }
//
//         if (j == t.length()) {
//             return false;
//         }
//
//         if (s.charAt(i) == t.charAt(j)) {
//             return check(s, t, i + 1, j + 1);
//         }
//
//         return check(s, t, i, j + 1);
//     }
// }

// RANK 4: Brute Force — O(n × m) TIME, O(n) SPACE — LEAST EFFICIENT

// class Solution {
//     public boolean isSubsequence(String s, String t) {

//         int previousIndex = -1;

//         for (char ch : s.toCharArray()) {

//             int foundIndex = -1;

//             for (int i = previousIndex + 1; i < t.length(); i++) {

//                 if (t.charAt(i) == ch) {
//                     foundIndex = i;
//                     break;
//                 }
//             }

//             if (foundIndex == -1) {
//                 return false;
//             }

//             previousIndex = foundIndex;
//         }

//         return true;
//     }
// }


// Driver code to test the Solution class
public class IsSubsequence {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.isSubsequence("abc", "ahbgdc")
        ); // Answer: true

        // Test Case 2
        System.out.println(
            solution.isSubsequence("axc", "ahbgdc")
        ); // Answer: false

        // Test Case 3
        System.out.println(
            solution.isSubsequence("", "ahbgdc")
        ); // Answer: true

        // Test Case 4
        System.out.println(
            solution.isSubsequence("abc", "abc")
        ); // Answer: true

        // Test Case 5
        System.out.println(
            solution.isSubsequence("abc", "acb")
        ); // Answer: false
    }
}