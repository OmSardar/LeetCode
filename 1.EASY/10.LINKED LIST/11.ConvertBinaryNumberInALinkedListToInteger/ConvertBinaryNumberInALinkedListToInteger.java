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

// RANK 1: Iterative Binary Construction — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public int getDecimalValue(ListNode head) {

        int result = 0;

        while (head != null) {

            // Shift the current binary number
            // one position to the left.
            result = result * 2;

            // Add the current binary digit.
            result = result + head.val;

            head = head.next;
        }

        return result;
    }
}


// RANK 2: Power-of-2 Approach — O(n) TIME, O(1) SPACE — Good / Mathematical

// class Solution {
//     public int getDecimalValue(ListNode head) {
//
//         ListNode current = head;
//
//         int power = 0;
//         int sum = 0;
//
//         while (current != null) {
//
//             sum += current.val * Math.pow(2, power);
//
//             current = current.next;
//             power++;
//         }
//
//         return sum;
//     }
// }


// RANK 3: Bit Manipulation — O(n) TIME, O(1) SPACE — Bitwise Alternative

// class Solution {
//     public int getDecimalValue(ListNode head) {
//
//         int result = 0;
//
//         while (head != null) {
//
//             // Shift the current result left by 1 bit.
//             result = result << 1;
//
//             // Add the current binary digit.
//             result = result | head.val;
//
//             head = head.next;
//         }
//
//         return result;
//     }
// }


// RANK 4: Recursive — O(n) TIME, O(n) SPACE — Recursive / Alternative

// class Solution {
//     public int getDecimalValue(ListNode head) {
//
//         return convert(head, 0);
//     }
//
//     private int convert(ListNode head, int result) {
//
//         if (head == null) {
//             return result;
//         }
//
//         result = result * 2 + head.val;
//
//         return convert(head.next, result);
//     }
// }




// Driver code to test the Solution class
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        ListNode head1 = createList(new int[]{1, 0, 1});

        System.out.println(solution.getDecimalValue(head1));
        // Answer: 5


        // Test Case 2
        ListNode head2 = createList(new int[]{0});

        System.out.println(solution.getDecimalValue(head2));
        // Answer: 0


        // Test Case 3
        ListNode head3 = createList(new int[]{1});

        System.out.println(solution.getDecimalValue(head3));
        // Answer: 1


        // Test Case 4
        ListNode head4 = createList(new int[]{1, 0, 0, 1});

        System.out.println(solution.getDecimalValue(head4));
        // Answer: 9


        // Test Case 5
        ListNode head5 = createList(new int[]{1, 1, 1, 1});

        System.out.println(solution.getDecimalValue(head5));
        // Answer: 15


        // Test Case 6
        ListNode head6 = createList(new int[]{1, 0, 1, 0, 1});

        System.out.println(solution.getDecimalValue(head6));
        // Answer: 21
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
}