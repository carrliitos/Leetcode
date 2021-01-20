class Solution {
    public int removeDuplicates(int[] nums) {
        // Check for edge cases
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        // create two pointers, each pointing to the current and current + 1 index
        int i = 0;
        int j = 1;
        
        // let the pointers walk the length of the array and start comparing
        while(i < nums.length && j < nums.length) {
            // if the current number already exists, we skip
            if(nums[j] == nums[i]) j++;
            else { // we move on to the next number
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        
        // The resultant index will hold the number of unique elements
        return i + 1;
    }
}

/* Runtime: O(n), where n = nums.length
*  The while-loop only goes through the nums array
* Space Complexity: O(1)
*  Per problem constraint, we cannot create any additional spaces and must only
*  use the input array.
*/