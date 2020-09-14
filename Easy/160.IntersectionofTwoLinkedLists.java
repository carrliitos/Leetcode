/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /* We're given two linked lists and we're to return the number at which both linked lists begin to intersect.
        *   When looking for the intersection of two things, it's very useful to keep track of what we'ver already seen.
        *   We could do this by using a HashMap or a HashSet. Throw the entire first (or second) list to our HashSet,
        *   then walk through the other list, and compare if this list is on the HashSet.
        */
        // Create HashSet
        Set<ListNode> visited = new HashSet<>();
        // traverse one of the list
        while(headA != null) {
            // we need to add to visited, headA
            visited.add(headA);
            // move headA to the next node
            headA = headA.next;
        }
        
        // start the process of walking through list B
        while(headB != null) {
            // if we've already seen this node in headB
            if(visited.contains(headB)) {
                // return it because it's the first occurence of the intersection
                return headB;
            }
            headB = headB.next;
        }
        
        // if we don't find any intersection, just return null
        return null;
    }
}

/* Runtime: O(n), n = total # of nodes in both of our list
*   - We're going throuugh every single node in list A, and every single node in list B
* Space Complexity: O(n), n = total # of nodes in both of our list
*   - HashSet called visited, theoretically can store all the nodes we have available
*/