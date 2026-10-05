// ============================ FINAL DESTINATION ============================

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// RANK 1: Reverse Second Half + Two Pointers — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT

class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode secondHalf = reverse(slow);

        // Compare first half and reversed second half
        ListNode firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}


// RANK 2: ArrayList + Two Pointers — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
/*
import java.util.*;

class Solution {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> values = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {

            if (!values.get(left).equals(values.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
*/


// RANK 3: Stack + Two Pointers — O(n) TIME, O(n) SPACE — CLEAR / STACK-BASED ALTERNATIVE
/*
import java.util.*;

class Solution {
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;

        while (current != null) {

            if (current.val != stack.pop()) {
                return false;
            }

            current = current.next;
        }

        return true;
    }
}
*/


// RANK 4: Recursive Comparison — O(n) TIME, O(n) STACK SPACE — RECURSIVE / ELEGANT
/*
class Solution {

    private ListNode left;

    public boolean isPalindrome(ListNode head) {

        left = head;

        return check(head);
    }

    private boolean check(ListNode right) {

        if (right == null) {
            return true;
        }

        if (!check(right.next)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        left = left.next;

        return true;
    }
}
*/


// Driver code to test the Solution class
public class PalindromeLinkedList {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test 1: 1 → 2 → 2 → 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        System.out.println(
            "Test 1: " +
            solution.isPalindrome(head1) +
            "    // Answer: true"
        );


        // Test 2: 1 → 2 → 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println(
            "Test 2: " +
            solution.isPalindrome(head2) +
            "    // Answer: false"
        );


        // Test 3: 1 → 2 → 1
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(1);

        System.out.println(
            "Test 3: " +
            solution.isPalindrome(head3) +
            "    // Answer: true"
        );


        // Test 4: 1 → 1
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(1);

        System.out.println(
            "Test 4: " +
            solution.isPalindrome(head4) +
            "    // Answer: true"
        );


        // Test 5: 1 → 2
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);

        System.out.println(
            "Test 5: " +
            solution.isPalindrome(head5) +
            "    // Answer: false"
        );


        // Test 6: 1 → 2 → 3 → 2 → 1
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        head6.next.next = new ListNode(3);
        head6.next.next.next = new ListNode(2);
        head6.next.next.next.next = new ListNode(1);

        System.out.println(
            "Test 6: " +
            solution.isPalindrome(head6) +
            "    // Answer: true"
        );


        // Test 7: 1 → 2 → 3 → 4
        ListNode head7 = new ListNode(1);
        head7.next = new ListNode(2);
        head7.next.next = new ListNode(3);
        head7.next.next.next = new ListNode(4);

        System.out.println(
            "Test 7: " +
            solution.isPalindrome(head7) +
            "    // Answer: false"
        );


        // Test 8: Single node
        ListNode head8 = new ListNode(7);

        System.out.println(
            "Test 8: " +
            solution.isPalindrome(head8) +
            "    // Answer: true"
        );
    }
}