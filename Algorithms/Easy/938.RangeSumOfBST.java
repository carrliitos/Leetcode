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
    public int rangeSumBST(TreeNode root, int L, int R) {
        /* Based on the problem description, we're given a left and a right bound in terms of integer values that we want 
        *   to look for. And any values that fall within those two boundaries, inclusive, we want to add to our running
        *   sum, then return that sum once we've traversed through our tree.
        */
        
        // We do some quick error checking
        int sum = 0;
        if(root == null) return sum;
        
        // we need traverse this whole tree somehow, touching each node
        // we'll do a BFS traversal, which guarantees us reaching each node. 
        // Create the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // start the BFS -- while the queue is not empty, we have some processing to do
        while(!queue.isEmpty()) {
            // get the node that is in our queue
            TreeNode current = queue.remove();
            // is the current node within our boundary? If it is, we add it to our running sum
            if(current.val >= L && current.val <= R) sum += current.val;
            // check -- do we have a left child to traverse? should we even bother going there? vice versa
            if(current.left != null && current.val > L) queue.add(current.left);
            if(current.right != null && current.val < R) queue.add(current.right);
        }
        // All nodes should have been processed after the while loop
        return sum;
    }
}

/* Runtime: O(n)
*   - we have n number of nodes in our tree that we need to traverse
*   - In the worst case, all the nodes inside of our tree are going to be within our left and right bounds
*
*  Space Complexity: O(n)
*   - We're potentially storing all n nodes in our queue
*/