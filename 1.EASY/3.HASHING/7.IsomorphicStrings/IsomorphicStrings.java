
// ============================ FINAL DESTINATION ============================
import java.util.HashMap;

// RANK 1: Two Array Mapping — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapST[a] != 0 && mapST[a] != b) {
                return false;
            }

            if (mapTS[b] != 0 && mapTS[b] != a) {
                return false;
            }

            mapST[a] = b;
            mapTS[b] = a;
        }

        return true;
    }
}

// RANK 2: Two HashMaps — O(n) TIME, O(n) SPACE — CLEAR / GENERAL HASHING APPROACH
// class Solution {

//     public boolean isIsomorphic(String s, String t) {

//         if (s.length() != t.length()) {
//             return false;
//         }

//         HashMap<Character, Character> a = new HashMap<>();
//         HashMap<Character, Character> b = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {

//             char x = s.charAt(i);
//             char y = t.charAt(i);

//             if (a.containsKey(x) && a.get(x) != y) {
//                 return false;
//             }

//             if (b.containsKey(y) && b.get(y) != x) {
//                 return false;
//             }

//             a.put(x, y);
//             b.put(y, x);
//         }

//         return true;
//     }
// }

// RANK 3: HashMap + HashSet — O(n) TIME, O(n) SPACE — SIMPLE / INTUITIVE
// class Solution {
//     public boolean isIsomorphic(String s, String t) {

//         HashMap<Character, Character> map = new HashMap<>();
//         HashSet<Character> used = new HashSet<>();

//         for (int i = 0; i < s.length(); i++) {

//             char a = s.charAt(i);
//             char b = t.charAt(i);

//             if (map.containsKey(a)) {

//                 if (map.get(a) != b) {
//                     return false;
//                 }

//             } else {

//                 if (used.contains(b)) {
//                     return false;
//                 }

//                 map.put(a, b);
//                 used.add(b);
//             }
//         }

//         return true;
//     }
// }

// RANK 4: Character Frequency Pattern — O(n) TIME, O(n) SPACE — PATTERN-BASED / ALTERNATIVE

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//
//         HashMap<Character, Integer> mapS = new HashMap<>();
//         HashMap<Character, Integer> mapT = new HashMap<>();
//
//         for (int i = 0; i < s.length(); i++) {
//
//             char a = s.charAt(i);
//             char b = t.charAt(i);
//
//             if (!mapS.containsKey(a)) {
//                 mapS.put(a, i);
//             }
//
//             if (!mapT.containsKey(b)) {
//                 mapT.put(b, i);
//             }
//
//             if (!mapS.get(a).equals(mapT.get(b))) {
//                 return false;
//             }
//         }
//
//         return true;
//     }
// }


// Driver code to test the Solution class
public class IsomorphicStrings {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Valid isomorphic strings
        String s1 = "egg";
        String t1 = "add";
        System.out.println(
                "Test Case 1: " + solution.isIsomorphic(s1, t1)); // Answer: true

        // Test Case 2: Invalid mapping
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(
                "Test Case 2: " + solution.isIsomorphic(s2, t2)); // Answer: false

        // Test Case 3: Valid repeated pattern
        String s3 = "paper";
        String t3 = "title";
        System.out.println(
                "Test Case 3: " + solution.isIsomorphic(s3, t3)); // Answer: true

        // Test Case 4: Invalid repeated pattern
        String s4 = "bbbaaaba";
        String t4 = "aaabbbba";
        System.out.println(
                "Test Case 4: " + solution.isIsomorphic(s4, t4)); // Answer: false

        // Test Case 5: Single characters
        String s5 = "a";
        String t5 = "b";
        System.out.println(
                "Test Case 5: " + solution.isIsomorphic(s5, t5)); // Answer: true

        // Test Case 6: Same strings
        String s6 = "abc";
        String t6 = "abc";
        System.out.println(
                "Test Case 6: " + solution.isIsomorphic(s6, t6)); // Answer: true

        // Test Case 7: Different characters with same pattern
        String s7 = "abc";
        String t7 = "def";
        System.out.println(
                "Test Case 7: " + solution.isIsomorphic(s7, t7)); // Answer: true

        // Test Case 8: Different lengths
        String s8 = "ab";
        String t8 = "abc";
        System.out.println(
                "Test Case 8: " + solution.isIsomorphic(s8, t8)); // Answer: false
    }
}