// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Frequency Array — O(n) Time, O(1) Space — FASTEST / BEST PRACTICAL / MOST EFFICIENT
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

// RANK 2: HashMap Counting — O(n) Average Time, O(k) Space — FLEXIBLE / GOOD PRACTICAL

// import java.util.HashMap;

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         if (s.length() != t.length()) {
//             return false;
//         }
//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         for (char c : t.toCharArray()) {
//             if (!map.containsKey(c) || map.get(c) == 0) {
//                 return false;
//             }
//             map.put(c, map.get(c) - 1);
//         }
//         return true;
//     }
// }

// RANK 3: Sorting — O(n log n) Time, O(n) Space — SIMPLE / EASY TO UNDERSTAND

// import java.util.Arrays;

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }
//         char arr1[] = s.toCharArray();
//         char arr2[] = t.toCharArray();
//         Arrays.sort(arr1);
//         Arrays.sort(arr2);
//         int i = 0;
//         while (i < arr1.length) {
//             if (arr1[i] != arr2[i]) {
//                 return false;
//             }
//             i++;
//         }
//         return true;
//     }
// }

// Driver code to test the Solution class
public class ValidAnagram {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // Test 1
        System.out.println(obj.isAnagram("anagram", "nagaram"));   // true

        // Test 2
        System.out.println(obj.isAnagram("rat", "car"));          // false

        // Test 3
        System.out.println(obj.isAnagram("listen", "silent"));    // true

        // Test 4
        System.out.println(obj.isAnagram("hello", "world"));      // false
    }
}