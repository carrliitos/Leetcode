class Solution {
    public int lastStoneWeight(int[] stones) {
        /* Basically, we have a bunch of rocks, and we want to greedily take the two largest/heaviest rocks, smash
        *   them together, and if the two are equal, they're both detroyed, and if one stone (stone_a) is greater than
        *   the other (stone_b), then basically stone_a takes on the new weight of the difference between 
        *   both stones.
        *   
        *   We'll be creating a max-heap; we can throw all our stones into a max-heap, take the two stones that are at the
        *   top of the heap, smash them together, and go through with the logic above. Then we put back into the heap 
        *   whatever the difference is between both smashed rocks. We keep doing this until we have a heap of size == 1,
        *   or when we have no stones left, then we take care of edge cases provided by the problem. 
        */
        
        // make the max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        // throw everything into our maxHeap, so that we make sure we have the two heaviest stones
        for(int stone : stones) {
            maxHeap.add(-stone); // Java is min heap by default, so we do the negative of whatever we're inserting
        }
        // simulate the rock smashing
        while(maxHeap.size() > 1) {
            int stoneOne = -maxHeap.remove(); // access stone 1
            int stoneTwo = -maxHeap.remove(); // access stone 2
            // do the simple checks provided by the problem
            // if both stones are not the same, we need to put back into our heap the difference between the two
            if(stoneOne != stoneTwo) {
                maxHeap.add(-(stoneOne - stoneTwo));
            }
        }
        
        // when loop ends, we either have one thing or nothing in our heap
        // if we have one thing, return it
        // if we have nothing return 0
        return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
    }
}

/* Runtime: O(nlogn)
*   - We're creating a max heap, this takes (nlogn) time everytime we're removing from it 
*  
*  Space Complexity: O(n)
*   - We're actually throwing everything in our heap, O(n) memory
*/