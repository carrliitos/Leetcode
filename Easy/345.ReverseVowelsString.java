class Solution {
    public String reverseVowels(String s) {
        /* A couple of things: (1) we need to identify whether or not something is a vowel, (2) the logic to reverse the 
        *   string. We'll make a HashSet of characters, then just throw all our vowels in, which will give us O(1) time
        *   to determine whether or not a certain character is a vowel.
        *   We'll also have two pointers, one for finding a vowel at the beginning, and another for finding a vowel
        *   at the end, then we switch them.
        */
        // create HashSet of vowels
        Set<Character> vowels = new HashSet<>();
        // add all of our vowels -- good thing to ask the interviewer if our input will contain upper and lower cases
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        // create character array to manipulate or string
        char[] characters = s.toCharArray();
        // pointer to start at the beginning of string
        int i = 0;
        // pointer to start at the end of the string
        int j = s.length() - 1;
        // while our pointers have not crossed, we know we still characters to check
        while(i < j) {
            // find a vowel for the i pointer
            while(i < j & !vowels.contains(characters[i])) {
                i++;
            }
            // find a vowel for the j pointer
            while(i < j & !vowels.contains(characters[j])) {
                j--;
            }
            // do the swapping
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--] = temp;
        }
        // return the string with our vowels having been reversed
        return new String(characters);
    }
}

/* Runtime: O(n), n = # of characters in our string
*   - we're really only passing through the string once
*
*  Spacetime: O(n)
*   - Since Java has immutable strings, we needed to make a copy of our string, which is O(n)
*/