// ============================ FINAL DESTINATION ============================

import java.util.*;

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


// RANK 1: BFS (Level Order) — O(n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL
// Stops immediately when the first leaf node is found.


class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // First leaf found = minimum depth
                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            depth++;
        }

        return depth;
    }
}


// RANK 2: Recursive DFS — O(n) TIME, O(h) STACK SPACE — SIMPLE / RECURSIVE
/*
class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(
            minDepth(root.left),
            minDepth(root.right)
        );
    }
}
*/


// RANK 3: DFS with Explicit Stack — O(n) TIME, O(n) SPACE — ITERATIVE / GOOD ALTERNATIVE
/*
import java.util.*;

class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        nodes.push(root);
        depths.push(1);

        int min = Integer.MAX_VALUE;

        while (!nodes.isEmpty()) {

            TreeNode current = nodes.pop();
            int depth = depths.pop();

            if (current.left == null && current.right == null) {
                min = Math.min(min, depth);
                continue;
            }

            if (current.left != null) {
                nodes.push(current.left);
                depths.push(depth + 1);
            }

            if (current.right != null) {
                nodes.push(current.right);
                depths.push(depth + 1);
            }
        }

        return min;
    }
}
*/


// Driver code to test the Solution class
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println(
            "Test 1: " +
            solution.minDepth(root1) +
            "    // Answer: 2"
        );


        // Test 2:
        //       2
        //        \
        //         3
        //          \
        //           4
        //            \
        //             5
        //              \
        //               6
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);

        System.out.println(
            "Test 2: " +
            solution.minDepth(root2) +
            "    // Answer: 5"
        );


        // Test 3: Single node
        TreeNode root3 = new TreeNode(1);

        System.out.println(
            "Test 3: " +
            solution.minDepth(root3) +
            "    // Answer: 1"
        );


        // Test 4: Empty tree
        TreeNode root4 = null;

        System.out.println(
            "Test 4: " +
            solution.minDepth(root4) +
            "    // Answer: 0"
        );


        // Test 5:
        //       1
        //      / \
        //     2   3
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);

        System.out.println(
            "Test 5: " +
            solution.minDepth(root5) +
            "    // Answer: 2"
        );


        // Test 6:
        //       1
        //      /
        //     2
        //    /
        //   3
        //  /
        // 4
        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(2);
        root6.left.left = new TreeNode(3);
        root6.left.left.left = new TreeNode(4);

        System.out.println(
            "Test 6: " +
            solution.minDepth(root6) +
            "    // Answer: 4"
        );


        // Test 7:
        //       1
        //      / \
        //     2   3
        //        /
        //       4
        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(2);
        root7.right = new TreeNode(3);
        root7.right.left = new TreeNode(4);

        System.out.println(
            "Test 7: " +
            solution.minDepth(root7) +
            "    // Answer: 2"
        );


        // Test 8:
        //          1
        //         /
        //        2
        //       / \
        //      3   4
        //         /
        //        5
        TreeNode root8 = new TreeNode(1);
        root8.left = new TreeNode(2);
        root8.left.left = new TreeNode(3);
        root8.left.right = new TreeNode(4);
        root8.left.right.left = new TreeNode(5);

        System.out.println(
            "Test 8: " +
            solution.minDepth(root8) +
            "    // Answer: 3"
        );
    }
}