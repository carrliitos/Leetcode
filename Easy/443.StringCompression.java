class Solution {
    public int compress(char[] chars) {
        /* Logic:
            All we need to do is iterate through the strings, i,
            and then we need to know that for every single character that we are on, i, 
            how many characters, following that ith character are the same?
            
            We'll have a pointer at i, initially start a 0, and a pointer j that will 
            walk through our given string, counting how many times we see that character.
            
            As soon as j sees a not-the-same character, we'll know how many times the
            previous same character has occured. Then move on to the next character and 
            do the same.
            
            We return the number of characters we have on the final answer.
            (input)         ["a", "a", "b", "b", "b", "c", "c", "c"]
            (output)        return 6
            (output array)  ["a", "2", "b", "3", "c", "3"]
            
            If we have a situation where a character only occurs once, then we only
            return 1 and there would be no change in the output array
        */
        // Do a quick check
        if(chars == null || chars.length < 1) return 0;
        
        // Keep track of the index -- we need a place to store the letter or char we are
        // currently on
        int index = 0;
        // the pointer we'll walk through with
        int i = 0;
        // We start to walk through the length of the characters
        while(i < chars.length) {
            // second pointer that initially points to i and starts walking to find the 
            // same character as the current position of i
            int j = i;
            // j will start walking forward while it is equal to i
            while(j < chars.length && chars[i] == chars[j]) { // make sure we are in bounds and characters of j is equal to characters of i 
                j++; // we just want to increment j
            }
            
            // when the inner while loop breaks we want to be able to record the characters that j just saw
            chars[index++] = chars[i];
            // if we saw that character more than once, then we compress it
            if(j - i > 1) {
                // turn j - i into a string
                String count = j - i + "";
                // then we want to walk through every character in that count and place it into our characters array
                for(char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }
            
            // make sure to update i so that j can start at a character it has not seen
            i = j;
        }
        // return the index -- it will represent the new length of the compressed array
        return index;
    }
}

/* Runtime: O(n)
    - We're just walking through the entire length of the characters
    - Even though nested while-loop looks scary, we're just walking the second pointer further, and moving the first pointer at every
        character the second pointer has not seen
    
 Space Complexity: O(1)
    - We're not using extra data strucutes
    - We're only using a couple of simple variables, index, i, j, count
*/