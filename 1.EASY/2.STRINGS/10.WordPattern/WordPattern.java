// ============================ FINAL DESTINATION ============================

import java.util.HashMap;

// RANK 1: Two HashMaps / Bidirectional Mapping — O(n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> patternToWord = new HashMap<>();
        HashMap<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (patternToWord.containsKey(ch) &&
                !patternToWord.get(ch).equals(word)) {
                return false;
            }

            if (wordToPattern.containsKey(word) &&
                wordToPattern.get(word) != ch) {
                return false;
            }

            patternToWord.put(ch, word);
            wordToPattern.put(word, ch);
        }

        return true;
    }
}


// RANK 2: Single HashMap + Used Words Set — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND

// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//
//         String[] words = s.split(" ");
//
//         if (pattern.length() != words.length) {
//             return false;
//         }
//
//         HashMap<Character, String> map = new HashMap<>();
//         HashSet<String> usedWords = new HashSet<>();
//
//         for (int i = 0; i < pattern.length(); i++) {
//
//             char ch = pattern.charAt(i);
//             String word = words[i];
//
//             if (map.containsKey(ch)) {
//                 if (!map.get(ch).equals(word)) {
//                     return false;
//                 }
//             } else {
//                 if (usedWords.contains(word)) {
//                     return false;
//                 }
//
//                 map.put(ch, word);
//                 usedWords.add(word);
//             }
//         }
//
//         return true;
//     }
// }

// RANK 3: Brute Force Mapping Check — O(n²) TIME, O(n) SPACE — SIMPLE / LEAST EFFICIENT

// class Solution {
//     public boolean wordPattern(String pattern, String s) {

//         String[] words = s.split(" ");

//         if (pattern.length() != words.length) {
//             return false;
//         }

//         for (int i = 0; i < pattern.length(); i++) {

//             for (int j = 0; j < i; j++) {

//                 if (pattern.charAt(i) == pattern.charAt(j) &&
//                     !words[i].equals(words[j])) {
//                     return false;
//                 }

//                 if (words[i].equals(words[j]) &&
//                     pattern.charAt(i) != pattern.charAt(j)) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }

// Driver code to test the Solution class
public class WordPattern {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.wordPattern("abba", "dog cat cat dog")
        ); // Answer: true

        // Test Case 2
        System.out.println(
            solution.wordPattern("abba", "dog cat cat fish")
        ); // Answer: false

        // Test Case 3
        System.out.println(
            solution.wordPattern("aaaa", "dog cat cat dog")
        ); // Answer: false

        // Test Case 4
        System.out.println(
            solution.wordPattern("abba", "dog dog dog dog")
        ); // Answer: false

        // Test Case 5
        System.out.println(
            solution.wordPattern("abc", "dog cat fish")
        ); // Answer: true
    }
}