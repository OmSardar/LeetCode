// 1. Compare current with next(O(n),O(1))
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

// 2. Traverse from right to left (O(n),O(1))
import java.util.HashMap;
class Solution {

    HashMap<Character, Integer> map = new HashMap<>();
    public Solution() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        int prev = 0;
        
        for (int i = s.length() - 1; i >= 0 ; i--) {

            int current = map.get((s.charAt(i)));
            
                if (current < prev) {
                    result -= current;
                } else {
                    result += current;
                }
                prev = current;
        }

        return result;
    }

}

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