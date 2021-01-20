class Solution {
    public String reverseOnlyLetters(String S) {
        /* Logic: 
        *   Classical twist on reverse a string. 
        *   We're going to have two pointers, a head pointer, to check for letters at the beginning of
        *   the given string, and tail pointer, to check for letters at the tail-end of our given string.
        *   If either pointer comes across a non-letter, they will ignore it and move on to the next spot.
        *   And if they do come across a letter, then both pointers will switch them.
        */
        
        // First, create a character array, because strings in Java ar immutable
        char[] characters = S.toCharArray();
        // Pointer head will start at the beginning of our string
        int head = 0;
        // pointer tail will start at the end of our string
        int tail = S.length() - 1;
        
        // while we have our pointers walk through our string, let's do our swapping
        while(head < tail) {
            // here, we make sure that our head is pointing at a letter, if not, we increment head
            while(head < tail && !Character.isLetter(S.charAt(head))) {
                head++;
            }
            // do the exact same thing for the tail-end as above
            while(tail > head && !Character.isLetter(S.charAt(tail))) {
                tail--;
            }
            // Easy part, this is where swap the letters and increment/decrement respectively
            char temp = characters[head];
            characters[head++] = characters[tail];
            characters[tail--] = temp;
        }
        // return the new string
        return new String(characters);
    }
}

/* Runtime: O(n), n = # of characters in our string
*   - O(n) in terms of our characters in our string
*       - Because the while-loop is traversing all of the characters with our pointers
*  Space Complexity: O(n)
*   - We're taking String S and converting it to a character array, which means we need n slots to hold those n letters
*/