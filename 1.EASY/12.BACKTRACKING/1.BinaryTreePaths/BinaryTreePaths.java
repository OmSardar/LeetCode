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


// RANK 1: DFS + Backtracking — O(n²) TIME WORST CASE, O(h) STACK SPACE — BEST / MOST NATURAL
//
// O(n²) occurs because creating/copying path strings can take O(n)
// for each of O(n) paths in a highly skewed tree.
// The actual traversal itself is O(n).

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    private void findPaths(
        TreeNode root,
        String path,
        List<String> result
    ) {

        // Add current node to the path
        if (path.isEmpty()) {
            path = String.valueOf(root.val);
        } else {
            path += "->" + root.val;
        }

        // If this is a leaf, we have found a complete path
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Continue to left subtree
        if (root.left != null) {
            findPaths(root.left, path, result);
        }

        // Continue to right subtree
        if (root.right != null) {
            findPaths(root.right, path, result);
        }
    }
}


// RANK 2: DFS + StringBuilder Backtracking — O(n²) TIME WORST CASE, O(h) STACK SPACE
// MORE MEMORY-EFFICIENT PATH CONSTRUCTION / GOOD ALTERNATIVE
/*
import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        StringBuilder path = new StringBuilder();

        dfs(root, path, result);

        return result;
    }

    private void dfs(
        TreeNode root,
        StringBuilder path,
        List<String> result
    ) {

        int length = path.length();

        if (path.length() > 0) {
            path.append("->");
        }

        path.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {

            if (root.left != null) {
                dfs(root.left, path, result);
            }

            if (root.right != null) {
                dfs(root.right, path, result);
            }
        }

        // Backtrack
        path.setLength(length);
    }
}
*/


// RANK 3: Iterative DFS with Stack — O(n²) TIME WORST CASE, O(n) SPACE
// ITERATIVE / NO RECURSION
/*
import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<String> paths = new Stack<>();

        nodes.push(root);
        paths.push(String.valueOf(root.val));

        while (!nodes.isEmpty()) {

            TreeNode current = nodes.pop();
            String path = paths.pop();

            if (current.left == null && current.right == null) {
                result.add(path);
                continue;
            }

            if (current.right != null) {
                nodes.push(current.right);
                paths.push(path + "->" + current.right.val);
            }

            if (current.left != null) {
                nodes.push(current.left);
                paths.push(path + "->" + current.left.val);
            }
        }

        return result;
    }
}
*/


// RANK 4: BFS + Queue — O(n²) TIME WORST CASE, O(n) SPACE — LEVEL-ORDER ALTERNATIVE
/*
import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();

        nodes.offer(root);
        paths.offer(String.valueOf(root.val));

        while (!nodes.isEmpty()) {

            TreeNode current = nodes.poll();
            String path = paths.poll();

            if (current.left == null && current.right == null) {
                result.add(path);
                continue;
            }

            if (current.left != null) {
                nodes.offer(current.left);
                paths.offer(
                    path + "->" + current.left.val
                );
            }

            if (current.right != null) {
                nodes.offer(current.right);
                paths.offer(
                    path + "->" + current.right.val
                );
            }
        }

        return result;
    }
}
*/


// Driver code to test the Solution class
public class BinaryTreePaths {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1:
        //
        //       1
        //      / \
        //     2   3
        //      \
        //       5
        //
        // Answer: [1->2->5, 1->3]
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.left.right = new TreeNode(5);

        System.out.println(
            "Test 1: " +
            solution.binaryTreePaths(root1) +
            "    // Answer: [1->2->5, 1->3]"
        );


        // Test 2:
        //
        //       1
        //
        // Answer: [1]
        TreeNode root2 = new TreeNode(1);

        System.out.println(
            "Test 2: " +
            solution.binaryTreePaths(root2) +
            "    // Answer: [1]"
        );


        // Test 3:
        //
        //       1
        //      / \
        //     2   3
        //
        // Answer: [1->2, 1->3]
        TreeNode root3 = new TreeNode(1);

        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        System.out.println(
            "Test 3: " +
            solution.binaryTreePaths(root3) +
            "    // Answer: [1->2, 1->3]"
        );


        // Test 4:
        //
        //       1
        //        \
        //         2
        //          \
        //           3
        //            \
        //             4
        //
        // Answer: [1->2->3->4]
        TreeNode root4 = new TreeNode(1);

        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        root4.right.right.right = new TreeNode(4);

        System.out.println(
            "Test 4: " +
            solution.binaryTreePaths(root4) +
            "    // Answer: [1->2->3->4]"
        );


        // Test 5:
        //
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        //
        // Answer: [1->2->4, 1->2->5, 1->3]
        TreeNode root5 = new TreeNode(1);

        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);

        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);

        System.out.println(
            "Test 5: " +
            solution.binaryTreePaths(root5) +
            "    // Answer: [1->2->4, 1->2->5, 1->3]"
        );


        // Test 6:
        //
        //          1
        //         / \
        //        2   3
        //       /   / \
        //      4   5   6
        //
        // Answer: [1->2->4, 1->3->5, 1->3->6]
        TreeNode root6 = new TreeNode(1);

        root6.left = new TreeNode(2);
        root6.right = new TreeNode(3);

        root6.left.left = new TreeNode(4);

        root6.right.left = new TreeNode(5);
        root6.right.right = new TreeNode(6);

        System.out.println(
            "Test 6: " +
            solution.binaryTreePaths(root6) +
            "    // Answer: [1->2->4, 1->3->5, 1->3->6]"
        );


        // Test 7:
        //
        // Empty tree
        //
        // Answer: []
        TreeNode root7 = null;

        System.out.println(
            "Test 7: " +
            solution.binaryTreePaths(root7) +
            "    // Answer: []"
        );


        // Test 8:
        //
        //          10
        //         /  \
        //        5    15
        //       / \     \
        //      3   7     20
        //
        // Answer: [10->5->3, 10->5->7, 10->15->20]
        TreeNode root8 = new TreeNode(10);

        root8.left = new TreeNode(5);
        root8.right = new TreeNode(15);

        root8.left.left = new TreeNode(3);
        root8.left.right = new TreeNode(7);

        root8.right.right = new TreeNode(20);

        System.out.println(
            "Test 8: " +
            solution.binaryTreePaths(root8) +
            "    // Answer: [10->5->3, 10->5->7, 10->15->20]"
        );
    }
}