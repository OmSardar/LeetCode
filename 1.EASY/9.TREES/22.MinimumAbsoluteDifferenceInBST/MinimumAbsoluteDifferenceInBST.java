// ============================ FINAL DESTINATION ============================

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


// RANK 1: In-Order Traversal + Previous Value — O(n) TIME, O(h) STACK SPACE — BEST / OPTIMAL / MOST SPACE-EFFICIENT

class Solution {

    private Integer previous = null;
    private int minimum = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        inorder(root);

        return minimum;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (previous != null) {
            minimum = Math.min(minimum, root.val - previous);
        }

        previous = root.val;

        inorder(root.right);
    }
}


// RANK 2: In-Order Traversal + ArrayList — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
/*
import java.util.*;

class Solution {

    public int getMinimumDifference(TreeNode root) {

        ArrayList<Integer> values = new ArrayList<>();

        inorder(root, values);

        int minimum = Integer.MAX_VALUE;

        for (int i = 1; i < values.size(); i++) {
            minimum = Math.min(
                minimum,
                values.get(i) - values.get(i - 1)
            );
        }

        return minimum;
    }

    private void inorder(
        TreeNode root,
        ArrayList<Integer> values
    ) {

        if (root == null) {
            return;
        }

        inorder(root.left, values);

        values.add(root.val);

        inorder(root.right, values);
    }
}
*/


// RANK 3: In-Order Traversal + Stack — O(n) TIME, O(h) SPACE — ITERATIVE / NO RECURSION
/*
import java.util.*;

class Solution {

    public int getMinimumDifference(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        Integer previous = null;
        int minimum = Integer.MAX_VALUE;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (previous != null) {
                minimum = Math.min(
                    minimum,
                    current.val - previous
                );
            }

            previous = current.val;

            current = current.right;
        }

        return minimum;
    }
}
*/


// RANK 4: Compare Every Pair — O(n²) TIME, O(n) SPACE — BRUTE FORCE / LEAST EFFICIENT
/*
import java.util.*;

class Solution {

    public int getMinimumDifference(TreeNode root) {

        ArrayList<Integer> values = new ArrayList<>();

        collect(root, values);

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < values.size(); i++) {

            for (int j = i + 1; j < values.size(); j++) {

                minimum = Math.min(
                    minimum,
                    Math.abs(values.get(i) - values.get(j))
                );
            }
        }

        return minimum;
    }

    private void collect(
        TreeNode root,
        ArrayList<Integer> values
    ) {

        if (root == null) {
            return;
        }

        values.add(root.val);

        collect(root.left, values);
        collect(root.right, values);
    }
}
*/


// Driver code to test the Solution class
public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1:
        //       4
        //      / \
        //     2   6
        //    / \
        //   1   3
        //
        // In-order: 1 → 2 → 3 → 4 → 6
        // Minimum difference = 1
        TreeNode root1 = new TreeNode(4);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);

        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        System.out.println(
            "Test 1: " +
            solution.getMinimumDifference(root1) +
            "    // Answer: 1"
        );


        // Test 2:
        //       1
        //        \
        //         3
        //        /
        //       2
        //
        // In-order: 1 → 2 → 3
        // Minimum difference = 1
        TreeNode root2 = new TreeNode(1);

        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);

        System.out.println(
            "Test 2: " +
            solution.getMinimumDifference(root2) +
            "    // Answer: 1"
        );


        // Test 3:
        //       10
        //      /  \
        //     5    15
        //
        // In-order: 5 → 10 → 15
        // Minimum difference = 5
        TreeNode root3 = new TreeNode(10);

        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);

        System.out.println(
            "Test 3: " +
            solution.getMinimumDifference(root3) +
            "    // Answer: 5"
        );


        // Test 4:
        //       236
        //       /
        //     104
        //       \
        //       227
        //
        // In-order: 104 → 227 → 236
        // Minimum difference = 9
        TreeNode root4 = new TreeNode(236);

        root4.left = new TreeNode(104);
        root4.left.right = new TreeNode(227);

        System.out.println(
            "Test 4: " +
            solution.getMinimumDifference(root4) +
            "    // Answer: 9"
        );


        // Test 5:
        //        8
        //       / \
        //      3   10
        //     / \    \
        //    1   6    14
        //
        // In-order: 1 → 3 → 6 → 8 → 10 → 14
        // Minimum difference = 2
        TreeNode root5 = new TreeNode(8);

        root5.left = new TreeNode(3);
        root5.right = new TreeNode(10);

        root5.left.left = new TreeNode(1);
        root5.left.right = new TreeNode(6);

        root5.right.right = new TreeNode(14);

        System.out.println(
            "Test 5: " +
            solution.getMinimumDifference(root5) +
            "    // Answer: 2"
        );


        // Test 6:
        //        5
        //       / \
        //      3   7
        //     /     \
        //    2       9
        //
        // In-order: 2 → 3 → 5 → 7 → 9
        // Minimum difference = 1
        TreeNode root6 = new TreeNode(5);

        root6.left = new TreeNode(3);
        root6.right = new TreeNode(7);

        root6.left.left = new TreeNode(2);
        root6.right.right = new TreeNode(9);

        System.out.println(
            "Test 6: " +
            solution.getMinimumDifference(root6) +
            "    // Answer: 1"
        );


        // Test 7:
        //       1
        //        \
        //         100
        //
        // Minimum difference = 99
        TreeNode root7 = new TreeNode(1);
        root7.right = new TreeNode(100);

        System.out.println(
            "Test 7: " +
            solution.getMinimumDifference(root7) +
            "    // Answer: 99"
        );


        // Test 8:
        //         10
        //        /  \
        //       5    15
        //      / \
        //     3   7
        //        /
        //       6
        //
        // In-order: 3 → 5 → 6 → 7 → 10 → 15
        // Minimum difference = 1
        TreeNode root8 = new TreeNode(10);

        root8.left = new TreeNode(5);
        root8.right = new TreeNode(15);

        root8.left.left = new TreeNode(3);
        root8.left.right = new TreeNode(7);

        root8.left.right.left = new TreeNode(6);

        System.out.println(
            "Test 8: " +
            solution.getMinimumDifference(root8) +
            "    // Answer: 1"
        );
    }
}