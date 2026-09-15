// ============================ JULY-AUGUST PRACTICE ============================

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
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

// RANK 1: Recursive Tree Comparison (DFS) — O(m × n) Time, O(h) Space — BEST PRACTICAL / SIMPLEST / MOST EFFICIENT
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSame(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return isSame(a.left, b.left) &&
               isSame(a.right, b.right);
    }
}


// RANK 2: Serialize Tree + String Matching — O(m + n) Time, O(m + n) Space — EFFICIENT / GOOD ALTERNATIVE
// class Solution {
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String s1 = serialize(root);
//         String s2 = serialize(subRoot);

//         return s1.contains(s2);
//     }

//     private String serialize(TreeNode node) {
//         if (node == null) {
//             return "#";
//         }

//         return "," + node.val
//                 + serialize(node.left)
//                 + serialize(node.right);
//     }
// }

// RANK 3: BFS Traversal + DFS Comparison — O(m × n) Time, O(h + w) Space — GOOD ALTERNATIVE / NON-RECURSIVE OUTER TRAVERSAL

// class Solution {
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if (root == null) {
//             return false;
//         }

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         while (!q.isEmpty()) {
//             TreeNode node = q.poll();

//             if (node.val == subRoot.val && isSame(node, subRoot)) {
//                 return true;
//             }

//             if (node.left != null) {
//                 q.offer(node.left);
//             }

//             if (node.right != null) {
//                 q.offer(node.right);
//             }
//         }

//         return false;
//     }

//     private boolean isSame(TreeNode a, TreeNode b) {
//         if (a == null && b == null) {
//             return true;
//         }

//         if (a == null || b == null) {
//             return false;
//         }

//         if (a.val != b.val) {
//             return false;
//         }

//         return isSame(a.left, b.left) && isSame(a.right, b.right);
//     }
// }


// RANK 4: Hashing — O(m + n) Average Time, O(m + n) Space — ADVANCED / COMPETITIVE PROGRAMMING / MORE COMPLEX

// class Solution {

//     private static final long MOD = 1_000_000_007L;
//     private static final long BASE = 31L;

//     Set<Long> subtreeHashes = new HashSet<>();

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         computeHash(root);

//         long subRootHash = computeSingleHash(subRoot);

//         return subtreeHashes.contains(subRootHash);
//     }

//     private long computeHash(TreeNode node) {
//         if (node == null) {
//             return 3;
//         }

//         long left = computeHash(node.left);
//         long right = computeHash(node.right);

//         long hash = (left * BASE * BASE) % MOD;
//         hash = (hash + node.val * BASE) % MOD;
//         hash = (hash + right) % MOD;

//         subtreeHashes.add(hash);

//         return hash;
//     }

//     private long computeSingleHash(TreeNode node) {
//         if (node == null) {
//             return 3;
//         }

//         long left = computeSingleHash(node.left);
//         long right = computeSingleHash(node.right);

//         long hash = (left * BASE * BASE) % MOD;
//         hash = (hash + node.val * BASE) % MOD;
//         hash = (hash + right) % MOD;

//         return hash;
//     }
// }


// Driver code to test the Solution class
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {

        // Main tree:
        //
        //          3
        //         / \
        //        4   5
        //       / \
        //      1   2
        //
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Subtree:
        //
        //        4
        //       / \
        //      1   2
        //
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        Solution obj = new Solution();

        // Test 1
        System.out.println("Is Subtree: " + obj.isSubtree(root, subRoot));
        // Is Subtree: true


        // Test 2
        // Subtree:
        //
        //        4
        //       / \
        //      1   5
        //
        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(5);

        System.out.println("Is Subtree: " + obj.isSubtree(root, subRoot2));
        // Is Subtree: false


        // Test 3
        // Single-node subtree
        TreeNode subRoot3 = new TreeNode(5);

        System.out.println("Is Subtree: " + obj.isSubtree(root, subRoot3));
        // Is Subtree: true
    }
}