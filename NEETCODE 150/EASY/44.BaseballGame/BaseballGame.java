// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Stack — O(n), O(n) — BEST PRACTICAL / MOST DIRECT / MOST NATURAL

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } 
            else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } 
            else if (op.equals("C")) {
                stack.pop();
            } 
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}

// RANK 2: ArrayList Simulation — O(n), O(n) — SIMPLE / EASY TO UNDERSTAND / GOOD ALTERNATIVE
// class Solution {
//     public int calPoints(String[] operations) {

//         List<Integer> list = new ArrayList<>();

//         for (String op : operations) {
//             if (op.equals("+")) {
//                 int size = list.size();
//                 list.add(list.get(size - 1) + list.get(size - 2));
//             } 
//             else if (op.equals("D")) {
//                 list.add(2 * list.get(list.size() - 1));
//             } 
//             else if (op.equals("C")) {
//                 list.remove(list.size() - 1);
//             } 
//             else {
//                 list.add(Integer.parseInt(op));
//             }
//         }

//         int sum = 0;
//         for (int val : list) sum += val;
//         return sum;
//     }
// }


// RANK 3: Array as Stack (Manual Stack) — O(n), O(n) — MOST EFFICIENT MEMORY USAGE / LOW-LEVEL IMPLEMENTATION
// class Solution {
//     public int calPoints(String[] operations) {

//         int[] stack = new int[operations.length];
//         int index = 0;

//         for (String op : operations) {
//             if (op.equals("+")) {
//                 stack[index] = stack[index - 1] + stack[index - 2];
//                 index++;
//             } 
//             else if (op.equals("D")) {
//                 stack[index] = 2 * stack[index - 1];
//                 index++;
//             } 
//             else if (op.equals("C")) {
//                 index--;
//             } 
//             else {
//                 stack[index++] = Integer.parseInt(op);
//             }
//         }

//         int sum = 0;
//         for (int i = 0; i < index; i++) {
//             sum += stack[i];
//         }

//         return sum;
//     }
// }

// RANK 4: Deque (Alternative to Stack) — O(n), O(n) — MODERN ALTERNATIVE / FLEXIBLE STACK IMPLEMENTATION

// import java.util.ArrayDeque;
// import java.util.Deque;

// class Solution {
//     public int calPoints(String[] operations) {

//         Deque<Integer> deque = new ArrayDeque<>();

//         for (String op : operations) {
//             if (op.equals("+")) {
//                 int a = deque.removeLast();
//                 int b = deque.peekLast();
//                 deque.addLast(a);
//                 deque.addLast(a + b);
//             } 
//             else if (op.equals("D")) {
//                 deque.addLast(2 * deque.peekLast());
//             } 
//             else if (op.equals("C")) {
//                 deque.removeLast();
//             } 
//             else {
//                 deque.addLast(Integer.parseInt(op));
//             }
//         }

//         int sum = 0;
//         for (int val : deque) sum += val;
//         return sum;
//     }
// }

// Driver code to test the Solution class
public class BaseballGame {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        String[] operations1 = {"5", "2", "C", "D", "+"};
        System.out.println(solution.calPoints(operations1)); // Answer: 30

        // Test Case 2
        String[] operations2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution.calPoints(operations2)); // Answer: 27

        // Test Case 3
        String[] operations3 = {"1", "2", "3", "4", "+"};
        System.out.println(solution.calPoints(operations3)); // Answer: 14

        // Test Case 4
        String[] operations4 = {"10", "20", "C"};
        System.out.println(solution.calPoints(operations4)); // Answer: 10

        // Test Case 5
        String[] operations5 = {"5", "D", "D", "C", "+"};
        System.out.println(solution.calPoints(operations5)); // Answer: 40
    }
}