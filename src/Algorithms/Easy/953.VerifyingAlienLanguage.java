class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        /* Logic:
        *   - Given an order of characters for this specific alien language, and a list of words,
        *   check if the words that were given are sorted lexicographically -- IDK this problem was a bit confusing,
        *   I had to attempt it either way.
        *
        *   - So, we're making sure that the strings are in alphabetical order, but the only difference is that they
        *   the "aliens" have a different order for their letters.
        *   - We need to know where something occurs in order
        *       - We could put every single ASCII value into an integer array, then map it to the ordered they appeared in.
        *       It will help us to know where inside of our order string a scpecifc letter occurs.
        */
        
        // we want an integer array to allow for quick access
        int[] alphabet = new int[26]; // 26 lower case letters
        // iterate through our order and place things in our alphabet
        for(int i = 0; i < order.length(); i++) {
            // put this character in our alphabet
            alphabet[order.charAt(i) - 'a'] = i; // this allows us a constant time access
        }
        
        for(int i = 0; i < words.length; i++) {
            // we compare to every other word
            for(int j = i + 1; j < words.length; j++) {
                // create our boundaries
                int min = Math.min(words[i].length(), words[j].length());
                // create another pointer to compare all k characters in each of our words
                for(int k = 0; k < min; k++) {
                    // get the two characters to compare (kth character of ith word, and kth character of jth word)
                    char iChar = words[i].charAt(k);
                    char jChar = words[j].charAt(k);
                    
                    // if ith char < jth char, then we are done
                    if(alphabet[iChar - 'a'] < alphabet[jChar - 'a']) break;
                    // if it is the opposite, as above, return false
                    else if(alphabet[jChar - 'a'] < alphabet[iChar - 'a']) return false;
                    // hidden check: if the ith word is also > jth word, also a problem
                    else if(k == min - 1 && words[i].length() > words[j].length()) return false;
                }
            }
        }
        // we know they are lexicographically sorted, so return true
        return true;
    }
}

/* Runtime: O(n^2*m)
*   - We're comparing every word with every other word = n^2
*   - We're also comparing m letters
*
* Space Complexity: O(1)
*   - There were only going to have 26 letters ever
*/