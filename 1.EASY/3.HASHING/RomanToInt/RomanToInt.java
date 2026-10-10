// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Optimized Array Indexing (O(n),O(1))
class Solution {
    public int romanToInt(String s) {
        int val[] = new int[26];
        val['I' - 'A'] = 1;
        val['V' - 'A'] = 5;
        val['X' - 'A'] = 10;
        val['L' - 'A'] = 50;
        val['C' - 'A'] = 100;
        val['D' - 'A'] = 500;
        val['M' - 'A'] = 1000;

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(i+1 < s.length() && val[s.charAt(i) - 'A'] < val[s.charAt(i+1) - 'A']){
                result -= val[s.charAt(i) - 'A'];
            } else {
                result += val[s.charAt(i) - 'A'];
            }
        }
        return result;
    }
}

// RANK 2: Compare current with next(O(n),O(1))
// class Solution {

//     public int value(char ch) {
//         switch (ch) {
//             case 'I':
//             case 'i':
//                 return 1;

//             case 'V':
//             case 'v':
//                 return 5;

//             case 'X':
//             case 'x':
//                 return 10;

//             case 'L':
//             case 'l':
//                 return 50;

//             case 'C':
//             case 'c':
//                 return 100;

//             case 'D':
//             case 'd':
//                 return 500;

//             case 'M':
//             case 'm':
//                 return 1000;

//             default:
//                 return -1;
//         }
//     }

//     public int romanToInt(String s) {
//         int result = 0;

//         for (int i = 0; i < s.length(); i++) {

//             int current = value(s.charAt(i));

//             if (i + 1 < s.length()) {
//                 int next = value(s.charAt(i + 1));

//                 if (current < next) {
//                     result -= current;
//                 } else {
//                     result += current;
//                 }
//             } else {
//                 // Last character
//                 result += current;
//             }
//         }

//         return result;
//     }
// }

// RANK 3: Traverse from right to left (O(n),O(1))
// import java.util.HashMap;
// class Solution {

//     HashMap<Character, Integer> map = new HashMap<>();
//     public Solution() {
//         map.put('I', 1);
//         map.put('V', 5);
//         map.put('X', 10);
//         map.put('L', 50);
//         map.put('C', 100);
//         map.put('D', 500);
//         map.put('M', 1000);
//     }

//     public int romanToInt(String s) {
//         int result = 0;
//         int prev = 0;
        
//         for (int i = s.length() - 1; i >= 0 ; i--) {

//             int current = map.get((s.charAt(i)));
            
//                 if (current < prev) {
//                     result -= current;
//                 } else {
//                     result += current;
//                 }
//                 prev = current;
//         }

//         return result;
//     }

// }

// RANK 4: Traverse from left to right (O(n),O(1))
// import java.util.HashMap;

// class Solution {

//     HashMap<Character, Integer> map = new HashMap<>();

//     public Solution() {
//         map.put('I', 1);
//         map.put('V', 5);
//         map.put('X', 10);
//         map.put('L', 50);
//         map.put('C', 100);
//         map.put('D', 500);
//         map.put('M', 1000);
//     }

//     public int romanToInt(String s) {
//         int result = 0;

//         for (int i = 0; i < s.length(); i++) {
//             int current = map.get(s.charAt(i));

//             if (i + 1 < s.length()) {
//                 int next = map.get(s.charAt(i + 1));

//                 if (current < next) {
//                     result -= current;
//                 } else {
//                     result += current;
//                 }
//             } else {
//                 result += current;
//             }
//         }

//         return result;
//     }
// }

// RANK 5: String Replace Trick (O(n),O(n))
// class Solution {
//     public int romanToInt(String s) {
//         s = s.replace("IV", "IIII")
//              .replace("IX", "VIIII")
//              .replace("XL", "XXXX")
//              .replace("XC", "LXXXX")
//              .replace("CD", "CCCC")
//              .replace("CM", "DCCCC");

//         int result = 0;

//         for (char c : s.toCharArray()) {
//             switch (c) {
//                 case 'I': result += 1; break;
//                 case 'V': result += 5; break;
//                 case 'X': result += 10; break;
//                 case 'L': result += 50; break;
//                 case 'C': result += 100; break;
//                 case 'D': result += 500; break;
//                 case 'M': result += 1000; break;
//             }
//         }
//         return result;
//     }
// }

// RANK 6: Recursive Approach (O(n),O(n))

// class Solution {
//     public int romanToInt(String s) {
//         return helper(s, 0);
//     }

//     private int helper(String s, int i) {
//         // Base case
//         if (i == s.length()) {
//             return 0;
//         }

//         int curr = value(s.charAt(i));

//         if (i + 1 < s.length() && curr < value(s.charAt(i + 1))) {
//             return -curr + helper(s, i + 1);
//         }

//         return curr + helper(s, i + 1);
//     }

//     private int value(char c) {
//         switch (c) {
//             case 'I': return 1;
//             case 'V': return 5;
//             case 'X': return 10;
//             case 'L': return 50;
//             case 'C': return 100;
//             case 'D': return 500;
//             case 'M': return 1000;
//             default: return 0;
//         }
//     }
// }

//Driver code to test the Solution class
 public class RomanToInt {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.romanToInt("III"));      // 3
        System.out.println(sol.romanToInt("IV"));       // 4
        System.out.println(sol.romanToInt("IX"));       // 9
        System.out.println(sol.romanToInt("LVIII"));    // 58
        System.out.println(sol.romanToInt("MCMXCIV"));  // 1994
    }
}