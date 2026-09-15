// ============================ FINAL DESTINATION ============================

// Definition for singly-linked list.

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// RANK 1: Two Pointers — O(n + m) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }
}
 

// RANK 2: HashSet — O(n + m) TIME, O(n) SPACE — SIMPLE / HASHING APPROACH
// class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         HashSet<ListNode> set = new HashSet<>();

//         ListNode current = headA;

//         while (current != null) {
//             set.add(current);
//             current = current.next;
//         }

//         current = headB;

//         while (current != null) {

//             if (set.contains(current)) {
//                 return current;
//             }

//             current = current.next;
//         }

//         return null;
//     }
// }


// RANK 3: Length Difference — O(n + m) TIME, O(1) EXTRA SPACE — CLEAR / SYSTEMATIC
// class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         int lengthA = getLength(headA);
//         int lengthB = getLength(headB);

//         while (lengthA > lengthB) {
//             headA = headA.next;
//             lengthA--;
//         }

//         while (lengthB > lengthA) {
//             headB = headB.next;
//             lengthB--;
//         }

//         while (headA != headB) {

//             headA = headA.next;
//             headB = headB.next;
//         }

//         return headA;
//     }

//     private int getLength(ListNode head) {

//         int length = 0;

//         while (head != null) {
//             length++;
//             head = head.next;
//         }

//         return length;
//     }
// }


// RANK 4: Brute Force — O(n × m) TIME, O(1) EXTRA SPACE — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         ListNode currentA = headA;

//         while (currentA != null) {

//             ListNode currentB = headB;

//             while (currentB != null) {

//                 if (currentA == currentB) {
//                     return currentA;
//                 }

//                 currentB = currentB.next;
//             }

//             currentA = currentA.next;
//         }

//         return null;
//     }
// }


// Driver code to test the Solution class
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1: Intersection at node 8
        ListNode common1 = new ListNode(8);
        common1.next = new ListNode(4);
        common1.next.next = new ListNode(5);

        ListNode headA1 = new ListNode(4);
        headA1.next = new ListNode(1);
        headA1.next.next = common1;

        ListNode headB1 = new ListNode(5);
        headB1.next = new ListNode(6);
        headB1.next.next = new ListNode(1);
        headB1.next.next.next = common1;

        ListNode result1 = solution.getIntersectionNode(headA1, headB1);

        System.out.println(
            "Test Case 1: " + (result1 != null ? result1.val : "null")
        ); // Answer: 8


        // Test Case 2: No intersection
        ListNode headA2 = new ListNode(2);
        headA2.next = new ListNode(6);
        headA2.next.next = new ListNode(4);

        ListNode headB2 = new ListNode(1);
        headB2.next = new ListNode(5);

        ListNode result2 = solution.getIntersectionNode(headA2, headB2);

        System.out.println(
            "Test Case 2: " + (result2 != null ? result2.val : "null")
        ); // Answer: null


        // Test Case 3: Intersection at first node
        ListNode common3 = new ListNode(10);
        common3.next = new ListNode(20);

        ListNode headA3 = common3;
        ListNode headB3 = common3;

        ListNode result3 = solution.getIntersectionNode(headA3, headB3);

        System.out.println(
            "Test Case 3: " + (result3 != null ? result3.val : "null")
        ); // Answer: 10


        // Test Case 4: Intersection at last node
        ListNode common4 = new ListNode(30);

        ListNode headA4 = new ListNode(1);
        headA4.next = new ListNode(2);
        headA4.next.next = common4;

        ListNode headB4 = new ListNode(4);
        headB4.next = new ListNode(5);
        headB4.next.next = new ListNode(6);
        headB4.next.next.next = common4;

        ListNode result4 = solution.getIntersectionNode(headA4, headB4);

        System.out.println(
            "Test Case 4: " + (result4 != null ? result4.val : "null")
        ); // Answer: 30


        // Test Case 5: One list is completely inside the other
        ListNode headA5 = new ListNode(1);
        headA5.next = new ListNode(2);
        headA5.next.next = new ListNode(3);

        ListNode headB5 = headA5.next;

        ListNode result5 = solution.getIntersectionNode(headA5, headB5);

        System.out.println(
            "Test Case 5: " + (result5 != null ? result5.val : "null")
        ); // Answer: 2


        // Test Case 6: Single common node
        ListNode common6 = new ListNode(100);

        ListNode headA6 = new ListNode(1);
        headA6.next = common6;

        ListNode headB6 = new ListNode(2);
        headB6.next = new ListNode(3);
        headB6.next.next = common6;

        ListNode result6 = solution.getIntersectionNode(headA6, headB6);

        System.out.println(
            "Test Case 6: " + (result6 != null ? result6.val : "null")
        ); // Answer: 100


        // Test Case 7: Both lists are empty
        ListNode headA7 = null;
        ListNode headB7 = null;

        ListNode result7 = solution.getIntersectionNode(headA7, headB7);

        System.out.println(
            "Test Case 7: " + (result7 != null ? result7.val : "null")
        ); // Answer: null


        // Test Case 8: One list is empty
        ListNode headA8 = null;

        ListNode headB8 = new ListNode(1);
        headB8.next = new ListNode(2);

        ListNode result8 = solution.getIntersectionNode(headA8, headB8);

        System.out.println(
            "Test Case 8: " + (result8 != null ? result8.val : "null")
        ); // Answer: null
    }
}