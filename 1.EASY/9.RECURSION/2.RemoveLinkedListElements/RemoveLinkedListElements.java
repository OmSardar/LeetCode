// ============================ FINAL DESTINATION ============================


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// RANK 1: Dummy Node + Iterative Traversal — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}

// RANK 2: Direct Head Removal + Traversal — O(n) TIME, O(1) SPACE — Simple / Direct

// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//
//         // Remove matching nodes from the beginning.
//         while (head != null && head.val == val) {
//             head = head.next;
//         }
//
//         ListNode current = head;
//
//         while (current != null && current.next != null) {
//
//             if (current.next.val == val) {
//                 current.next = current.next.next;
//             } else {
//                 current = current.next;
//             }
//         }
//
//         return head;
//     }
// }


// RANK 3: Recursive — O(n) TIME, O(n) SPACE — Recursive / Elegant
// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//         return solve(head, val);
//     }
    
//     private ListNode solve(ListNode head, int val) {

//         if (head == null) {
//             return null;
//         }
//         head.next = solve(head.next, val);
//         if (head.val == val) {
//             return head.next;
//         }

//         return head;
//     }
// }


// Driver code to test the Solution class
public class RemoveLinkedListElements {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        ListNode head1 = createList(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        int val1 = 6;

        ListNode answer1 = solution.removeElements(head1, val1);

        printList(answer1);
        // Answer: 1 -> 2 -> 3 -> 4 -> 5

        // Test Case 2
        ListNode head2 = createList(new int[] { 7, 7, 7, 7 });
        int val2 = 7;

        ListNode answer2 = solution.removeElements(head2, val2);

        printList(answer2);
        // Answer: Empty List

        // Test Case 3
        ListNode head3 = createList(new int[] { 1, 2, 3, 4, 5 });
        int val3 = 3;

        ListNode answer3 = solution.removeElements(head3, val3);

        printList(answer3);
        // Answer: 1 -> 2 -> 4 -> 5

        // Test Case 4
        ListNode head4 = createList(new int[] { 1, 1, 2, 1, 3, 1 });
        int val4 = 1;

        ListNode answer4 = solution.removeElements(head4, val4);

        printList(answer4);
        // Answer: 2 -> 3

        // Test Case 5
        ListNode head5 = createList(new int[] { 1, 2, 3 });
        int val5 = 4;

        ListNode answer5 = solution.removeElements(head5, val5);

        printList(answer5);
        // Answer: 1 -> 2 -> 3

        // Test Case 6
        ListNode head6 = createList(new int[] { 5 });
        int val6 = 5;

        ListNode answer6 = solution.removeElements(head6, val6);

        printList(answer6);
        // Answer: Empty List
    }

    // Create the linked list.
    public static ListNode createList(int[] values) {

        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {

            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Print the linked list.
    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
}