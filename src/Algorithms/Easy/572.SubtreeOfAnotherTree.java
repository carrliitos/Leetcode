/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        /* Logic: 
        *    We're given some tree s and some tree t, and we want to know if tree t
        *    exists somewhere entirely in tree s. The entire subtree of s must occur in the subtree t, so
        *    
        *    tree s:    3          tree t:     4
        *              / \                    / \
        *             4   5                  1   2
        *            / \
        *           1   2
        *    This will return true because the entirety of tree s occurs in tree t.
        *    
        *    tree x:   3        tree y:   4
        *             / \                / \
        *            4   5              1   2
        *           / \
        *          1   2
        *             /
        *            0
        *    This will return false, because tree y is missing a node. Because we are considering all of the
        *    descendants of 4, we have to include that 0 node. 
        *    To compare, what we really want to do is 'overlay' tree s on top of tree t, and ask "does this tree t exist
        *    on this tree s?" - if not, then we traverse to the children of tree s, and do the same thing. 
        *    If it does, we return true. We want to match all the nodes at every level to account for the second example.
        */
        
        // We first check that our tree s is not null, otherwise there's no way the subtree exists
        if(s == null) {
            return false;
        }else if(isSameTree(s, t)) { // otherwise, if they are the SAME tree, we return true
            return true;
        }else { // if we cant find the node at the current level we are on, we move on to the next level
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
    
    // recursive function to check if they are the same tree
    public boolean isSameTree(TreeNode s, TreeNode t){
        // check if either of them are null, then they are not the same tree
        if(s == null || t == null) {
            return s == null && t == null;
        }else if(s.val == t.val) { // check if they have the same value, and if true, recur
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }else { // check if we have two nodes whose values do not match, return false
            return false;
        }
    }
}

/* Runtime: O(m*n), where m = # of nodes in s, n = # of nodes in t
*    - We're traversing every single node in s, looking for the entirety of subtree t
*    - For every single node in s, we're making m comparisons against entire subtree of t
*    
*  Space Complexity: O(m - n)
*    - The minimum between m and n, because if m = # of nodes in s, and n = # of nodes in t, the limiting
*        factor of how deep our recursion factor goes is going to be whichever tree has less nodes
*/