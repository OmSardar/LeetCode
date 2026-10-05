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


// RANK 1: Recursive Mirror Comparison — O(n) TIME, O(h) STACK SPACE — BEST / OPTIMAL / MOST NATURAL

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }
}


// RANK 2: Iterative Queue — O(n) TIME, O(n) SPACE — ITERATIVE / GOOD ALTERNATIVE
/*
import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
*/


// RANK 3: Iterative Stack — O(n) TIME, O(h) to O(n) SPACE — ITERATIVE / STACK-BASED
/*
import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {

            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}
*/


// Driver code to test the Solution class
public class SymmetricTree {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1:
        //       1
        //      / \
        //     2   2
        //    / \ / \
        //   3  4 4  3
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);

        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println(
            "Test 1: " +
            solution.isSymmetric(root1) +
            "    // Answer: true"
        );


        // Test 2:
        //       1
        //      / \
        //     2   2
        //      \   \
        //       3   3
        TreeNode root2 = new TreeNode(1);

        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);

        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println(
            "Test 2: " +
            solution.isSymmetric(root2) +
            "    // Answer: false"
        );


        // Test 3:
        //       1
        //      / \
        //     2   2
        //    /     \
        //   3       3
        TreeNode root3 = new TreeNode(1);

        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);

        root3.left.left = new TreeNode(3);
        root3.right.right = new TreeNode(3);

        System.out.println(
            "Test 3: " +
            solution.isSymmetric(root3) +
            "    // Answer: true"
        );


        // Test 4: Single node
        TreeNode root4 = new TreeNode(1);

        System.out.println(
            "Test 4: " +
            solution.isSymmetric(root4) +
            "    // Answer: true"
        );


        // Test 5: Empty tree
        TreeNode root5 = null;

        System.out.println(
            "Test 5: " +
            solution.isSymmetric(root5) +
            "    // Answer: true"
        );


        // Test 6:
        //       1
        //      / \
        //     2   2
        //    /     \
        //   3       3
        //    \     /
        //     4   4
        TreeNode root6 = new TreeNode(1);

        root6.left = new TreeNode(2);
        root6.right = new TreeNode(2);

        root6.left.left = new TreeNode(3);
        root6.right.right = new TreeNode(3);

        root6.left.left.right = new TreeNode(4);
        root6.right.right.left = new TreeNode(4);

        System.out.println(
            "Test 6: " +
            solution.isSymmetric(root6) +
            "    // Answer: true"
        );


        // Test 7:
        //       1
        //      / \
        //     2   2
        //    / \ / \
        //   3  4 4  5
        TreeNode root7 = new TreeNode(1);

        root7.left = new TreeNode(2);
        root7.right = new TreeNode(2);

        root7.left.left = new TreeNode(3);
        root7.left.right = new TreeNode(4);

        root7.right.left = new TreeNode(4);
        root7.right.right = new TreeNode(5);

        System.out.println(
            "Test 7: " +
            solution.isSymmetric(root7) +
            "    // Answer: false"
        );


        // Test 8:
        //       1
        //      / \
        //     2   2
        //    /     \
        //   3       3
        //  /         \
        // 4           4
        TreeNode root8 = new TreeNode(1);

        root8.left = new TreeNode(2);
        root8.right = new TreeNode(2);

        root8.left.left = new TreeNode(3);
        root8.right.right = new TreeNode(3);

        root8.left.left.left = new TreeNode(4);
        root8.right.right.right = new TreeNode(4);

        System.out.println(
            "Test 8: " +
            solution.isSymmetric(root8) +
            "    // Answer: false"
        );
    }
}