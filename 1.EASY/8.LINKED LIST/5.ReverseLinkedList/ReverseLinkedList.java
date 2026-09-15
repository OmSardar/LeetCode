// ============================ JULY-AUGUST PRACTICE ============================

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

// RANK 1: Iterative Pointer Reversal — O(n), O(1) — BEST PRACTICAL / MOST EFFICIENT / MOST USED
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

// RANK 2: Recursive Method — O(n), O(n) — CLEAN / ELEGANT / CLASSIC INTERVIEW METHOD
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null)
//             return head;

//         ListNode newHead = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;

//         return newHead;
//     }
// }

// RANK 3: Tail-Recursive Method — O(n), O(n) — CLEAN RECURSIVE APPROACH / O(1) AUXILIARY LOGIC 
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         return helper(head, null);
//     }

//     private ListNode helper(ListNode curr, ListNode prev) {
//         if (curr == null) return prev;
//         ListNode nextNode = curr.next;
//         curr.next = prev;
//         return helper(nextNode, curr);
//     }
// }

// RANK 4: Using a Stack — O(n), O(n) — SIMPLE, BUT EXTRA SPACE / LESS PREFERRED
// import java.util.Stack;

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null) return null;

//         Stack<ListNode> stack = new Stack<>();
//         while (head != null) {
//             stack.push(head);
//             head = head.next;
//         }

//         ListNode newHead = stack.pop();
//         ListNode curr = newHead;

//         while (!stack.isEmpty()) {
//             curr.next = stack.pop();
//             curr = curr.next;
//         }

//         curr.next = null;
//         return newHead;
//     }
// }

// Driver code to test the Solution class
public class ReverseLinkedList {

    public static void main(String[] args) {

        // Test Case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        Solution obj = new Solution();

        ListNode result1 = obj.reverseList(head1);

        System.out.print("Input:  1 -> 2 -> 3 -> 4 -> 5");
        System.out.print("\nOutput: ");

        printList(result1);

        // Expected: 5 -> 4 -> 3 -> 2 -> 1


        // Test Case 2: 10 -> 20 -> 30
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);

        ListNode result2 = obj.reverseList(head2);

        System.out.print("\nInput:  10 -> 20 -> 30");
        System.out.print("\nOutput: ");

        printList(result2);

        // Expected: 30 -> 20 -> 10


        // Test Case 3: 1 -> 2
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        ListNode result3 = obj.reverseList(head3);

        System.out.print("\nInput:  1 -> 2");
        System.out.print("\nOutput: ");

        printList(result3);

        // Expected: 2 -> 1


        // Test Case 4: Single node
        ListNode head4 = new ListNode(100);

        ListNode result4 = obj.reverseList(head4);

        System.out.print("\nInput:  100");
        System.out.print("\nOutput: ");

        printList(result4);

        // Expected: 100


        // Test Case 5: Empty list
        ListNode head5 = null;

        ListNode result5 = obj.reverseList(head5);

        System.out.print("\nInput:  Empty List");
        System.out.print("\nOutput: ");

        printList(result5);

        // Expected: Empty List
    }

    // Method to print the linked list
    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }
}