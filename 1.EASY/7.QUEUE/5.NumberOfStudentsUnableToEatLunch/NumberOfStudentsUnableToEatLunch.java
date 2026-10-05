// ============================ FINAL DESTINATION ============================

// RANK 1: Frequency Counting — O(n + m) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        // Count how many students want each type
        int[] count = new int[2];

        for (int student : students) {
            count[student]++;
        }

        // Process sandwiches from top to bottom
        for (int sandwich : sandwiches) {

            // Nobody wants this type of sandwich
            if (count[sandwich] == 0) {
                break;
            }

            // One student gets this sandwich
            count[sandwich]--;
        }

        // Remaining students are unable to eat
        return count[0] + count[1];
    }
}


// RANK 2: Queue + Stack Simulation — O(n²) TIME, O(n) SPACE — Direct Simulation

// import java.util.*;
//
// class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
//
//         Stack<Integer> stack = new Stack<>();
//         Queue<Integer> queue = new LinkedList<>();
//
//         // Push sandwiches backwards
//         // so sandwiches[0] becomes the top.
//         for (int i = sandwiches.length - 1; i >= 0; i--) {
//             stack.push(sandwiches[i]);
//         }
//
//         // Add students to the queue
//         for (int student : students) {
//             queue.offer(student);
//         }
//
//         int studentLeftCount = queue.size();
//         int unableCount = 0;
//
//         while (!queue.isEmpty()) {
//
//             // Student wants the current sandwich
//             if (queue.peek() == stack.peek()) {
//
//                 queue.poll();
//                 stack.pop();
//
//                 studentLeftCount--;
//
//                 // Someone successfully ate
//                 unableCount = 0;
//
//             } else {
//
//                 // Student doesn't want this sandwich
//                 // Move the student to the back of the queue.
//                 int currentStudent = queue.poll();
//                 queue.offer(currentStudent);
//
//                 unableCount++;
//             }
//
//             // We checked every remaining student
//             // and nobody wanted the current sandwich.
//             if (!queue.isEmpty() && unableCount == queue.size()) {
//                 break;
//             }
//         }
//
//         return studentLeftCount;
//     }
// }


// RANK 3: Queue Simulation — O(n²) TIME, O(n) SPACE — Simple Direct Simulation

// import java.util.*;
//
// class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
//
//         Queue<Integer> queue = new LinkedList<>();
//
//         for (int student : students) {
//             queue.offer(student);
//         }
//
//         int sandwichIndex = 0;
//         int unableCount = 0;
//
//         while (!queue.isEmpty() && unableCount < queue.size()) {
//
//             // Student wants the current sandwich
//             if (queue.peek() == sandwiches[sandwichIndex]) {
//
//                 queue.poll();
//                 sandwichIndex++;
//
//                 // Someone ate, so reset the counter
//                 unableCount = 0;
//
//             } else {
//
//                 // Student goes to the back
//                 queue.offer(queue.poll());
//
//                 unableCount++;
//             }
//         }
//
//         return queue.size();
//     }
// }


// Driver code to test the Solution class
public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};

        System.out.println(
            solution.countStudents(students1, sandwiches1)
        );
        // Answer: 0


        // Test Case 2
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};

        System.out.println(
            solution.countStudents(students2, sandwiches2)
        );
        // Answer: 3


        // Test Case 3
        int[] students3 = {1, 1, 1, 1};
        int[] sandwiches3 = {0, 0, 0, 1};

        System.out.println(
            solution.countStudents(students3, sandwiches3)
        );
        // Answer: 4


        // Test Case 4
        int[] students4 = {0, 0, 1, 1};
        int[] sandwiches4 = {0, 1, 0, 1};

        System.out.println(
            solution.countStudents(students4, sandwiches4)
        );
        // Answer: 0


        // Test Case 5
        int[] students5 = {0, 0, 0};
        int[] sandwiches5 = {1, 1, 1};

        System.out.println(
            solution.countStudents(students5, sandwiches5)
        );
        // Answer: 3
    }
}