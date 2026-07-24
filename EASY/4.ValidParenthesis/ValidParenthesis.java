// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Using stack (O(n),O(n))
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
            (ch == '}' && top != '{') ||
        (ch == ']' && top != '[')){
            return false;
        }
            }
        }
        return stack.isEmpty();
    }
}

// RANK 2: Using Stack and HashMap (O(n),O(n))
// import java.util.Stack;
// import java.util.HashMap;
// class Solution {
//     public boolean isValid(String s) {
//         HashMap<Character, Character> map = new HashMap<>();
//         map.put(')', '(');
//         map.put('}', '{');
//         map.put(']', '[');
//         Stack<Character> stack = new Stack<>();
//         for(char ch:s.toCharArray()){
//             if(!map.containsKey(ch)){
//                 stack.push(ch);
//             }
//             else{
//                 if (stack.isEmpty()) return false;
//                 if (stack.pop() != map.get(ch)) {
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }
// }

// RANK 3: Using Repeated replace() (O(n^2),O(n))
// class Solution {
//     public boolean isValid(String s) {
//         String prev;

//         do {
//             prev = s;
//             s = s.replace("()", "")
//                  .replace("{}", "")
//                  .replace("[]", "");
//         } while (!s.equals(prev));

//         return s.isEmpty();
//     }
// }



//Driver code to test the Solution class
public class ValidParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));        // true
        System.out.println(solution.isValid("()[]{}"));    // true
        System.out.println(solution.isValid("(]"));        // false
        System.out.println(solution.isValid("([)]"));      // false
        System.out.println(solution.isValid("{[]}"));      // true
    }
}
