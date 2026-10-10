// ============================ JULY-AUGUST PRACTICE ============================

//  Definition for a binary tree node.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

// RANK 1: Recursive DFS (BEST / MOST COMMON) — O(n), O(h)
class Solution {

    List<TreeNode> result = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// // RANK 2: Iterative DFS Using Stack — O(n), O(h)
// class Solution {

//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         Stack<TreeNode> stack = new Stack<>();

//         stack.push(p);
//         stack.push(q);
//         while (!stack.isEmpty()) {

//             TreeNode n1 = stack.pop();
//             TreeNode n2 = stack.pop();
//             if (n1 == null && n2 == null) {
//                 continue;
//             }
//             if (n1 == null || n2 == null) {
//                 return false;
//             }
//             if (n1.val != n2.val) {
//                 return false;
//             }

//             stack.push(n1.left);
//             stack.push(n2.left);
//             stack.push(n1.right);
//             stack.push(n2.right);
//         }
//         return true;

//     }
// }

// RANK 3: Iterative BFS Using Queue — O(n), O(w)

// class Solution {

//     public boolean isSameTree(TreeNode p, TreeNode q) {

//         Queue<TreeNode> queue = new LinkedList<>();

//         queue.offer(p);
//         queue.offer(q);
//         while (!queue.isEmpty()) {

//             TreeNode n1 = queue.poll();
//             TreeNode n2 = queue.poll();
//             if (n1 == null && n2 == null) {
//                 continue;
//             }
//             if (n1 == null || n2 == null) {
//                 return false;
//             }
//             if (n1.val != n2.val) {
//                 return false;
//             }

//             queue.offer(n1.left);
//             queue.offer(n2.left);
//             queue.offer(n1.right);
//             queue.offer(n2.right);
//         }
//         return true;

//     }
// }

// RANK 4: Tree Serialization & String Comparison — O(n), O(n)
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         return serialize(p).equals(serialize(q));
//     }

//     private String serialize(TreeNode root) {
//         if (root == null) return "#";
//         return root.val + "," +
//                serialize(root.left) + "," +
//                serialize(root.right);
//     }
// }

// Driver code to test the Solution class
public class SameTree {

    public static void main(String[] args) {

        // Tree 1
        //       1
        //      / \
        //     2   3
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        //       1
        //      / \
        //     2   3
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        Solution sol = new Solution();
        boolean ans = sol.isSameTree(p, q);

        System.out.println("Are the trees same? " + ans);
    }
}