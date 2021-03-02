/*
 * Problem: Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if 
 *  needle is not part of haystack.
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        
        if(needleLength == 0) { return 0; }
        
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        int haystackPointer = 0;
        int needlePointer = 0;
        
        // Traverse the haystack
        while(haystackPointer < haystackLength) {
            // If the current characters are equal, increment the needle
            if(haystackCharArray[haystackPointer] == needleCharArray[needlePointer]) {
                needlePointer++;
            } else { // Otherwise, reset the needle pointer, go backwards in the haystack pointer
                haystackPointer -= needlePointer;
                needlePointer = 0;
            }
            
            // Increment the haystack pointer
            haystackPointer++;
            
            // If we've found a match for every character in needle in the haystack
            // return the current index minus the length of the needle (start of the needle in the haystack)
            if(needlePointer == needleLength) {
                return haystackPointer - needlePointer;
            }
        }
        
        // Otherwise, needle is not part of the haystack
        return -1;
    }
}

/*
 * Runtime: O(n), n = length of the haystack
 *  - Since we are only traversing the length of the haystack and returning
 *  (-1) if we've traversed the haystack without finding the needle, thus the 
 *	needle is not part of the haystack.
 *
 * Space Complexity: O(n), n = length of the haystack
 * 	- We are not using any additional arrays, simply the overall length of the
 *	haystack.
 */