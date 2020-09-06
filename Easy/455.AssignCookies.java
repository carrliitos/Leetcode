class Solution {
    public int findContentChildren(int[] g, int[] s) {
        /* Logic:
        *   If the size of the cookie >= greed factor, we can assign the cookie to the child to content the child.
        *   Goal: To maximize the content children and output that number.
        *   
        *   This is a greedy approach -- we want to try to give away the largest cookie to the child with the
        *   largest greed factor. Because that's what's going to make sure that the most amount of children are satisfied.
        *   (Naturally, the largest cookie should go to the greediest child). This means, both our 
        *   arrays need to be sorted, in ascending order, this eliminates doing a linear scan. 
        *   Then we can make our pointers point to the largest cookie and to the greediest child 
        *   then make a comparison, "is this cookie big enough to satisfy this greedy child?" If so, 
        *   give the cookie to the child and move the pointers to the next cookie and child.
        */
        
        // Sort our arrays
        Arrays.sort(g);
        Arrays.sort(s);
        // our return value
        int contentChildren = 0;
        // pointers to keep track of the largest cookie and greediest child
        int i = g.length - 1; // pointer for the greediest child
        int j = s.length - 1; // pointer for the largest cookie
        // while we have a child to consider and cookie to give away, lets make the child happy
        while(i >= 0 && j >= 0) {
            // if the size of our cookie >= greed factor, then we can give away that cookie to that child
            if(s[j] >= g[i]) {
                contentChildren++;
                // decrement to make sure we dont give away cookies we've already given to children with cookies
                i--;
                j--;
            }else { // otherwise, we just move on to the next greediest child
                i--;
            }
        }
        
        // return the number of content children
        return contentChildren;
    }
}

/* Runtime: O(nlogn + mlogm)
*   - Will come from the overhead of sorting both arrays
*   - possible that both arrays might have different lengths
*  Space complexity: O(1)
*   - We have constant variables used
*/