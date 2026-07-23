// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Vertical Scanning (Character by Character) (O(S), O(1))
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i >= s.length() || strs[0].charAt(i) != s.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}

// RANK 2: Horizontal Scanning (O(S), O(1))
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null || strs.length == 0) {
//             return "";            
//         }
//         String prefix = strs[0];
//         for(int i=1; i<strs.length; i++){
//             while (!strs[i].startsWith(prefix)) {
//                 prefix = prefix.substring(0, prefix.length() - 1);
//                 if (prefix.isEmpty()) {
//                     return "";
//                 }
//             }
//         }
//         return prefix;
//     }
// }

// RANK 3: Divide and Conquer (O(S), O(log n))
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//         return "";
//        }
//        return lcp(strs, 0, strs.length - 1);
//     }
//     private String lcp(String[] strs, int left, int right){
//         if (left == right) {
//             return strs[left];
//         }
//         int mid = (left + right) / 2;
//         String leftValue = lcp(strs, left, mid);
//         String rightValue = lcp(strs, mid+1, right);
        
//         return commonPrefix(leftValue, rightValue);
//     }
//     private String commonPrefix(String str1, String str2 ){
//         int min = Math.min(str1.length(), str2.length());
//         for(int i=0; i<min; i++){
//             if (str1.charAt(i) != str2.charAt(i)) {
//                 return str1.substring(0,i);
//             }
//         }
//         return str1.substring(0, min);
//     }
// }

// RANK 4: Sorting Based Approach (O(n log n), O(1))
// import java.util.Arrays;

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0) return "";

//         Arrays.sort(strs);

//         String first = strs[0];
//         String last = strs[strs.length - 1];

//         int i = 0;

//         while (i < first.length() && i < last.length()) {

//             if (first.charAt(i) != last.charAt(i)) {
//                 break;
//             }

//             i++;
//         }

//         return first.substring(0, i);
//     }
// }

// RANK 5: Trie (Advanced Approach) (O(S), O(S)) (I will watch later)
// class TrieNode {
//     TrieNode[] children = new TrieNode[26];
//     boolean isEnd;
// }

// class Solution {
//     TrieNode root = new TrieNode();

//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0) return "";
//         for (String s : strs) insert(s);

//         StringBuilder prefix = new StringBuilder();
//         TrieNode node = root;

//         while (true) {
//             int count = 0;
//             int index = -1;
//             for (int i = 0; i < 26; i++) {
//                 if (node.children[i] != null) {
//                     count++;
//                     index = i;
//                 }
//             }
//             if (count == 1 && !node.isEnd) {
//                 prefix.append((char) (index + 'a'));
//                 node = node.children[index];
//             } else break;
//         }
//         return prefix.toString();
//     }

//     private void insert(String word) {
//         TrieNode curr = root;
//         for (char c : word.toCharArray()) {
//             int idx = c - 'a';
//             if (curr.children[idx] == null)
//                 curr.children[idx] = new TrieNode();
//             curr = curr.children[idx];
//         }
//         curr.isEnd = true;
//     }
// }

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"}; //Output: "fl"
        String result = solution.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);
    }
}
