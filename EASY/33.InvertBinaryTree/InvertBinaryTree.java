// ============================ JULY-AUGUST PRACTICE ============================

// Definition for a binary tree node.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// RANK 1: Recursive DFS – Preorder — O(n), O(h) — BEST PRACTICAL / SIMPLEST / MOST EFFICIENT
 class Solution {
     public TreeNode invertTree(TreeNode root) {
         if (root == null) {
             return null;
         }

         TreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;

         invertTree(root.left);
         invertTree(root.right);
         return root;
     }
 }

// RANK 2: Iterative DFS – Stack — O(n), O(h) — BEST NON-RECURSIVE / EFFICIENT
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         if (root == null) {
//             return null;
//         }
//         stack.push(root);
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();

//             TreeNode temp = node.left;
//             node.left = node.right;
//             node.right = temp;

//             if (node.left != null) {
//             stack.push(node.left);
//             }
//             if (node.right != null) {
//             stack.push(node.right);
//             }
//         }

//         return root;
//     }
// }

// RANK 3: Iterative BFS – Queue — O(n), O(w) — LEVEL-ORDER / GOOD PRACTICAL
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         if (root == null) {
//             return null;
//         }
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             TreeNode node = queue.poll();

//             TreeNode temp = node.left;
//             node.left = node.right;
//             node.right = temp;

//             if (node.left != null) {
//                 queue.offer(node.left);
//             }
//             if (node.right != null) {
//                 queue.offer(node.right);
//             }
//         }
//         return root;
//     }
// }

// RANK 4: Recursive DFS – Postorder — O(n), O(h) — CORRECT / LESS SIMPLE
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
//         TreeNode left = invertTree(root.left);
//         TreeNode right = invertTree(root.right);

//         root.left = right;
//         root.right = left;

//         return root;
//     }
// }

// Driver code to test the Solution class
public class InvertBinaryTree {
    public static void main(String[] args) {

        // Create binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Create Solution object
        Solution obj = new Solution();

        // Invert the binary tree
        TreeNode result = obj.invertTree(root);

        // Print inverted tree using preorder traversal
        System.out.print("Inverted Tree (Preorder): ");
        printPreorder(result);
    }

    // Preorder traversal: Root → Left → Right
    public static void printPreorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}